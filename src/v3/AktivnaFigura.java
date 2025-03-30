package v3;

import java.awt.Color;

public abstract class AktivnaFigura extends Figura implements Runnable {
	
	protected int period;
	protected Thread thread;

	public AktivnaFigura(Scena scena, double x, double y, Color color, int period) {
		super(scena, x, y, color);
		this.period = period;
		thread = new Thread(this);
	}

	public synchronized void pokreni() {
		thread.start();
	}

	public synchronized void zaustavi() {
		thread.interrupt();
	}
	
	@Override
	public synchronized void unisti() {
		zaustavi();
		//ukloni sa scene
		scena.ukloniFiguru(this);
		scena.repaint();
	}

}
