package v2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class Aplikacija extends Frame {
	
	private Kanalizacija kanalizacija;
	private CheckboxGroup radioDugmad;
	private Button button;

	public Aplikacija() {
		setLocation(400, 300);
		setTitle("Cevi");
		setResizable(false);
		populateWindow();
		pack();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}

	private void populateWindow() {
		
		//kanalizacija
		kanalizacija = new Kanalizacija(5, 5);
		//vrv ce morati mozda i kanalizacija da bude canvas ili tako nesto
		add(kanalizacija, BorderLayout.CENTER);
		
		//radio dugmad
		Panel panelDugmad = new Panel(new GridLayout(0, 1));
		
		radioDugmad = new CheckboxGroup();
		
		Checkbox levoDesno = new Checkbox("Levo-Desno", false, radioDugmad);
		Checkbox goreDole = new Checkbox("Gore-Dole", false, radioDugmad);
		Checkbox doleGore = new Checkbox("Dole-Gore", false, radioDugmad);
		Checkbox levoDole = new Checkbox("Levo-Dole", false, radioDugmad);
		Checkbox levoGore = new Checkbox("Levo-Gore", false, radioDugmad);
		Checkbox goreDesno = new Checkbox("Gore-Desno", false, radioDugmad);
		Checkbox doleDesno = new Checkbox("Dole-Desno", false, radioDugmad);
		
		panelDugmad.add(levoDesno);
		panelDugmad.add(goreDole);
		panelDugmad.add(doleGore);
		panelDugmad.add(levoDole);
		panelDugmad.add(levoGore);
		panelDugmad.add(goreDesno);
		panelDugmad.add(doleDesno);
		
		//dugme
		button = new Button("Dodaj");
		panelDugmad.add(button);
		
		dodajActionListenerDugme();
		
		add(panelDugmad, BorderLayout.EAST);
		
	}
	
	private void dodajActionListenerDugme(){
		button.addActionListener((ae) -> {
			if (radioDugmad.getSelectedCheckbox() == null) return;
			switch (radioDugmad.getSelectedCheckbox().getLabel()) {
			case "Levo-Desno":
				kanalizacija.dodajCev(new LevoDesnoCev());
				break;
			case "Gore-Dole":
				kanalizacija.dodajCev(new GoreDoleCev());
				break;
			case "Dole-Gore":
				kanalizacija.dodajCev(new DoleGoreCev());
				break;
			case "Levo-Dole":
				kanalizacija.dodajCev(new LevoDoleCev());
				break;
			case "Levo-Gore":
				kanalizacija.dodajCev(new LevoGoreCev());
				break;
			case "Gore-Desno":
				kanalizacija.dodajCev(new GoreDesnoCev());
				break;
			case "Dole-Desno":
				kanalizacija.dodajCev(new DoleDesnoCev());
				break;
			default:
				break;	
			}
			//kanalizacija.dodajCev()
		});
	}

	public static void main(String[] args) {
		
		Aplikacija aplikacija = new Aplikacija();
		
	}

}
