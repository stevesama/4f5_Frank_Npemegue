package echecs.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import echecs.frontal.evenements.EvtAfficherFileAttente;
import echecs.frontal.evenements.EvtAfficherPartie;
import echecs.frontal.vues.VueParametreDeJeu;
import echecs.frontal.vues.VueParametres;
import echecs.frontal.vues.VueRacine;

public class Navigation {
	
	
	public static void creerTaches(FrontendTasks tasks) {
	tasks.taskGroup("Navigation")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			
			afficherVueFileAttente(subTasks);
			creerVuePartie(subTasks);
			afficherVuePartie(subTasks);
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
	
	private static void afficherVuePartie(FrontendTasks tasks) {
		tasks.task("afficherVuePartie")
		
			.waitsFor(created(VueParametres.class))
			
			.waitsFor(event(EvtAfficherPartie.class))
			
			.thenExecutes(inputs -> {
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueParametres vuePartie = inputs.get(created(VueParametres.class));
				
				vueRacine.afficherSousVue(vuePartie);
			});
	}
	
	private static void afficherVueFileAttente(FrontendTasks tasks) {
		tasks.task("afficherVueFileAttente")
		
			.waitsFor(event(EvtAfficherFileAttente.class))
			
			.thenExecutes(inputs -> {
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueParametreDeJeu vueFileAttente = inputs.get(created(VueParametreDeJeu.class));
				
				vueRacine.afficherSousVue(vueFileAttente);
			});
			
	}

}