package echecs.frontal.vues.fragments;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echecs.frontal.evenements.EvtAfficherPartie;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FragmentPolice extends ViewFx {
	
	@FXML
	private Button boutonOuvrirParametre;
	
	@FXML
	private Label labelPolice;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonOuvrirParametre", boutonOuvrirParametre);
		Ntro.assertNotNull("labelPolice", labelPolice);

		installerEvtAfficherPartie();
	}
	
	private void installerEvtAfficherPartie() {
		
		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);
		
		boutonOuvrirParametre.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}
	
	public void afficherPolice(String police) {
		labelPolice.setText(police);
	}

}
