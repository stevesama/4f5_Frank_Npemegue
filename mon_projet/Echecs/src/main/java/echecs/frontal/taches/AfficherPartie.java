package echecs.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import echecs.frontal.vues.VueParametres;
import echecs.frontal.vues.donnees.DonneesVuePartie;

public class AfficherPartie {
	
	public static void creerTaches(FrontendTasks tasks) {
		
		creerDonneesVuePartie(tasks);
		
		tasks.taskGroup("AfficherPartie")
		
		    .waitsFor(created(DonneesVuePartie.class))
		    
		    .andContains(subTasks -> {
		    	
		    	prochaineImagePartie(subTasks);
		    });
	}
	
	private static void prochaineImagePartie(FrontendTasks subTasks) {
		
		subTasks.task("prochaineImagePartie")
		
		    .waitsFor(clock().nextTick())
		    
		    .thenExecutes(inputs -> {
		    	
		    	Tick   tick    = inputs.get(clock().nextTick());

		    	
		    	DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
		    	VueParametres vuePartie          = inputs.get(created(VueParametres.class));
		    			    	
		    	donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());
		    	donneesVuePartie.afficherSur(vuePartie);
		    });
	}
	
	
	
	
	private static void creerDonneesVuePartie(FrontendTasks tasks) {
		
		tasks.task(create(DonneesVuePartie.class))
		
		     .waitsFor("Initialisation")
		     
		     .executesAndReturnsCreatedValue(inputs -> {
		    	 
		    	 return new DonneesVuePartie();
		    	 
		     });
	}

}
