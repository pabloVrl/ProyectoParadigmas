import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DepartamentoUI extends JPanel{

	JLabel bienvenido;
	JButton eliminar;
	JButton ingresar;
	JButton cantTrabajadores;
	JButton nrotrabajadores_depa;
	
	private final Color fondo = new Color(0xe9e9e5);
	
	public DepartamentoUI() {
		home();
		
		
	}
	
	public void home() {
		this.removeAll();
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
		
		add(bienvenido);
		add(ingresar);
		add(eliminar);
		add(cantTrabajadores);
		add(nrotrabajadores_depa);
		
		ingresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("FUNKA");
				ingresar();
			}
			
		});
		
	}
	
	private void ingresar() {
		removeAll();
		JLabel textTitulo = new JLabel("INGRESAR DEPARTAMENTO");
		textTitulo.setBounds(100, 25, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textNombre = new JLabel("Nombre");
		textNombre.setBounds(100, 150, 50, 25);
		
		JTextField fieldNombre = new JTextField();
		fieldNombre.setBounds(150, 150, 250, 25);
		
		add(textNombre);
		add(textTitulo);
		add(fieldNombre);
		repaint();
	}
	
	
	
	
}
