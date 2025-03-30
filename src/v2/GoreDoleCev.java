package v2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GoreDoleCev extends Cev {

	public GoreDoleCev() {
		super();
	}
	/*
	@Override
	protected void nacrtajIviceIUsmerenja(Graphics g) {
		//ivice
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.drawLine(width / 4, 0, (width / 4), (height));
		g.drawLine(width * 3 / 4, 0, (width * 3 / 4), (height));


		//strelica
		int x_poc = (width / 2);
		int y_poc = (height / 4);
		int x_kraj = width / 2;
		int y_kraj = (height * 3 / 4);
		g.drawLine(x_poc, y_poc, x_kraj, y_kraj);
		int x[] = {x_kraj - 4, x_kraj, x_kraj + 4};
		int y[] = {y_kraj, y_kraj + 10, y_kraj};
		g.fillPolygon(x, y, 3);
	
	}

	@Override
	protected void nacrtajUnutrasnjostCevi(Graphics g) {
		int height = getPreferredSize().height;
		int width = getPreferredSize().width;
		g.fillRect(width / 4, 0, (width / 2), (height));

	}*/
	
	
	@Override
	protected void nacrtajIviceIUsmerenja(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;

        Graphics2D g2dCopy = (Graphics2D) g2d.create();

        int width = getPreferredSize().width;
        int height = getPreferredSize().height;

        g2d.rotate(Math.toRadians(90), width / 2, height / 2);

        nacrtajIviceIUsmerenja2(g2d);

        g2d.setTransform(g2dCopy.getTransform());
        g2dCopy.dispose();
		
	}

	private void nacrtajIviceIUsmerenja2(Graphics2D g) {
		//ivice
		g.drawLine(0, (getPreferredSize().height / 4), (getPreferredSize().width), (getPreferredSize().height / 4));
		g.drawLine(0, (getPreferredSize().height * 3 / 4), (getPreferredSize().width), (getPreferredSize().height * 3 / 4));
		//strelica
		int x_poc = (getPreferredSize().width / 4);
		int y_poc_kraj = (getPreferredSize().height / 2);
		int x_kraj = (getPreferredSize().width * 3 / 4);
		g.drawLine(x_poc, y_poc_kraj, x_kraj, y_poc_kraj);
		int x[] = {x_kraj, x_kraj + 10, x_kraj};
		int y[] = {y_poc_kraj + 4, y_poc_kraj, y_poc_kraj - 4};
		g.fillPolygon(x, y, 3);
		
	}

	@Override
	protected void nacrtajUnutrasnjostCevi(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Graphics2D g2dCopy = (Graphics2D) g2d.create();

        int width = getPreferredSize().width;
        int height = getPreferredSize().height;

        g2d.rotate(Math.toRadians(90), width / 2, height / 2);

        nacrtajUnutrasnjostCevi2(g2d);

        g2d.setTransform(g2dCopy.getTransform());
        g2dCopy.dispose();

	}

	private void nacrtajUnutrasnjostCevi2(Graphics2D g) {
		g.fillRect(0, (getPreferredSize().height / 4), (getPreferredSize().width), (getPreferredSize().height / 2));
		
	}
	
}
