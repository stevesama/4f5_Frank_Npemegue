package echecs.messages;

import ca.ntro.app.messages.MessageNtro;
import echecs.modeles.ModeleParametreDeJeu;


public class MsgChoisirPolice extends MessageNtro{
	
	private String policeCourante;
	public MsgChoisirPolice() {
		
	}
	
	public String getPoliceCourante() {
		return policeCourante;
	}

	public void setPoliceCourante(String policeCourante) {
		this.policeCourante = policeCourante;
	}

	public void ajouterA(ModeleParametreDeJeu parametreDeJeu) {
		parametreDeJeu.choisirPolice(policeCourante);
    }

}

