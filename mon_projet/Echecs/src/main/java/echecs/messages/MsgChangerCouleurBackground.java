package echecs.messages;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.messages.MessageNtro;
import echecs.modeles.ModeleParametreDeJeu;
import javafx.scene.paint.Color;

public class MsgChangerCouleurBackground extends MessageNtro {

	private List<Double> rgb = new ArrayList<>();

	
	public List<Double> getRgb() {
		return rgb;
	}

	public void setRgb(List<Double> rgb) {
		this.rgb = rgb;
	}

	public MsgChangerCouleurBackground() {

	}
	
	public void ajouterA(ModeleParametreDeJeu parametreDeJeu) {
		parametreDeJeu.changerCouleurBackground(rgb);
    }
}
