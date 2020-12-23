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
		bienvenido.setBounds(115, 45, 500, 50);
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
				
				ingresar();
			}
			
		});
		
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				eliminar();
			}
			
		});
		
		cantTrabajadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				cantTrabajadores();
			}
			
		});
		
		nrotrabajadores_depa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				nrotrabajadores_depa();
			}
			
		});
	}
	
	private void ingresar() {
		removeAll();
		JLabel textTitulo = new JLabel("INGRESAR DEPARTAMENTO");
		textTitulo.setBounds(115, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textNombre = new JLabel("Nombre:");
		textNombre.setBounds(130, 180, 100, 25);
		textNombre.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldNombre = new JTextField();
		fieldNombre.setBounds(240, 180, 250, 25);
		
		JButton agregar = new JButton("AGREGAR");
		agregar.setBounds(260, 280, 100, 40);
		
		botonOpDepa(agregar);
		
		add(textNombre);
		add(textTitulo);
		add(agregar);
		add(fieldNombre);
		repaint();
	}
	
	private void eliminar() {
		removeAll();
		JLabel textTitulo = new JLabel("ELIMINAR DEPARTAMENTO");
		textTitulo.setBounds(100, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textNombre = new JLabel("Nombre:");
		textNombre.setBounds(130, 180, 100, 25);
		textNombre.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldNombre = new JTextField();
		fieldNombre.setBounds(240, 180, 250, 25);
		
		JButton delete = new JButton("DELETE");
		delete.setBounds(260, 280, 100, 40);
		
		botonOpDepa(delete);

		add(textNombre);
		add(textTitulo);
		add(fieldNombre);
		add(delete);
		repaint();
	}
	
	private void cantTrabajadores() {
		removeAll();
		JLabel textTitulo = new JLabel("CANTIDAD TOTAL DE TRABAJADORES");
		textTitulo.setBounds(115, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel NroTotalTrabajadores = new JLabel();
		NroTotalTrabajadores.setBounds(100, 150, 50, 25);
		
		
		
		add(textTitulo);
		add(NroTotalTrabajadores);
		repaint();
	}
	
	private void nrotrabajadores_depa() {
		removeAll();
		JLabel textTitulo = new JLabel("NUMERO DE TRABAJADORES POR DEPTO");
		textTitulo.setBounds(50, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,25));
		
		JLabel nombreDepa = new JLabel("Nombre de departamento");
		nombreDepa.setBounds(80, 150, 200, 25);
		nombreDepa.setFont(new Font("",Font.BOLD,15));
		
		JLabel nameDepa = new JLabel(".");
		nameDepa.setBounds(80, 200, 200, 25);
		nameDepa.setFont(new Font("",Font.BOLD,15));
		
		JLabel trabDepa = new JLabel("Cantidad de trabajadores");
		trabDepa.setBounds(350, 150, 200, 25);
		trabDepa.setFont(new Font("",Font.BOLD,15));
		
		JLabel nroTrab = new JLabel(".");
		nroTrab.setBounds(350, 200, 200, 25);
		nroTrab.setFont(new Font("",Font.BOLD,15));
		
		add(textTitulo);
		add(nombreDepa);
		add(trabDepa);
		add(nroTrab);
		add(nameDepa);
		repaint();
	}
	
	public void botonOpDepa(JButton boton){
		
		boton.setBackground(new Color(82, 82, 78));
		boton.setFocusPainted(false);
		boton.setFont(new Font("",Font.BOLD,13));
		boton.setForeground(Color.white);
		
	}
	
	
	
	
}
