package echecs.modeles.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Value;
import echecs.frontal.vues.fragments.FragmentPolice;

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
	
	
	@Override
	public String toString() {
		return police;
	}

	public FragmentPolice creerFragment(ViewLoader<FragmentPolice> viewLoaderPolice) {
		return viewLoaderPolice.createView();	
		
	}
	
	public void afficherSur(FragmentPolice fragmentPolice) {
		
		fragmentPolice.afficherPolice(police);
	}
	

	
	

}
