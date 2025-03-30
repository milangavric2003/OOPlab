package V1;

import java.util.ArrayList;

public class SkupFigura {
	
	private ArrayList<Figura> figure = new ArrayList<>();

	private int index = 0;

	public synchronized void dodaj(Figura f) throws Greska {
		if (figure.contains(f)) throw new Greska();
		figure.add(f);
	}
	
	public synchronized void prvaTekuca() {
		index = 0;
	}
	
	public synchronized void sledeca() throws Greska {
		if (figure.size() == index) throw new Greska();
		index++;
	}
	
	public synchronized Figura getTekuca() {
		return figure.get(index);
		
	}
	
	public synchronized boolean imaSledeca() {
		return figure.size() == index ? false : true;
	}
	
	public synchronized void isprazni() {
		//if (figure.size() == 0) return;
		figure.removeAll(figure);
		//index = 0;
	}
	
	public synchronized boolean ima(Figura f) {
		return figure.contains(f) ? true : false;
	}
	
	public synchronized void izbaci(Figura f) {
		/*if (!figure.contains(f)) return;
		if (figure.indexOf(f) <= index) {
			index--;
		}
		if (tekuca == f) {
			//index--;
			if (index == -1) tekuca = null;
			else tekuca = figure.get(index);
		}*/
		figure.remove(f);
		
	}
	
	public synchronized int brojElemenata() {
		return figure.size();
	}
	
	public static void main(String[] args) {
		Figura f1 = new Kamencic(1, 2);
		Figura f2 = new Usisivac(1, 2);
		Figura f3 = new Kamencic(3, 2);
		Figura f4 = new Kamencic(2, 2);
		try {
			SkupFigura skup = new SkupFigura();
			skup.dodaj(f1);
			skup.dodaj(f4);
			skup.dodaj(f3);
			skup.dodaj(f2);
			//System.out.println(skup.getTekuca());
			System.out.println(skup.brojElemenata());
			skup.izbaci(f1);
			System.out.println(skup.brojElemenata());
			//skup.prvaTekuca();
			//System.out.println(skup.getTekuca());
			skup.sledeca();
			skup.getTekuca();
			int i = 0;
			skup.prvaTekuca();
			for (Figura f = skup.getTekuca(); skup.imaSledeca(); skup.sledeca()) {//figure bez usisivaca
				System.out.println(i++);
			}
		} catch (Greska e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
