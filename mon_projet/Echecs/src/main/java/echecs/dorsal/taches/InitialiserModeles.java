package echecs.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import echecs.modeles.ModeleParametreDeJeu;



public class InitialiserModeles {
	
	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("InitialiserModeles")
	
			.contains(subTasks -> {
				initialiserModeleParametreDeJeu(subTasks);
			});
	}
	
	private static void initialiserModeleParametreDeJeu(BackendTasks tasks) {
		
		tasks.task("initialiserModeleParametreDeJeu")
			.waitsFor(model(ModeleParametreDeJeu.class))
			.thenExecutes(inputs -> {
				ModeleParametreDeJeu detailPartie = inputs.get(model(ModeleParametreDeJeu.class));
			});
	}

}