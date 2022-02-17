package pong.frontal;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.taches.Initialisation;
import pong.frontal.vues.VueRacine;

public class FrontalPong implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {
		// TODO Auto-generated method stub
		tasks.task("afficherFenetre")
		
		.waitsFor(window())
		
		.thenExecutes(inputs -> {
			
			Window window = inputs.get(window());
			
			window.show();
			
			Initialisation.creerTaches(tasks);
		});
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		// TODO Auto-generated method stub
		
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueRacine.class, "/file_attente.xml");

	}

}
