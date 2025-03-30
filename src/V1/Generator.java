package V1;

import java.awt.Color;
import java.awt.Graphics;

public class Generator extends Figura {

	public Generator(int x, int y) {
		super(x, y);
		r = 20;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x - r, y - r, 2 * r, 2 * r);//precnik
		g.setColor(Color.YELLOW);
		g.fillOval(x - r / 2, y - r / 2, 2 * r / 2, 2 * r / 2);//precnik
	}

}
