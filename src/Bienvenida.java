import java.awt.Color;import java.awt.Font;

import javax.swing.*;

public class Bienvenida extends JPanel {
	JLabel bienv;
	private final Color fondo = new Color(0xe9e9e5);
	
	public Bienvenida() {
		this.setBounds(170, 0, 615, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		
		bienv = new JLabel("BIENVENID@ AL SISTEMA");
		bienv.setBounds(115, 45, 500, 50);
		bienv.setFont(new Font("", Font.BOLD, 29));
		
		add(bienv);
	}
}
