package echecs.messages;

import ca.ntro.app.messages.MessageNtro;
import echecs.modeles.ModeleParametreDeJeu;

public class MsgChoisirPieces extends MessageNtro {
	
	private String pieces;

	public String getPieces() {
		return pieces;
	}



	public void setPieces(String pieces) {
		this.pieces = pieces;
	}



	public MsgChoisirPieces() {
	}

	

	public void ajouterA(ModeleParametreDeJeu parametreDeJeu) {
		parametreDeJeu.ajouterPiecesPour(pieces);
    }
	

}
