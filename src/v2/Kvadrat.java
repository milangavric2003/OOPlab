package v2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Kvadrat extends Canvas {
	
	private boolean oznacen;
	
	public Kvadrat(Color color) {
		
		setPreferredSize(new Dimension(75, 75));
		setBackground(color);
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Kanalizacija k = (Kanalizacija)(Kvadrat.this.getParent());//mozda k polje
					k.promeniOznaku(Kvadrat.this);
				} catch (GOznaka e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		if (oznacen) {
			g.setColor(Color.RED);
			g.drawRect(0, 0, getPreferredSize().width - 1, getPreferredSize().height - 1);
		}
		
	}
	
	public abstract boolean oznaciv();
	
	public void setOznaka() throws GOznaka {
		if (oznacen) oznacen = false;
		else if (!oznaciv()) throw new GOznaka();
		else oznacen = true;
	}
	
	public static void main(String[] args) {
		/*Kvadrat k = new Kvadrat(Color.RED);
		try {
			k.setOznaka();
		} catch (GOznaka e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
