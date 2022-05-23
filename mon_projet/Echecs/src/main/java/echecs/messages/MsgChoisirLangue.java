package echecs.messages;

import ca.ntro.app.messages.MessageNtro;
import echecs.modeles.ModeleParametreDeJeu;

public class MsgChoisirLangue extends MessageNtro {
	
	private String langue;

	



	public String getLangue() {
		return langue;
	}



	public void setLangue(String langue) {
		this.langue = langue;
	}



	public MsgChoisirLangue() {
	}

	

	public void ajouterA(ModeleParametreDeJeu parametreDeJeu) {
		parametreDeJeu.ajouterLanguePour(langue);
    }

}
