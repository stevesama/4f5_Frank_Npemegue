package echecs.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import echecs.dorsal.taches.InitialiserModeles;

public class DorsalEchecs extends LocalBackendNtro{

	@Override
	public void createTasks(BackendTasks tasks) {
		// TODO Auto-generated method stub
		
		InitialiserModeles.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
