package echecs.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import echecs.messages.MsgAjouterPolice;
import echecs.modeles.ModeleParametreDeJeu;

public class ModifierFileAttente {
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierFileAttente")
		
		.waitsFor("InitialiserModeles")
		
		.andContains(subTasks -> { 
			
			ajouterPolice(subTasks);
		});
	}
	
	
	
	
	
	
	private static void ajouterPolice(BackendTasks tasks) {
	    tasks.task("ajouterPolice")
	    
	        .waitsFor(message(MsgAjouterPolice.class))
	        
	        .thenExecutes(inputs -> { 
	        	 MsgAjouterPolice msgAjouterPolice = inputs.get(message(MsgAjouterPolice.class));
	        	 ModeleParametreDeJeu parametreDeJeu = inputs.get(model(ModeleParametreDeJeu.class));
	        	 
	        	 msgAjouterPolice.ajouterA(parametreDeJeu);
	        });
	}
	
	

}
