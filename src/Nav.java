import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Nav extends JPanel{

	private JButton home, trabajadores, depa;
	private final Color fondo = new Color(220,214,247);
	 
	
	public Nav(){
		
		this.setSize(170, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		
		home = new JButton("Home");
		home.setBounds(0, 50,170 , 50);
		
		trabajadores = new JButton("Trabajadores");
		trabajadores.setBounds(0, 100, 170,50);
		
		depa = new JButton("Departamento");
		depa.setBounds(0, 150, 170, 50);
		depa.setBorderPainted(true);
		depa.setFocusPainted(false);
		depa.setBorder(new LineBorder(new Color(166, 177, 225)));
		depa.setContentAreaFilled(true);
		depa.setBackground(fondo);
		
		add(home);
		add(trabajadores);
		add(depa);
		
	}
	
	
	
	
	
	
}
