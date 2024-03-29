package echecs;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import echecs.dorsal.DorsalEchecs;
import echecs.dorsal.DorsalEchecsDistant;
import echecs.frontal.FrontalEchecs;
import echecs.messages.MsgAjouterPolice;
import echecs.modeles.ModeleParametreDeJeu;
import echecs.modeles.valeurs.Parametres;

public class EchecsLocal implements NtroClientFx{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		
		registrar.registerBackend(new DorsalEchecs());
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		// TODO Auto-generated method stub
		registrar.registerFrontend(new FrontalEchecs());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		// TODO Auto-generated method stub
		
		Declarations.declarerMessages(registrar);
	} 

	

	@Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		
		Declarations.declarerModeles(registrar);

		

	}

}
