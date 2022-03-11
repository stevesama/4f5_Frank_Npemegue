package echecs.modeles.valeurs;

import ca.ntro.app.models.Value;

public class Parametres implements Value{
	
	private String police;
	private String premierJoueur;
	
	public Parametres() {
		
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(String premierJoueur) {
		this.premierJoueur = premierJoueur;
	}

	
	

}
