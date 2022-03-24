package echecs.messages;

import ca.ntro.app.messages.MessageNtro;
import echecs.modeles.ModeleParametreDeJeu;

public class MsgAjouterPolice extends MessageNtro {

	private String police;

	public MsgAjouterPolice() {
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public void ajouterA(ModeleParametreDeJeu parametreDeJeu) {
		parametreDeJeu.ajouterPolicePour(police);
    }
	
}
