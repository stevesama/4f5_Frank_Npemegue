package echecs.frontal.vues.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;
import echecs.frontal.vues.VueParametres;
import echecs.modeles.monde_echecs2d.MondeEchecs2d;

public class DonneesVuePartie implements ViewData{
	
	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;
	
	private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	private long imagesAfficheesDepuisDernierCalculFps = 0;
	
	private MondeEchecs2d mondeEchecs2d = new MondeEchecs2d();
	private String fpsCourant = "0";
	
	public void afficherSur(VueParametres vueParametres){
		calculerFpsSiNecessaire();
		
		vueParametres.viderCanvas();
		vueParametres.afficherImagesParSeconde("FPS" + fpsCourant);
		vueParametres.afficherEchecs2d(mondeEchecs2d);
		
		imagesAfficheesDepuisDernierCalculFps++;
	}
	
	private void calculerFpsSiNecessaire() {
		long horodatageMaintanant = Ntro.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintanant - horodatageDernierCalculFps;
		
		if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
			calculerFpsMaintenant(millisecondesEcoulees);
			
			imagesAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintanant;
			
			
		}
	}
	
	
	private void calculerFpsMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = millisecondesEcoulees / 1E3;
		double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
		fpsCourant = String.valueOf(Math.round(fps));
	}
	

	public void reagirTempsQuiPasse(double elapsedTime) {
		mondeEchecs2d.onTimePasses(elapsedTime);
	}
}
