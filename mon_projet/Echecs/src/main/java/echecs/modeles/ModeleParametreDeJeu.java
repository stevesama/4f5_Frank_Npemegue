package echecs.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import echecs.frontal.vues.VueParametreDeJeu;
import echecs.frontal.vues.fragments.FragmentPolice;
import echecs.messages.MsgAjouterPolice;
import echecs.modeles.valeurs.Parametres;
import javafx.scene.paint.Color;

public class ModeleParametreDeJeu implements Model {

	private long prochainIdJoueur = 1;
	private List<Parametres> parametresOrdre = new ArrayList<>();

	private String policeCourante;
	private String langue;

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	private boolean notifications;

	private List<Double> rgb = new ArrayList<>();
	private String pieces;

	public List<Double> getRgb() {
		return rgb;
	}

	public void setRgb(List<Double> rgb) {
		this.rgb = rgb;
	}

	public List<Parametres> getParametresOrdre() {
		return parametresOrdre;
	}

	public long getProchainIdJoueur() {
		return prochainIdJoueur;
	}

	public void setProchainIdJoueur(long prochainIdJoueur) {
		this.prochainIdJoueur = prochainIdJoueur;
	}

	public void setParametresOrdre(List<Parametres> parametresOrdre) {
		this.parametresOrdre = parametresOrdre;
	}

	public String getPoliceCourante() {
		return policeCourante;
	}

	public void setPoliceCourante(String policeCourante) {
		this.policeCourante = policeCourante;
	}

	public boolean getNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public String getPieces() {
		return pieces;
	}

	public void setPieces(String pieces) {
		this.pieces = pieces;
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

	public void afficherSur(VueParametreDeJeu vueParametreDeJeu, ViewLoader<FragmentPolice> viewLoaderPolice) {

		vueParametreDeJeu.changerPolice(policeCourante);

		vueParametreDeJeu.viderListePolice();

		if (langue == "Francais") {
			vueParametreDeJeu.ModifierLangue("Choisir votre langue:");
		} else if (langue == "Anglais") {
			
			vueParametreDeJeu.ModifierLangue("Choose your language:");
		}

		for (Parametres parametres : parametresOrdre) {

			FragmentPolice fragmentPolice = parametres.creerFragment(viewLoaderPolice);

			parametres.afficherSur(fragmentPolice);

			vueParametreDeJeu.ajouterPolice(fragmentPolice);

		}
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numeroJoueur = 1;

		for (Parametres parametres : parametresOrdre) {

			builder.append(numeroJoueur);
			builder.append(". ");
			builder.append(parametres.toString());
			builder.append("\n");

			numeroJoueur++;

		}

		return builder.toString();
	}

	public void choisirPolice(String policeCourante) {
		this.policeCourante = policeCourante;

	}

	public void changerCouleurBackground(List<Double> rgb) {
		this.rgb = rgb;

	}

	public void changerNotification(boolean notifications) {
		this.notifications = notifications;

	}

	public void ajouterPiecesPour(String pieces) {
		this.pieces = pieces;
	}

	public void ajouterLanguePour(String langue) {
		this.langue = langue;

	}

}