package V1;

import java.awt.Color;
import java.awt.Graphics;

public class Usisivac extends Figura {

	public Usisivac(int x, int y) {
		super(x, y);
		r = 15;
	}

	@Override
	public void paint(Graphics g) {
		
		Color old = g.getColor();
		g.setColor(Color.RED);
		
		
		double stranica = Math.sqrt(3) * r;
		double visina = r * 3 / 2;
		int array_x[] = {(int) (x - stranica / 2), x,(int) (x + stranica / 2)};//mozda nedovoljno precizno zbog celobrojnog deljenja
		int array_y[] = { (int)(y + visina / 3), y - r,(int)( y + visina / 3)};

		g.fillPolygon(array_x, array_y, 3);
		
		g.setColor(old);
		
	}
	
	public int getKorak() {
		return r / 2;
	}

}
