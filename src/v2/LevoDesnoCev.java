package v2;

import java.awt.Color;
import java.awt.Graphics;

public class LevoDesnoCev extends Cev {

	public LevoDesnoCev() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void nacrtajIviceIUsmerenja(Graphics g) {
		//ivice
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.drawLine(0, (height / 4), (width), (height / 4));
		g.drawLine(0, (height * 3 / 4), (width), (height * 3 / 4));
		//strelica
		int x_poc = (width / 4);
		int y_poc_kraj = (height / 2);
		int x_kraj = (width * 3 / 4);
		g.drawLine(x_poc, y_poc_kraj, x_kraj, y_poc_kraj);
		int x[] = {x_kraj, x_kraj + 10, x_kraj};
		int y[] = {y_poc_kraj + 4, y_poc_kraj, y_poc_kraj - 4};
		g.fillPolygon(x, y, 3);
	
	}

	@Override
	protected void nacrtajUnutrasnjostCevi(Graphics g) {
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.fillRect(0, (height / 4), (width), (height / 2));

	}

}
