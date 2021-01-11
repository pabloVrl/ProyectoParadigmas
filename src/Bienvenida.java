import java.awt.Color;

import java.awt.Font;


import javax.swing.*;

public class Bienvenida extends JPanel {
	JLabel bienv,bienv2;
	
	
	private final Color fondo = new Color(0xe9e9e5);
	
	//CONSTRUCTOR DE LA CLASE BIENVENIDA
	public Bienvenida() {
		this.setBounds(170, 0, 615, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		
		bienv = new JLabel("BIENVENIDO A LA CHOZA");
		bienv.setBounds(115, 45, 500, 30);
		bienv.setFont(new Font("", Font.BOLD, 29));
		
		bienv2 = new JLabel("DE CONCRETO");
		bienv2.setBounds(185, 85, 500, 30);
		bienv2.setFont(new Font("", Font.BOLD, 29));
		
		
		JLabel img = new JLabel();
		img.setBounds(120, 120, 460, 350);
		//agrega imagen al inicio
		img.setIcon (new ImageIcon("./res/img/img inicio.png"));
		
		add(img);
		add(bienv);
		add(bienv2);
	}
	
}
