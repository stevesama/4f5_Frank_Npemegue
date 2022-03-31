package echecs.frontal.vues;

import javafx.scene.control.Button;


import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echecs.frontal.evenements.EvtAfficherFileAttente;
import javafx.fxml.FXML;

public class VueParametres extends ViewFx{

    @FXML
    private Button boutonQuitterParametres;
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        Ntro.assertNotNull("boutonQuitterParametres", boutonQuitterParametres);
        installerEvtAfficherFileAttente();
        
        
    }
    




    private void installerEvtAfficherFileAttente() {
        EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
        boutonQuitterParametres.setOnAction(evtFx -> {
            System.out.println("[VueParametres] clic: " + evtFx.getEventType());
            evtNtro.trigger();
        });
    }

}