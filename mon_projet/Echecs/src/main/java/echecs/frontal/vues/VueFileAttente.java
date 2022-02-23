package echecs.frontal.vues;

import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echecs.frontal.evenements.EvtAfficherPartie;
import javafx.fxml.FXML;


public class VueFileAttente extends ViewFx {
	
	@FXML
	private Button boutonOuvrirPartie;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonOuvrirPartie", boutonOuvrirPartie);
		
		installerEvtAfficherPartie();
	}
	
	
	private void installerEvtAfficherPartie() {
		
		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);
		
		boutonOuvrirPartie.setOnAction(evtFx -> {
			
			 System.out.println("[VueFileAttente] clic:" + evtFx.getEventType());
			 
			 evtNtro.trigger();
		});
	}

}
