import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Home extends JPanel{
	JLabel bienvenida;
	
	private final Color fondo = new Color(0xe9e9e5);
	
	public Home() {
		this.setSize(800, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		
		Nav nav = new Nav();
		
		bienvenida = new JLabel("Bienvenido al sistema :)");
		bienvenida.setBounds(320, 25, 500, 50);
		bienvenida.setFont(new Font("", Font.BOLD,29));
		
		add(nav);
		add(bienvenida);
	}
}
