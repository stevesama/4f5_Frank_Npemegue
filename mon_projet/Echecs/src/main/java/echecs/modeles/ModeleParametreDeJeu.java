package echecs.modeles;


import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import echecs.frontal.vues.VueParametreDeJeu;
import echecs.messages.MsgAjouterPolice;
import echecs.modeles.valeurs.Parametres;

public class ModeleParametreDeJeu implements Model{
		
	private long prochainIdJoueur = 1;
	private List<Parametres> parametresOrdre = new ArrayList<>();


	public List<Parametres> getParametresOrdre() {
		return parametresOrdre;
	}


	public void setParametresOrdre(List<Parametres> parametresOrdre) {
		this.parametresOrdre = parametresOrdre;
	}


	public ModeleParametreDeJeu() {
		
	}
	
	
	 public void ajouterPolicePour(String police) {
	        String idJoueur = genererIdJoueur();
	        Parametres parametres = new Parametres(idJoueur, police);
	        parametresOrdre.add(parametres);
	    }

	    private String genererIdJoueur() {
	        // TODO Auto-generated method stub
	        String idJoueur = String.valueOf(prochainIdJoueur);
	        prochainIdJoueur++;
	        return idJoueur;
	    }
	    
	   
	   public void afficherSur(VueParametreDeJeu vueParametreDeJeu) {
		   
		   vueParametreDeJeu.afficherMessage(this.toString());
	   }

	
	
	
}
