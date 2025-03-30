package V1;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GrafickaSimulacija extends Frame {

	public GrafickaSimulacija() {
		//setBounds(700, 200, 500, 300);
		//setLocation(500, 200);
		setResizable(false);
		setTitle("Graficka Simulacija");
		
		 
		populateWindow();
		
		setLocation(700, 200);
		pack();
		
		scena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {//!!!!!dodaj ESC da bi moglo odmah ESC
					scena.zavrsi();
					dispose();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (scena.radi() == false) {
						scena.nastavi();
					} else {
						scena.pauziraj();
					}
					//scena.requestFocusInWindow();
				}
			}
		});
		//da bi moglo na samom pocetku esc
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {//!!!!!dodaj ESC da bi moglo odmah ESC
					scena.zavrsi();
					dispose();
				}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				scena.zavrsi();
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	private AktivnaScena scena;
	private Timer timer;
	
	private void populateWindow() {
		
		
		Label labela = new Label("Timer: ");
		add(labela, BorderLayout.SOUTH);
		labela.setAlignment(WIDTH);
		timer = new Timer(labela);
		
		scena = new AktivnaScena(this, timer);
		//ovde mozda treba jos stvari kao dimension itd.
		//Panel centerPanel = new Panel();
		//centerPanel.add(scena);
		add(scena, BorderLayout.CENTER);//mozda samo add (scena, BorderLayout.Center)
	}

	public static void main(String[] args) {
		new GrafickaSimulacija();
	}

}
