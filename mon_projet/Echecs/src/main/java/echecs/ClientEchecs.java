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
import echecs.modeles.enums.Cadran;
import echecs.modeles.valeurs.Parametres;

public class ClientEchecs implements NtroClientFx{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length > 0) {
			Session.nomPolice = args[0]; 
		}
		
		if(args.length > 1) {
			Session.cadran = Cadran.valueOf(args[1]);
		}
		
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		
		registrar.registerBackend(new DorsalEchecsDistant());
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
