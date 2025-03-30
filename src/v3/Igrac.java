package v3;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
	
	private int sirina;
	private int visina;

	public Igrac(Scena scena, int visina, int sirina) {
		super(scena, scena.getPreferredSize().width / 2,
				scena.getPreferredSize().height - 20, Color.BLUE);
		this.sirina = sirina;
		this.visina = visina;
	}
	
	public void ispaliLopticu() {
		int precnik = visina;
		int period = 10;
		Loptica l = new Loptica(scena, this.x, 
				this.y - (int)(visina / 2) - (int)(precnik / 2), period, precnik);
		scena.dodajFiguru(l);
		l.pokreni();
	}

	@Override
	public void unisti() {
		
	}

	@Override
	public void iscrtaj(Graphics g) {
		g.setColor(color);
		g.fillRect((int)(x - (int)(sirina / 2)), (int)(y - (int)(visina / 2)), sirina, visina);

	}

	@Override
	public char getOznaka() {
		return 'I';
	}
	
	public int getSirina() {
		return sirina;
	}
	
	public int getVisina() {
		return visina;
	}
	
	@Override
	public void pomeri(double x, double y) {
		if (sudarSaIvicomIgrac(x, y)) return;
		super.pomeri(x, y);
	}

	private boolean sudarSaIvicomIgrac(double x_pom, double y_pom) {
		//gore	
		if (0 > (int)(this.y + y_pom) - (int)(visina / 2)) {
			return true;
		//dole
		} else if (scena.getPreferredSize().height < (int)(this.y + y_pom) + (int)(visina / 2)) {
			return true;
		//s desna	
		} else if (scena.getPreferredSize().width < (int)(this.x + x_pom) + (int)(sirina / 2)) {
			return true;
		//s leva	
		} else if (0 > (int)(this.x + x_pom) - (int)(sirina / 2)) {
			return true;
		}
		return false;
	}

}
