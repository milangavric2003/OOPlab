package v3;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {
	
	private int sirina;
	private int visina;
	private boolean pogodjena;
	
	public Cigla(Scena scena, double x, double y, int sirina, int visina, int period) {
		super(scena, x, y, Color.RED, period);
		this.period = period; 
		this.sirina = sirina;
		this.visina = visina;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while(!pogodjena) {
						wait();
					}
				}
				if (y + 5 > scena.getPreferredSize().height) {
					unisti();
					break;
				}
				pomeri(0, 5);

				scena.repaint();
				Thread.sleep(period);
				
				
			}
		} catch (InterruptedException e) {}
		
	}

	@Override
	public void iscrtaj(Graphics g) {
		g.setColor(color);
		g.fillRect((int)(x - (int)(sirina / 2)), (int)(y - (int)(visina / 2)), sirina, visina);

	}

	@Override
	public char getOznaka() {
		return 'C';
	}
	
	public int getSirina() {
		return sirina;
	}
	
	public int getVisina() {
		return visina;
	}
	
	public synchronized void pogodi() {
		color = Color.GRAY;
		pogodjena = true;
		notify();
	}
	
	public synchronized boolean getPogodjenost() {
		return pogodjena;
	}
	
}
