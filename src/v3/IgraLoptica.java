package v3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IgraLoptica extends Frame {
	
	private Scena scena;

	public IgraLoptica() {
		setTitle("Loptica");
		setLocation(400, 300);
		setResizable(false);
		
		populateWindow();
		pack();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				scena.zaustavi();
				dispose();
			}
		});
		
		
		setVisible(true);
	}
	
	private void populateWindow() {
		scena = new Scena();
		scena.setPreferredSize(new Dimension(500, 500));

		Igrac igrac = new Igrac(scena, 20, 80);
		scena.dodajFiguru(igrac);
		
		//cigle
		int sirinaCigle = 99;
		int visinaCigle = 25;
		int xPocetno = sirinaCigle / 2;
		int yPocetno = visinaCigle / 2;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				scena.dodajFiguru(new Cigla(scena, xPocetno, yPocetno, sirinaCigle, visinaCigle, 70));
				xPocetno += sirinaCigle + 1;
			}
			xPocetno = sirinaCigle / 2;
			yPocetno += visinaCigle + 1;
		}
		
		
		scena.pokreni();
		add(scena, BorderLayout.CENTER);

		//listeneri
		scena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				igrac.ispaliLopticu();
				scena.repaint();
			}
			
		});
		
		scena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_A:
					igrac.pomeri(-10, 0);
					scena.repaint();
					break;
				case KeyEvent.VK_D:
					igrac.pomeri(10, 0);
					scena.repaint();
					break;
				default:
				}
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_A:
					igrac.pomeri(-10, 0);
					scena.repaint();
					break;
				case KeyEvent.VK_D:
					igrac.pomeri(10, 0);
					scena.repaint();
					break;
				default:
				}
			}
		});
		
		
	}

	public static void main(String[] args) {
		IgraLoptica igra = new IgraLoptica();
	}

}
