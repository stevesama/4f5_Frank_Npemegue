package echecs.frontal.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echecs.frontal.evenements.EvtAfficherPartie;
import echecs.frontal.vues.fragments.FragmentPolice;
import echecs.messages.MsgAjouterPolice;
import javafx.fxml.FXML;


public class VueParametreDeJeu extends ViewFx {
	
	 @FXML
	 private Button boutonAjouterPolice;
	 @FXML
	 private VBox conteneurPolice;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonAjouterPolice", boutonAjouterPolice);
		Ntro.assertNotNull("conteneurPolice", conteneurPolice);
        installerMsgAjouterPolice();
        
		

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
    
	
	
	
	
	
	
	
	
}