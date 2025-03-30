package v3;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

public class Scena extends Canvas {
	
	private ArrayList<Figura> figure = new ArrayList<>();
	
	public synchronized void dodajFiguru (Figura f) {
		figure.add(f);
	}
	
	public synchronized Figura dohvatiFiguru (int indeks) {
		return figure.get(indeks);
	}
	
	public synchronized void ukloniFiguru (Figura f) {
		figure.remove(f);
	}
	
	public synchronized void pokreni() {
		for (Figura f: figure) {
			if(f instanceof AktivnaFigura) {
				((AktivnaFigura) f).pokreni();
			}
		}
	}
	
	public synchronized void zaustavi() {
		for (Figura f: figure) {
			if(f instanceof AktivnaFigura) {
				((AktivnaFigura) f).zaustavi();
			}
		}
	}
	/*
	@Override
	public void update(Graphics g) {
	    paint(g);
	}
	*/
	@Override
	public synchronized void paint(Graphics g) {
		for (Figura f: figure) {
			f.iscrtaj(g);
		}
	}
	
	public synchronized int brojFigura() {
		return figure.size();
	}
	
	
}
