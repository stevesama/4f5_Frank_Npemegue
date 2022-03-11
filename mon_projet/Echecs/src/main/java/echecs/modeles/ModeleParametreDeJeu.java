package echecs.modeles;


import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import echecs.modeles.valeurs.Parametres;

public class ModeleParametreDeJeu implements Model{
	
	
	private List<Parametres> ordreDuJoueur = new ArrayList<>();
	
	
	public List<Parametres> getOrdreDuJoueur() {
		return ordreDuJoueur;
	}


	public void setOrdreDuJoueur(List<Parametres> ordreDuJoueur) {
		this.ordreDuJoueur = ordreDuJoueur;
	}



	public ModeleParametreDeJeu() {
		
	}
	
	
}
