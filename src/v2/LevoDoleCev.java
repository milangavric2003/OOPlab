package v2;

import java.awt.Color;
import java.awt.Graphics;

public class LevoDoleCev extends Cev {

	public LevoDoleCev() {
		super();
	}

	@Override
	protected void nacrtajIviceIUsmerenja(Graphics g) {
		//ivice
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.drawLine(0, height / 4, width * 3 / 4, height / 4);
		g.drawLine(0, height * 3 / 4, width / 4, height * 3 / 4);
		g.drawLine(width * 3 / 4, height / 4, width * 3 / 4, height);
		g.drawLine(width / 4, height * 3 / 4, width / 4, height);
		
		//strelica
		int x_poc = width / 4;
		int y_poc = height / 2;
		int x_kraj = width / 2;
		int y_kraj = height * 3 / 4;
		g.drawLine(x_poc, y_poc, x_kraj, y_poc);
		g.drawLine(x_kraj, y_poc, x_kraj, y_kraj);
		int x[] = {x_kraj - 4, x_kraj, x_kraj + 4};
		int y[] = {y_kraj, y_kraj + 10, y_kraj};
		g.fillPolygon(x, y, 3);
	}

	@Override
	protected void nacrtajUnutrasnjostCevi(Graphics g) {
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.fillRect(0, height / 4, width * 3 / 4, height / 2);
		g.fillRect(width / 4, height / 4, width / 2, height * 3 / 4);

	}

}
