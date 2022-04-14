package echecs;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import echecs.messages.MsgAjouterPolice;
import echecs.modeles.ModeleParametreDeJeu;
import echecs.modeles.monde_echecs2d.Balle2d;
import echecs.modeles.monde_echecs2d.MondeEchecs2d;
import echecs.modeles.monde_echecs2d.Objet2d;
import echecs.modeles.valeurs.Parametres;

public class Declarations {
	
	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterPolice.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		
		registrar.registerModel(ModeleParametreDeJeu.class);
		                                                            
		registrar.registerValue(Parametres.class);
		
		registrar.registerValue(MondeEchecs2d.class);
		registrar.registerValue(Balle2d.class);
		registrar.registerValue(Objet2d.class);

		

	}
	
	public static void declarerServeur(ServerRegistrar registrar) {
		
		registrar.registerName("localhost");
		registrar.registerPort(8002);
	}

}
