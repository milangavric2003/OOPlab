package v2;

import java.awt.Graphics;

public class GoreDesnoCev extends Cev {

	public GoreDesnoCev() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void nacrtajIviceIUsmerenja(Graphics g) {
		//ivice
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.drawLine(width * 3 / 4, height / 4, width, height / 4);
		g.drawLine(width / 4, height * 3 / 4, width, height * 3 / 4);
		g.drawLine(width / 4, 0, width / 4, height * 3 / 4);
		g.drawLine(width * 3 / 4, 0, width * 3 / 4, height / 4);
		
		//strelica
		int x_poc = width / 2;
		int y_poc = height / 4;
		int x_kraj = width * 3 / 4;
		int y_kraj = height / 2;
		g.drawLine(x_poc, y_poc, x_poc, y_kraj);
		g.drawLine(x_poc, y_kraj, x_kraj, y_kraj);
		int x[] = {x_kraj, x_kraj + 10, x_kraj};
		int y[] = {y_kraj - 4, y_kraj, y_kraj + 4};
		g.fillPolygon(x, y, 3);
	}

	@Override
	protected void nacrtajUnutrasnjostCevi(Graphics g) {
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.fillRect(width / 4, height / 4, width * 3 / 4 , height / 2);
		g.fillRect(width / 4, 0, width / 2, height * 3 / 4  - 1);

	}

}
