package echecs.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import echecs.messages.MsgAjouterNotification;
import echecs.messages.MsgAjouterPolice;
import echecs.messages.MsgChangerCouleurBackground;
import echecs.messages.MsgChoisirLangue;
import echecs.messages.MsgChoisirPieces;
import echecs.messages.MsgChoisirPolice;
import echecs.modeles.ModeleParametreDeJeu;

public class ModifierFileAttente {
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierFileAttente")
		
		.waitsFor("InitialiserModeles")
		
		.andContains(subTasks -> { 
			
			ajouterPolice(subTasks);
			choisirPolice(subTasks);
			changerCouleurBackground(subTasks);
			ajouterNotification(subTasks);
			ajouterPieces(subTasks);
			ajouterLangue(subTasks);
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
	
	
	private static void choisirPolice(BackendTasks tasks) {
	    tasks.task("choisirPolice")
	    
	        .waitsFor(message(MsgChoisirPolice.class))
	        
	        .thenExecutes(inputs -> { 
	        	MsgChoisirPolice msgChoisirPolice = inputs.get(message(MsgChoisirPolice.class));
	        	 ModeleParametreDeJeu parametreDeJeu = inputs.get(model(ModeleParametreDeJeu.class));
	        	 
	        	 msgChoisirPolice.ajouterA(parametreDeJeu);
	        });
	}
	
	private static void changerCouleurBackground(BackendTasks tasks) {
	    tasks.task("changerCouleurBackground")
	    
	        .waitsFor(message(MsgChangerCouleurBackground.class))
	        
	        .thenExecutes(inputs -> { 
	        	MsgChangerCouleurBackground msgChangerCouleurBackground = inputs.get(message(MsgChangerCouleurBackground.class));
	        	 ModeleParametreDeJeu parametreDeJeu = inputs.get(model(ModeleParametreDeJeu.class));
	        	 
	        	 msgChangerCouleurBackground.ajouterA(parametreDeJeu);
	        });
	}
	
	private static void ajouterNotification(BackendTasks tasks) {
	    tasks.task("ajouterNotification")
	    
	        .waitsFor(message(MsgAjouterNotification.class))
	        
	        .thenExecutes(inputs -> { 
	        	MsgAjouterNotification msgAjouterNotification = inputs.get(message(MsgAjouterNotification.class));
	        	 ModeleParametreDeJeu parametreDeJeu = inputs.get(model(ModeleParametreDeJeu.class));
	        	 
	        	 //System.out.print(msgAjouterNotification.getNotifications());
	        	 msgAjouterNotification.ajouterA(parametreDeJeu);
	        	 
	        });
	}
	
	private static void ajouterPieces(BackendTasks tasks) {
	    tasks.task("ajouterPieces")
	    
	        .waitsFor(message(MsgChoisirPieces.class))
	        
	        .thenExecutes(inputs -> { 
	        	MsgChoisirPieces msgChoisirPieces = inputs.get(message(MsgChoisirPieces.class));
	        	 ModeleParametreDeJeu parametreDeJeu = inputs.get(model(ModeleParametreDeJeu.class));
	        	 
	        	 //System.out.print(msgChoisirPieces.getPieces());
	        	 msgChoisirPieces.ajouterA(parametreDeJeu);
	        	 
	        });
	}
	
	private static void ajouterLangue(BackendTasks tasks) {
	    tasks.task("ajouterLangue")
	    
	        .waitsFor(message(MsgChoisirLangue.class))
	        
	        .thenExecutes(inputs -> { 
	        	MsgChoisirLangue msgChoisirLangue = inputs.get(message(MsgChoisirLangue.class));
	        	 ModeleParametreDeJeu parametreDeJeu = inputs.get(model(ModeleParametreDeJeu.class));
	        	 
	        	 //System.out.print(msgChoisirPieces.getPieces());
	        	 msgChoisirLangue.ajouterA(parametreDeJeu);
	        	 
	        });
	}
	
	

}
