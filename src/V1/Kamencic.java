package V1;

import java.awt.Color;
import java.awt.Graphics;

public class Kamencic extends Figura {
	
	public Kamencic(int x, int y) {
		super(x, y);
		r = 5;
	}

	@Override
	public void paint(Graphics g) {
		Color old = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x - r, y - r, 2 * r, 2 * r);//precnik
		g.setColor(old);//vidi dal mora ovo uopste
	}

}
