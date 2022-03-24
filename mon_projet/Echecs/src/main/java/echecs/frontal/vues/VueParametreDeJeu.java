package echecs.frontal.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echecs.frontal.evenements.EvtAfficherPartie;
import echecs.messages.MsgAjouterPolice;
import javafx.fxml.FXML;


public class VueParametreDeJeu extends ViewFx {
	
	@FXML
	private Button boutonOuvrirParametres;
	 @FXML
	 private Button boutonAjouterPolice;
	 @FXML
	 private Label labelMessage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonOuvrirParametres", boutonOuvrirParametres);			
		Ntro.assertNotNull("boutonAjouterPolice", boutonAjouterPolice);
		Ntro.assertNotNull("labelMessage", labelMessage);
		installerEvtAfficherPartie();
        installerMsgAjouterPolice();
        
		

	}
	
private void installerMsgAjouterPolice() {
		
		MsgAjouterPolice msgAjouterPolice = NtroApp.newMessage(MsgAjouterPolice.class);
		
		boutonAjouterPolice.setOnAction(evtFx -> {
			
			msgAjouterPolice.setPolice(nomAleatoire());
			msgAjouterPolice.send();
			
			
		});
		
	}

private String nomAleatoire() {
	
	List<String> choixDePolice = List.of("Arial",
			                           "Calibri",
			                           "Abadi",
			                           "Tahoma",
			                           "Times New Roman",
			                           "Candara",
			                           "Helvetica");
	
	return Ntro.random().choice(choixDePolice);
}
    
	
	
	
	
	private void installerEvtAfficherPartie() {
		
		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);
		
		boutonOuvrirParametres.setOnAction(evtFx -> {
			
			 System.out.println("[VueParametreDeJeu] clic:" + evtFx.getEventType());
			 
			 evtNtro.trigger();
		});
	}

	
	
	public void afficherMessage(String message) {
		labelMessage.setText(message);
	}
}