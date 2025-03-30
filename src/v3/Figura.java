package v3;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	
	protected Scena scena;
	protected double x;
	protected double y;
	protected Color color;

	public Figura(Scena scena, double x, double y, Color color) {
		this.scena = scena;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public abstract void unisti();
	
	public abstract void iscrtaj(Graphics g);
	
	public abstract char getOznaka();
	
	public void pomeri(double x, double y) {
		this.x += x;
		this.y += y;
	}
	

}
