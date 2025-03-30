package v2;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Cev extends Kvadrat {

	public Cev() {
		super(new Color(170, 170, 170));
	}

	@Override
	public boolean oznaciv() {
		return true;
	}
	
	@Override
	public void paint(Graphics g) {
		//mozda treba old color
		g.setColor(new Color(204, 204, 204));
		nacrtajUnutrasnjostCevi(g);
		g.setColor(Color.BLACK);
		nacrtajIviceIUsmerenja(g);
		super.paint(g);//na kraju da iscrta ivice crvenom ako je oznacen
	}

	protected abstract void nacrtajIviceIUsmerenja(Graphics g);

	protected abstract void nacrtajUnutrasnjostCevi(Graphics g);

}
