import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Nav extends JPanel{

	private JButton home, trabajadores, depa;
	private final Color fondo = new Color(82, 82, 78);
	 
	
	public Nav(){
		
		this.setBounds(0, 0, 170, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		
		
		home = new JButton("Home");
		home.setBounds(0, 50, 170, 50);
		
		
		trabajadores = new JButton("Trabajadores");
		trabajadores.setBounds(0, 100, 170, 50);
		
		depa = new JButton("Departamentos");
		depa.setBounds(0, 150, 170, 50);
		
		JButton botones[] = {home, trabajadores, depa};
		for(int i = 0; i < 3; i++) {
			botones[i].setBackground(fondo);
			botones[i].setBorder(new LineBorder(new Color(102, 102, 98), 6));
			botones[i].setFocusPainted(false);
			botones[i].setForeground(Color.WHITE);
			add(botones[i]);
		}
		
		
	}
	
	
	
	
	
	
}
