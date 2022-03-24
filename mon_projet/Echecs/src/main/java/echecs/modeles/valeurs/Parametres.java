package echecs.modeles.valeurs;

import ca.ntro.app.models.Value;

public class Parametres implements Value{
	
	private String police;
	private String idJoueur;
	
	public Parametres() {
		
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(String idJoueur) {
		this.idJoueur = idJoueur;
	}

	public Parametres(String idJoueur, String police) {
		
		setIdJoueur(idJoueur);
		setPolice(police);
	}
	
	
	
	

}
