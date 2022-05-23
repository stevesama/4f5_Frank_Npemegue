package echecs.messages;

import ca.ntro.app.messages.MessageNtro;
import echecs.modeles.ModeleParametreDeJeu;

public class MsgAjouterNotification extends MessageNtro{
	
	private boolean notifications;
	

	public boolean getNotifications() {
		return notifications;
	}


	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}


	public MsgAjouterNotification() {
		
	}
	
	
	public void ajouterA(ModeleParametreDeJeu parametreDeJeu) {
		parametreDeJeu.changerNotification(notifications);
    }

}
