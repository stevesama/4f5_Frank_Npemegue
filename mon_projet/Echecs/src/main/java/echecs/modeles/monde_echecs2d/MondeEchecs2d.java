package echecs.modeles.monde_echecs2d;

import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MondeEchecs2d extends World2dFx<Objet2d, MondeEchecs2d> {
	
	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 320;
	
	private Balle2d balle;

	@Override
	protected void onMouseEventNotConsumed(MouseEvent evtFx, double worldX, double worldY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);
		
		balle = new Balle2d();
		
		addObject2d(balle);
		
		for(int i = 0; i < 100; i++) {
			addObject2d(new Balle2d());
		}
	}
	
	
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		dessinerTerrain(gc);
		
		super.draw(gc);
	}
	
	
	private void dessinerTerrain(GraphicsContext gc) {
		
		gc.save();
		
		gc.setLineWidth(2);
		gc.setStroke(Color.LIGHTBLUE);
		
		gc.strokeRect(0, 0, getWidth(), getHeight());
		
		gc.restore();
	}

	
	
}
