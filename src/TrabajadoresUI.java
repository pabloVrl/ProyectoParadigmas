import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class TrabajadoresUI extends JPanel{
	JLabel bienvenida;
	
	private final Color fondo = new Color(0xe9e9e5);
	
	public TrabajadoresUI() {
		this.setSize(800, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		
		Nav nav = new Nav();
		
		bienvenida = new JLabel("PANEL DE TRABAJADORES");
		bienvenida.setBounds(320, 25, 500, 50);
		bienvenida.setFont(new Font("", Font.BOLD,29));
		
		add(nav);
		add(bienvenida);
	}
}
