package v3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Loptica extends AktivnaFigura {
	
	private int precnik;
	private double x_pom;
	private double y_pom;

	public Loptica(Scena scena, double x, double y, int period, int precnik) {
		super(scena, x, y, Color.GREEN, period);
		this.period = period;
		this.precnik = precnik;
	}

	@Override
	public void run() {
		x_pom = -1 + 2 * new Random().nextDouble();
        y_pom = -1 + new Random().nextDouble() * (1.0 - Double.MIN_VALUE) + Double.MIN_VALUE;

		int count = 1;//kada dodje do 100 brzina za 10 %
		try {
			while (!Thread.interrupted()) {
				
				//sudar
				//synchronized (scena) {
				ispitajSudar();
				//}
				if (count == 100) {//ostaje isti smer kretanja
					x_pom += x_pom / 10;
					y_pom += y_pom / 10;
					count = 1;
				}

		        pomeri(x_pom, y_pom);

		        //unisti ako izadje sa scene 
		        if (y >= scena.getPreferredSize().height) {
		        	unisti();
		        	break;
		        }
		        
		        Thread.sleep(period);
		        count++; //za brzinu
				//neki repaint
		        scena.repaint();
			}
		} catch (InterruptedException e) {}
	}

	private void ispitajSudar() {
		Figura f = null;
		
		for (int i = 0; i < scena.brojFigura(); i++) {
			//synchronized (scena) {
			f = scena.dohvatiFiguru(i);
			
			if (f == this) continue;
			if (f instanceof Cigla) {
				sudarSaCiglom((Cigla)f);
			}
			if (f instanceof Igrac) {
				sudarSaIgracem((Igrac)f);
			}
			sudarSaIvicom();
			//}
		}
		
	}


	private void sudarSaIvicom() {
		//synchronized (scena) {
		//gore	
		if (0 + (int)(this.precnik / 2) >= (int)(this.y)) {
			this.y_pom = Math.abs(this.y_pom);
		//s desna	
		} else if (scena.getPreferredSize().width - (int)(this.precnik / 2) <= (int)(this.x)) {
			this.x_pom = - Math.abs(this.x_pom);
		//s leva	
		} else if (0 + (int)(this.precnik / 2) >= (int)(this.x)) {
			this.x_pom = Math.abs(this.x_pom);
		}
		//}
		
	}

	private void sudarSaIgracem(Igrac i) {
		//synchronized (scena) {
		//odozdo
		if ((int)((int)(i.getVisina() / 2) + i.y) >= (int)(this.y) - (int)(this.precnik / 2) - 1
				&& i.y <= (int)(this.y) - 1
				&& this.x <= i.getSirina() / 2 + i.x && this.x >= - i.getSirina() / 2 + i.x) {
			this.y_pom = Math.abs(this.y_pom);
		//odozgo	
		} else if ((int)((int)(- i.getVisina() / 2) + i.y) <= (int)(this.y) - 1 + (int)(this.precnik / 2)
				&& i.y >= (int)(this.y) - 1
				&& this.x <= i.getSirina() / 2 + i.x && this.x >= - i.getSirina() / 2 + i.x) {
			this.y_pom = - Math.abs(this.y_pom);
		//s desna	
		} else if ((int)((int)(i.getSirina() / 2) + i.x) >= (int)(this.x) - (int)(this.precnik / 2)
				&& (int)((int)(i.getSirina() / 2) + i.x) <= (int)(this.x)
				&& this.y <= i.getVisina() / 2 + i.y && this.y >= - i.getVisina() / 2 + i.y) {
			this.x_pom = Math.abs(this.x_pom);
		//s leva	
		} else if ((int)((int)(- i.getSirina() / 2) + i.x) <= (int)(this.x) + (int)(this.precnik / 2)
				&& (int)((int)(- i.getSirina() / 2) + i.x) >= (int)(this.x)
				&& this.y <= i.getVisina() / 2 + i.y && this.y >= - i.getVisina() / 2 + i.y) {
			this.x_pom = - Math.abs(this.x_pom);
		}
		//}
	}

	private void sudarSaCiglom(Cigla c) {
		//synchronized (scena) {
		if (c.getPogodjenost()) return;
		//odozdo
		if ((int)((int)(c.getVisina() / 2) + c.y) >= (int)(this.y) - (int)(this.precnik / 2) - 1
				&& c.y <= (int)(this.y) - 1
				&& this.x <= c.getSirina() / 2 + c.x && this.x >= - c.getSirina() / 2 + c.x) {
			this.y_pom = Math.abs(this.y_pom);
			c.pogodi();
		//odozgo	
		}else if ((int)((int)(- c.getVisina() / 2) + c.y) <= (int)(this.y) - 1 + (int)(this.precnik / 2)
				&& c.y >= (int)(this.y) - 1
				&& this.x <= c.getSirina() / 2 + c.x && this.x >= - c.getSirina() / 2 + c.x) {
			this.y_pom = - Math.abs(this.y_pom);
			c.pogodi();
		//s desna	
		} else if ((int)((int)(c.getSirina() / 2) + c.x) >= (int)(this.x) - (int)(this.precnik / 2)
				&& (int)((int)(c.getSirina() / 2) + c.x) <= (int)(this.x)
				&& this.y <= c.getVisina() / 2 + c.y && this.y >= - c.getVisina() / 2 + c.y) {
			this.x_pom = Math.abs(this.x_pom);
			c.pogodi();
		//s leva	
		} else if ((int)((int)(- c.getSirina() / 2) + c.x) <= (int)(this.x) + (int)(this.precnik / 2)
				&& (int)((int)(- c.getSirina() / 2) + c.x) >= (int)(this.x)
				&& this.y <= c.getVisina() / 2 + c.y && this.y >= - c.getVisina() / 2 + c.y) {
			this.x_pom = - Math.abs(this.x_pom);
			c.pogodi();
		}
		//}
		//odozdo
		/*if ((int)(c.getVisina() / 2 + c.y) == (int)(this.y) 
				&& this.x <= c.getSirina() / 2 + c.x && this.x >= - c.getSirina() / 2 + c.x) {
			this.y_pom = - this.y_pom; c.pogodi();
		//odozgo	
		} else if ((int)(- c.getVisina() / 2 + c.y) == (int)(this.y) 
				&& this.x <= c.getSirina() / 2 + c.x && this.x >= - c.getSirina() / 2 + c.x) {
			this.y_pom = - this.y_pom; c.pogodi();
		//s desna	
		} else if ((int)(c.getSirina() / 2 + c.x) == (int)(this.x)
				&& this.y <= c.getVisina() / 2 + c.y && this.y >= - c.getVisina() / 2 + c.y) {
			this.x_pom = - this.x_pom; c.pogodi();
		//s leva	
		} else if ((int)(- c.getSirina() / 2 + c.x) == (int)(this.x)
				&& this.y <= c.getVisina() / 2 + c.y && this.y >= - c.getVisina() / 2 + c.y) {
			this.x_pom = - this.x_pom; c.pogodi();
		}*/
		return;
	}

	@Override
	public void iscrtaj(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(x - (int)(precnik / 2)), (int)(y - (int)(precnik / 2)), precnik, precnik);
	}

	@Override
	public char getOznaka() {
		return 'L';
	}

}
