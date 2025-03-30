package V1;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class AktivnaScena extends Canvas implements Runnable{
	
	private GrafickaSimulacija owner;
	private Usisivac usisivac;
	//private ArrayList<Figura> figure;//kamencici; TREBA SKUP FIGURA !!!!!!!!
	private SkupFigura figure;
	private Thread posao;
	private boolean radi;
	private Generator gen;
	private Timer timer;
	
	public AktivnaScena(GrafickaSimulacija owner, Timer timer) {
		this.radi = false;
		this.owner = owner;
		this.figure = new SkupFigura();
		
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(500, 300));
		this.usisivac = new Usisivac(getPreferredSize().width / 2, getPreferredSize().height / 2);
		this.gen = new Generator(20, 20);
		this.timer = timer;
		posao = new Thread(this);
		posao.start();
		timer.startuj();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//getParent().requestFocus();
				if (e.getButton() == MouseEvent.BUTTON1) {
					dodajFiguru(new Kamencic(e.getX(), e.getY()));
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					try {
						generisi();
					} catch (Greska e1) {}
				}
			}

			private synchronized void generisi() throws Greska {
				Random random = new Random();
				for (int i = 0; i < 10; i++) {
					int novi = random.nextInt(4);
					int x = random.nextInt(getPreferredSize().width);
					int y = random.nextInt(getPreferredSize().height);
					if (novi == 0) {
						dodajFiguru(new Generator(x, y));
					} else {
						dodajFiguru(new Kamencic(x, y));
					}
				}
			}
			
			
		});
	
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//setBackground(Color.GRAY);//valjda i ovo moze
		/*for (Figura f: figure) {
			f.paint(g);
		}
		usisivac.paint(g);*/
		usisivac.paint(g);
		gen.paint(g);
		try {
			for(figure.prvaTekuca(); figure.imaSledeca(); figure.sledeca()) {
				figure.getTekuca().paint(g);
			}
		} catch (Greska e) {}
		
		//super.paint(g);
	}

	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized(this) {
					while (!radi) {
						wait();
					}	
				}
				if (timer.getCount() % 10 == 0 && timer.getCount() != 0) {//ne valja jer kad se oslobodi bice 10 opet
					timer.pauziraj();
					pomeriUsisivacKaGen(usisivac.getKorak());
				} else {
					pomeriUsisivac(usisivac.getKorak());
				}
				repaint(); 
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {}
		
	}

	private void pomeriUsisivacKaGen(int korak) throws InterruptedException {
		if (usisivac.preklapa(gen)) {
			Thread.sleep(2000);
			timer.nastavi();
		} else if (Math.abs(gen.getX() - usisivac.getX()) > korak) {
			//horizontalno pomeranje
			if (gen.getX() - usisivac.getX() < 0) usisivac.setX(usisivac.getX() - korak); //kamencic s leve strane
			else usisivac.setX(usisivac.getX() + korak);
		} else {
			//vertikalno pomeranje
			if (gen.getY() - usisivac.getY() < 0) usisivac.setY(usisivac.getY() - korak);//kamencic gore
			else usisivac.setY(usisivac.getY() + korak);
		}
		
	}

	private synchronized void pomeriUsisivac(int korak) throws InterruptedException {
		
		if (figure.brojElemenata() == 0) {
			
			return;
		}
		
		figure.prvaTekuca();
		Figura tek = figure.getTekuca();
		
		double min = usisivac.rastojanje(tek);
		try {
			for (; figure.imaSledeca(); figure.sledeca()) {
				if (usisivac.rastojanje(figure.getTekuca()) < min) {
					min = usisivac.rastojanje(figure.getTekuca());
					tek = figure.getTekuca();
				}
			}
		} catch (Greska e) {}
		
		if (usisivac.preklapa(tek)) {
			figure.izbaci(tek);
			if (figure.brojElemenata() == 0) pauziraj();//nobo
		} else if (Math.abs(tek.getX() - usisivac.getX()) > korak) {
			//horizontalno pomeranje
			if (tek.getX() - usisivac.getX() < 0) usisivac.setX(usisivac.getX() - korak); //kamencic s leve strane
			else usisivac.setX(usisivac.getX() + korak);
		} else {
			//vertikalno pomeranje
			if (tek.getY() - usisivac.getY() < 0) usisivac.setY(usisivac.getY() - korak);//kamencic gore
			else usisivac.setY(usisivac.getY() + korak);
		}
		
	}
	
	
	public synchronized void pauziraj() {
		radi = false;
		timer.pauziraj();
	}
	
	public synchronized void nastavi() {
		radi = true;
		notify();
		timer.nastavi();
	}
	
	public synchronized void zavrsi() {
		radi = false;
		posao.interrupt();
		timer.zavrsi();
	}
	
	public synchronized boolean radi() {
		return this.radi;
	}
	
	public synchronized void dodajFiguru(Figura f) {
		try {
			for (figure.prvaTekuca(); figure.imaSledeca(); figure.sledeca()) {
				if (f.preklapa(figure.getTekuca())) {
					return;
				}
				if (f.preklapa(usisivac)) return;
			}
		} catch (Greska e) {}
		if (f.getR() + f.getX() > getPreferredSize().width || f.getX() - f.getR() < 0) return;
		if (f.getR() + f.getY() > getPreferredSize().height || f.getY() - f.getR() < 0) return;

		try {
			figure.dodaj(f);
		} catch (Greska e) {}
		
		if (figure.brojElemenata() == 1 && !radi) {//novo
			nastavi();
		}
		
		repaint();
		
	}

}
/*		
V2
		Panel panelDugmad = new Panel(new GridLayout(0, 1));
		radioDugmad = new CheckboxGroup();
		Checkbox levoDesno = new Checkbox("Levo-Desno", false, radioDugmad);
		panelDugmad.add(levoDesno);
		
		button = new Button("Dodaj");
		button.addActionListener((ae) -> {

v8_9_10
	Label west = new Label("west"),
		south.setAlignment(Label.RIGHT);

	west.setBackground(Color.MAGENTA);//dodas background oko labele 

loginForm
	private class QuitDialog extends Dialog {
	public QuitDialog(Frame owner) {
	g.drawString("Are you sure you want to quit?", 20, 70);//ovde moramo kordinate gde crtamo jer je paint

	private TextField password= new TextField(10);
********password.setEchoChar('*');//ne zelimo da se vidi sifra dok se kuca pa ce se slova zameniti *
	password.addTextListener((te) -> {//kada neko izmeni tekst u passwordu
	passStrength.setText("Weak password");				
	passStrength.setForeground(Color.GREEN);
	passStrength.revalidate();//ova metoda se automatski poziva kada menjamo velicinu prozora, ali bez ovoga nece biti lepo ispisano

	termsCb.addItemListener((ie) -> {if(ie.getStateChange() == ItemEvent.SELECTED){//listener za termsCb - radiodugme
	
	submit.setEnabled(false);//da dugme ne moze da se klikne
cardLayout.next(cardPanel);

coins
	//desava se da kad razvucemo prozor ne valja
	addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
			scene.packScene();
			scene.repaint();
			pack();
		}
	});

	Dialog help = new Dialog(this, ModalityType.APPLICATION_MODAL);//modality type. application modal nam govori da ne mozemo nista da uradimo dok ne odgovorimo na dialog

crtanje
	Choice chooseShape = new Choice();//padajuca lista
	List chooseColor = new List(2);			
	chooseColor.add("Black");
menu
	Menu bgColorMenu = new Menu("Bg color");
	bgColorMenu.add(bgWhite);

	Menu file = new Menu("File");
	file.add(bgColorMenu);

	MenuBar menuBar = new MenuBar();
	menuBar.add(file);
setmenu:this.setMenuBar(menuBar);
*/
