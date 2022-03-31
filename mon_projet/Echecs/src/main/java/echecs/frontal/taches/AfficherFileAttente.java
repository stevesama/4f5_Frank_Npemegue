package echecs.frontal.taches;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import echecs.frontal.vues.VueParametreDeJeu;
import echecs.frontal.vues.fragments.FragmentPolice;
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
            
            .waitsFor(viewLoader(FragmentPolice.class))
            .executes(inputs -> {
            	VueParametreDeJeu  vueParametreDeJeu  = inputs.get(created(VueParametreDeJeu .class));
                Modified<ModeleParametreDeJeu> detailParametre = inputs.get(modified(ModeleParametreDeJeu.class));
                
                ViewLoader<FragmentPolice>     viewLoaderPolice  = inputs.get(viewLoader(FragmentPolice.class));

               
                detailParametre.currentValue().afficherSur(vueParametreDeJeu,
                		viewLoaderPolice);
            });
    }

}
