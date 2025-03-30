package V1;

import java.awt.Graphics;

public abstract class Figura {//abstract
	
	protected int x;
	protected int y;
	protected int r;
	
	public Figura(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getR() {
		return this.r;
	}
	
	public abstract void paint(Graphics g);
	
	public double rastojanje(Figura f) {
		return Math.sqrt(Math.pow(x - f.getX(), 2) + Math.pow(y - f.getY(), 2));
	}
	
	public boolean preklapa(Figura f) {
		return rastojanje(f) <= this.r + f.getR() ? true : false;
	}
	
	public boolean obuhvata(Figura f) {
		return rastojanje(f) + f.getR() <= this.r ? true : false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/*@Override
		public String toString() {
			return x + " " + y;
		}
	*/

	public static void main(String[] args) {
		/*Figura f1 = new Figura(1,2);
		Figura f2 = new Figura(12,2);
		System.out.println(f1.rastojanje(f2));
		System.out.println(f1.preklapa(f2));
		System.out.println(f1.obuhvata(f2));*/
	}

}
