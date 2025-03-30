package V1;

import java.awt.Label;

public class Timer implements Runnable{

	private int count;
	private Label labela;
	private Thread nit;
	private boolean radi;
	
	public Timer(Label labela) {
		count = 0;
		this.labela = labela;
		nit = new Thread(this);
		this.radi = false;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(!radi) {
						wait();
					}
				}
				
				labela.setText("Timer: " + count);
				
				count ++;
				Thread.sleep(1000);
				labela.setText("Timer: " + count);
				
			}
		} catch (InterruptedException e) {}
	}

	public synchronized void startuj() {
		nit.start();
	}
	public synchronized void zavrsi() {
		nit.interrupt();
		radi = false;
	}
	public synchronized void nastavi() {
		notify();
		radi = true;
	}
	public synchronized void pauziraj() {
		radi = false;
	}
	public synchronized int getCount() {
		return count;
	}
}
