package echecs.frontal.vues;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echecs.Session;
import echecs.frontal.evenements.EvtAfficherPartie;
import echecs.frontal.vues.fragments.FragmentPolice;
import echecs.messages.MsgAjouterNotification;
import echecs.messages.MsgAjouterPolice;
import echecs.messages.MsgChangerCouleurBackground;
import echecs.messages.MsgChoisirLangue;
import echecs.messages.MsgChoisirPieces;
import echecs.messages.MsgChoisirPolice;
import javafx.fxml.FXML;
import java.lang.Math;

public class VueParametreDeJeu extends ViewFx {

	@FXML
	private Button boutonAjouterPolice;
	@FXML
	private VBox conteneurPolice;
	@FXML
	private VBox backgroundColor;
	@FXML
	private ComboBox<String> policeCombo;
	@FXML
	private Label apercuPolice;
	@FXML
	private ColorPicker colorpicker;
	@FXML
	private CheckBox checkbox;
	@FXML
	private ComboBox<String> piecesCombo;
	@FXML
	private Button bouttonPremiereLangue;
	@FXML
	private Button bouttonDeuxiemeLangue;
	@FXML
	private Label choixDeLaLangue;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		Ntro.assertNotNull("boutonAjouterPolice", boutonAjouterPolice);
		Ntro.assertNotNull("conteneurPolice", conteneurPolice);
		Ntro.assertNotNull("policeCombo", policeCombo);
		Ntro.assertNotNull("apercuPolice", apercuPolice);
		Ntro.assertNotNull("colorpicker", colorpicker);
		Ntro.assertNotNull("backgroundColor", backgroundColor);
		Ntro.assertNotNull("checkbox", checkbox);
		Ntro.assertNotNull("piecesCombo", piecesCombo);
		Ntro.assertNotNull("bouttonPriemiereLangue", bouttonPremiereLangue);
		Ntro.assertNotNull("bouttonDeuxiemeLangue", bouttonDeuxiemeLangue);
		Ntro.assertNotNull("choixDeLaLangue", choixDeLaLangue);
		installerMsgAjouterPolice();
		installerChoisirPolice();
		installerColorPicker();
		installerChoisirNotifications();
		installerChoisirPieces();
		installerChoisirPremiereLangue();
		installerChoisirDeuxiemeLangue();

	}

	public void viderListePolice() {
		conteneurPolice.getChildren().clear();
	}

	private Pane petitEspaceVertical() {

		Pane petitEspaceVertical = new Pane();

		petitEspaceVertical.getStyleClass().add("petit-espace-vertical");

		return petitEspaceVertical;
	}

	public void ajouterPolice(FragmentPolice fragmentPolice) {

		conteneurPolice.getChildren().add(fragmentPolice.rootNode());

		conteneurPolice.getChildren().add(petitEspaceVertical());

	}

	private void installerMsgAjouterPolice() {

		MsgAjouterPolice msgAjouterPolice = NtroApp.newMessage(MsgAjouterPolice.class);

		boutonAjouterPolice.setOnAction(evtFx -> {

			msgAjouterPolice.setPolice(nomAleatoire());
			msgAjouterPolice.send();

		});

	}

	private void installerColorPicker() {
		MsgChangerCouleurBackground msgChangerCouleurBackground = NtroApp.newMessage(MsgChangerCouleurBackground.class);
		colorpicker.setOnAction(evtFx -> {
			// colorpicker.getValue().toString();
			Color c = colorpicker.getValue();
			List<Double> rgb = new ArrayList<>();
			rgb.add(c.getRed() * 255);
			rgb.add(c.getGreen() * 255);
			rgb.add(c.getBlue() * 255);
			changerCouleurBackground(rgb);
			msgChangerCouleurBackground.setRgb(rgb);
			msgChangerCouleurBackground.send();
			
		});

	}

	private void installerChoisirNotifications() {

		MsgAjouterNotification msgAjouterNotification = NtroApp.newMessage(MsgAjouterNotification.class);

		checkbox.setOnAction(evtFx -> {
			boolean notifications = checkbox.isSelected();
			msgAjouterNotification.setNotifications(notifications);
			msgAjouterNotification.send();

		});

	}

	public void afficherPoliceCourante(String policeCourante) {

		apercuPolice.setText("La police choisi est: " + policeCourante);
	}
	
	

	private String nomAleatoire() {

		List<String> choixDePolice = List.of("Arial", "Calibri", "Abadi", "Tahoma", "Times New Roman", "Candara",
				"Helvetica");

		return Ntro.random().choice(choixDePolice);
	}

	public void changerPolice(String policeCourante) {

		apercuPolice.setFont(Font.font(policeCourante));
	}

	public void changerCouleurBackground(List<Double> rgb) {
		
		backgroundColor.setStyle("-fx-background-color: rgb(" + rgb.get(0) + "," + rgb.get(1) + "," + rgb.get(2) + ")");
	}
	
	private void installerChoisirPolice() {

		MsgChoisirPolice msgChoisirPolice = NtroApp.newMessage(MsgChoisirPolice.class);

		policeCombo.setOnAction(evtFx -> {
			String policeCourante = policeCombo.getValue();
			afficherPoliceCourante(policeCourante);
			msgChoisirPolice.setPoliceCourante(policeCourante);
			msgChoisirPolice.send();

		});

	}
	
	private void installerChoisirPieces() {

		MsgChoisirPieces msgChoisirPieces = NtroApp.newMessage(MsgChoisirPieces.class);

		piecesCombo.setOnAction(evtFx -> {
			String pieces = piecesCombo.getValue();
			msgChoisirPieces.setPieces(pieces);
			msgChoisirPieces.send();

		});

	}
	
	private void installerChoisirPremiereLangue() {

		MsgChoisirLangue msgChoisirLangue = NtroApp.newMessage(MsgChoisirLangue.class);

		bouttonPremiereLangue.setOnAction(evtFx -> {
			msgChoisirLangue.setLangue("Francais");
			msgChoisirLangue.send();


		});

	}
	
	private void installerChoisirDeuxiemeLangue() {

		MsgChoisirLangue msgChoisirLangue = NtroApp.newMessage(MsgChoisirLangue.class);

		bouttonDeuxiemeLangue.setOnAction(evtFx -> {
			msgChoisirLangue.setLangue("Anglais");
			msgChoisirLangue.send();


		});

	}
	
	public void ModifierLangue(String choixLangue) {

		choixDeLaLangue.setText(choixLangue);
	}
	
	

}