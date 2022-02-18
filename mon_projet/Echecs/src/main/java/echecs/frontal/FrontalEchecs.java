package echecs.frontal;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import echecs.frontal.taches.Initialisation;
import echecs.frontal.vues.VueFileAttente;
import echecs.frontal.vues.VueRacine;

public class FrontalEchecs implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		// TODO Auto-generated method stub
            Initialisation.creerTaches(tasks);
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
        registrar.registerView(VueFileAttente.class, "/file_attente.xml");
        //registrar.registerStylesheet("/dev.css");
        registrar.registerStylesheet("/prod.css");
        
        registrar.registerDefaultResources("/chaines_fr.properties");
        
        registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
    }

}
