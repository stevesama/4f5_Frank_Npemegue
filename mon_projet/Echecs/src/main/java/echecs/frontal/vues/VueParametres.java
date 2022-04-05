package echecs.frontal.vues;

import javafx.scene.control.Button;


import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echecs.frontal.evenements.EvtAfficherFileAttente;
import echecs.frontal.vues.controles.CanvasPartie;
import echecs.modeles.monde_echecs2d.MondeEchecs2d;
import javafx.fxml.FXML;

public class VueParametres extends ViewFx{

    @FXML
    private Button boutonQuitterParametres;
    @FXML
    private CanvasPartie canvasPartie;
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        Ntro.assertNotNull("boutonQuitterParametres", boutonQuitterParametres);
        installerEvtAfficherFileAttente();
        Ntro.assertNotNull("canvasPartie", canvasPartie);
        initialiserCanvasPartie();
    }
    


    private void initialiserCanvasPartie() {
    	canvasPartie.setWorldWidth(MondeEchecs2d.LARGEUR_MONDE);
    	canvasPartie.setWorldHeight(MondeEchecs2d.HAUTEUR_MONDE);

    }


    private void installerEvtAfficherFileAttente() {
        EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
        boutonQuitterParametres.setOnAction(evtFx -> {
            System.out.println("[VueParametres] clic: " + evtFx.getEventType());
            evtNtro.trigger();
        });
    }
    
    public void viderCanvas() {
    	canvasPartie.clearCanvas();
    }
    
    
    public void afficherImagesParSeconde(String fps) {
    	canvasPartie.displayFps(fps);
    }
    
    public void afficherEchecs2d(MondeEchecs2d mondeEchecs2d) {
    	canvasPartie.displayWorld2d(mondeEchecs2d);
    }

}