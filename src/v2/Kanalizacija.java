package v2;

import java.awt.GridLayout;
import java.awt.Panel;

public class Kanalizacija extends Panel{
	
	private int redovi;
	private int kolone;
	//private Panel mreza;
	private Kvadrat oznacenKvadrat;
	private int oznacenKvadratIndeks;
	
	public Kanalizacija (int redovi, int kolone) {
		this.redovi = redovi;
		this.kolone = kolone;
		setLayout(new GridLayout(redovi, kolone, 1, 1));
		//mreza = new Panel(new GridLayout(redovi, kolone, 1, 1));
		
		for(int i = 0; i < redovi * kolone; i++) {
			add(new Zid());
		}
	}
	
	public void promeniOznaku (Kvadrat k) throws GOznaka {
		if (k == null) return;
		if (k == oznacenKvadrat) {
			k.setOznaka();
			oznacenKvadrat = null;
			return;
		}
		if (oznacenKvadrat != null) oznacenKvadrat.setOznaka();
		
		for (int i = 0; i < redovi * kolone; i++) {//napravi bolje ne treba ovako
			if (k == getComponent(i)) {
				k.setOznaka();
				oznacenKvadrat = k;
				oznacenKvadratIndeks = i;
				break;
			}
		}
		nacrtaj();
	}
	
	public void dodajCev (Cev cev) {//pise u tekstu da se prosledjuje kvadrat
		if (oznacenKvadrat == null) return;
		remove(oznacenKvadrat);
		add(cev, oznacenKvadratIndeks);
		oznacenKvadrat = null;//mozda ovako ili na sledeci nacin
		//oznacenKvadrat = cev;
		//cev.setOznaka();
		
		//revalidate
		revalidate();
		nacrtaj();//probaj samo to sto je potrebno da nacrtas u nekoj novoj metodi
	}

	private void nacrtaj() {
		for (int i = 0; i < redovi * kolone; i++) {
			getComponent(i).repaint();
		}
	}
	
}
