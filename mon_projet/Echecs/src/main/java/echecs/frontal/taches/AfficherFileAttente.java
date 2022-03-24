package echecs.frontal.taches;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import echecs.frontal.vues.VueParametreDeJeu;
import echecs.modeles.ModeleParametreDeJeu;

public class AfficherFileAttente {
    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("AfficherFileAttente")
            .waitsFor("Initialisation")
            .andContains(subTasks -> {
                afficherFileAttente(subTasks);
                
            });
    }

    public static void afficherFileAttente(FrontendTasks tasks) {
        tasks.task("afficherFileAttente")
            .waitsFor(modified(ModeleParametreDeJeu.class))
            .executes(inputs -> {
                VueParametreDeJeu vueParametreDeJeu = inputs.get(created(VueParametreDeJeu.class));
                Modified<ModeleParametreDeJeu> parametreDeJeu = inputs.get(modified(ModeleParametreDeJeu.class));

                ModeleParametreDeJeu ancienneFile = parametreDeJeu.previousValue();
                ModeleParametreDeJeu fileCourante = parametreDeJeu.currentValue();
                
                fileCourante.afficherSur(vueParametreDeJeu);
            });
    }

}