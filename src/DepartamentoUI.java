import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DepartamentoUI extends JPanel{

	JLabel bienvenido;
	JPanel ingresarUI;
	JButton eliminar;
	JButton ingresar;
	JButton cantTrabajadores;
	JButton nrotrabajadores_depa;
	
	private final Color fondo = new Color(0xe9e9e5);
	
	public DepartamentoUI() {
		this.setBounds(170, 0, 615, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		
		bienvenido = new JLabel("PANEL DE DEPARTAMENTO");
		bienvenido.setBounds(100, 25, 500, 50);
		bienvenido.setFont(new Font("",Font.BOLD,29));
		
		JButton ingresar = new JButton("INGRESAR DEPARTAMENTO");
	    ingresar.setBounds(60, 140, 500, 50);
		
		JButton eliminar = new JButton("ELIMINAR DEPARTAMENTO");
		eliminar.setBounds(60, 200, 500, 50);
		
		JButton cantTrabajadores = new JButton("CANTIDAD TOTAL DE TRABAJADORES");
		cantTrabajadores.setBounds(60, 260, 500, 50);
		
		JButton nrotrabajadores_depa = new JButton("NUMERO DE TRABAJADORES POR DEPARTAMENTO");
		nrotrabajadores_depa.setBounds(60, 320, 500, 50);
		
		JButton botones[] = {ingresar, eliminar, cantTrabajadores, nrotrabajadores_depa};
		for(int i = 0; i < 4; i++) {
			botones[i].setBackground(new Color(82, 82, 78));
			botones[i].setFocusPainted(false);
			botones[i].setFont(new Font("",Font.BOLD,20));
			botones[i].setForeground(Color.white);
			add(botones[i]);
			
		}
		
		// Panel ingresarUI
		ingresarUI = new JPanel();
		ingresarUI.setBounds(170, 0, 615, 500);
		ingresarUI.setBackground(fondo);
		ingresarUI.setLayout(null);
		
		ingresarUI.add(bienvenido);
		
		
		
		add(bienvenido);
		add(ingresar);
		add(eliminar);
		add(cantTrabajadores);
		add(nrotrabajadores_depa);
		
		ingresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("funciona");
				
			}
			
		});
		
	}
	
	
	
	
}
