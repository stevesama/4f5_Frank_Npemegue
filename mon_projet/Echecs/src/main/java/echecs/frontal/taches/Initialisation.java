 
package echecs.frontal.taches;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import echecs.frontal.vues.VueRacine;
import echecs.frontal.vues.VueParametreDeJeu;
import echecs.frontal.vues.VueParametres;

public class Initialisation {

	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("Initialisation")
			.contains(subTasks -> {
				afficherFenetre(subTasks);
				
				creerVueRacine(subTasks);
				creerVueFileAttente(subTasks);
				
				creerVuePartie(subTasks);
				
				installerVueRacine(subTasks);
				installerVueFileAttente(subTasks);	
				
				

			});
		
	}
	
	
	private static void afficherFenetre(FrontendTasks tasks) {

	        tasks.task("afficherFenetre")

	          .waitsFor(window())

	          .thenExecutes(inputs -> {

	              Window window = inputs.get(window());
	             //window.resize(15, 20);

	              window.show();
	          });
	    }
	
	private static void creerVuePartie(FrontendTasks tasks) {
		tasks.task(create(VueParametres.class))
			.waitsFor(viewLoader(VueParametres.class))
			.thenExecutesAndReturnsValue(inputs -> {
				ViewLoader<VueParametres> viewLoader = inputs.get(viewLoader(VueParametres.class));
				VueParametres vuePartie = viewLoader.createView();
				return vuePartie;
			});
	}
	
	private static void creerVueRacine(FrontendTasks tasks) {
		tasks.task(create(VueRacine.class))
		.waitsFor(viewLoader(VueRacine.class))
		.thenExecutesAndReturnsValue(inputs -> {
		ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));
		VueRacine vueRacine = viewLoader.createView();
		return vueRacine;
		});
		
	}
	
	private static void installerVueRacine(FrontendTasks tasks) {
		tasks.task("installerVueRacine")
		.waitsFor(window())
		.waitsFor(created(VueRacine.class))
		.thenExecutes(inputs -> {
		
		VueRacine vueRacine = inputs.get(created(VueRacine.class));
		Window window = inputs.get(window());
	
		window.installRootView(vueRacine);
	});
	}
	
	private static void installerVueFileAttente(FrontendTasks tasks) {
        tasks.task("installerVueFileAttente")

        .waitsFor(created(VueRacine.class))

        .waitsFor(created(VueParametreDeJeu.class))

        .thenExecutes(inputs -> {

            VueRacine        vueRacine       = inputs.get(created(VueRacine.class));
            VueParametreDeJeu   vueFileAttente  = inputs.get(created(VueParametreDeJeu.class));

            vueRacine.afficherSousVue(vueFileAttente);
        });
    }


    private static void creerVueFileAttente(FrontendTasks tasks) {
        tasks.task(create(VueParametreDeJeu.class))

        .waitsFor(viewLoader(VueParametreDeJeu.class))


        .thenExecutesAndReturnsValue(inputs -> {

            ViewLoader<VueParametreDeJeu> viewLoader = inputs.get(viewLoader(VueParametreDeJeu.class));
            VueParametreDeJeu vueFileAttente = viewLoader.createView();

            return vueFileAttente;
        });
    }
}
