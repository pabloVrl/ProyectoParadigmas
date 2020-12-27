import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	//MENU PRINCIPAL DE DEPARTAMENTO 
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
		
		JButton nrotrabajadores_depa = new JButton("NÚMERO DE TRABAJADORES POR DEPARTAMENTO");
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
		
		repaint();
		revalidate();
		
		//EVENTOS BOTONES MENU DEPARTAMENTO
		
		ingresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ingresar();
			}
			
		});
		
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
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
		//-------------------------------------------------------------------//
	}
	
	//FUNCIÓN INGRESAR DEPARTAMENTO AL SISTEMA
	private void ingresar() {
		removeAll();
		JLabel textTitulo = new JLabel("INGRESAR DEPARTAMENTO");
		textTitulo.setBounds(115, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textNombre = new JLabel("Nombre:");
		textNombre.setBounds(110, 180, 100, 25);
		textNombre.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldNombre = new JTextField();
		fieldNombre.setBounds(240, 180, 250, 25);
		
//		JLabel textNumero = new JLabel("Número:");
//		textNumero.setBounds(110, 230, 100, 25);
//		textNumero.setFont(new Font("",Font.BOLD,16));
//		
//		JTextField fieldNumero = new JTextField();
//		fieldNumero.setBounds(240, 230, 250, 25);
		
		
		JButton agregar = new JButton("AGREGAR");
		agregar.setBounds(240, 320, 100, 40);
		
		botonOpDepa(agregar);
		
		agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Departamento p = new Departamento(fieldNombre.getText());
				home();
			}
			
		});
		
//		add(fieldNumero);
//		add(textNumero);
		add(textNombre);
		add(textTitulo);
		add(agregar);
		add(fieldNombre);
		repaint();
	}
	//FUNCIÓN QUE TE PERMITE ELIMINAR DEPARTAMENTO DEL SISTEMA
	private void eliminar() {
		removeAll();
		JLabel textTitulo = new JLabel("ELIMINAR DEPARTAMENTO");
		textTitulo.setBounds(100, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textNombre = new JLabel("Nombre:");
		textNombre.setBounds(120, 200, 100, 25);
		textNombre.setFont(new Font("",Font.BOLD,16));
		
		JComboBox depa = new JComboBox(Departamento.getNombresDeptos().toArray());
		depa.setBounds(240, 200, 200, 25);
		
		JButton delete = new JButton("ELIMINAR");
		delete.setBounds(240, 320, 100, 40);
		
		botonOpDepa(delete);
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				remove(depa);
				Departamento.eliminarDepa((String) depa.getSelectedItem());
				JComboBox depa = new JComboBox(Departamento.getNombresDeptos().toArray());
				depa.setBounds(240, 200, 200, 25);
				add(depa);
				repaint();
				revalidate();
				eliminar();
			}
			
		});

		add(textNombre);
		add(textTitulo);
		add(depa);
		add(delete);
		repaint();
		validate();
	}
	//FUNCIÓN QUE TE MUESTRA EL TOTAL DE TRABAJADORES EN LA EMPRESA
	private void cantTrabajadores() {
		removeAll();
		JLabel textTitulo = new JLabel("CANTIDAD TOTAL DE TRABAJADORES");
		textTitulo.setBounds(40, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel NroTotalTrabajadores = new JLabel("La cantidad es: " + Departamento.getNroTotalTrabajadores());
		NroTotalTrabajadores.setBounds(100, 180, 300, 25);
		NroTotalTrabajadores.setFont(new Font("",Font.BOLD,29));
		
		
		add(textTitulo);
		add(NroTotalTrabajadores);
		repaint();
	}
	//FUNCIÓN QUE TE MUESTRA LA CANTIDAD DE TRABAJADORES DEPENDIENDO DEL DEPARTAMENTO
	private void nrotrabajadores_depa() {
		removeAll();
		JLabel textTitulo = new JLabel("NÚMERO DE TRABAJADORES");
		textTitulo.setBounds(100, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textTitulo2 = new JLabel("POR DEPARTAMENTO");
		textTitulo2.setBounds(150, 80, 400, 50);
		textTitulo2.setFont(new Font("",Font.BOLD,29));
		
		JLabel nameDepa = new JLabel("Nombre de departamentos");
		nameDepa.setBounds(50, 200, 300, 25);
		nameDepa.setFont(new Font("",Font.BOLD,20));
		
		revalidate();
		JComboBox nombreDepa = new JComboBox(Departamento.getNombresDeptos().toArray());
		nombreDepa.setBounds(60, 250, 200, 25);
		nombreDepa.setFont(new Font("",Font.BOLD,20));
		
		JLabel trabDepa = new JLabel("Cantidad de trabajadores");
		trabDepa.setBounds(350, 200, 300, 25);
		trabDepa.setFont(new Font("",Font.BOLD,20));
		
		JLabel nroTrab = new JLabel(Departamento.getNumeroTrabajadores((String) nombreDepa.getSelectedItem()));
		nroTrab.setBounds(350, 250, 200, 25);
		nroTrab.setFont(new Font("",Font.BOLD,20));
		
		nombreDepa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nroTrab.setText(Departamento.getNumeroTrabajadores((String) nombreDepa.getSelectedItem()));
				
			}
			
		});
		
		
		add(textTitulo);
		add(textTitulo2);
		add(nombreDepa);
		add(trabDepa);
		add(nroTrab);
		add(nameDepa);
		repaint();
		validate();
	}
    //EDITOR DE BOTONES
	public void botonOpDepa(JButton boton){
		
		boton.setBackground(new Color(82, 82, 78));
		boton.setFocusPainted(false);
		boton.setFont(new Font("",Font.BOLD,13));
		boton.setForeground(Color.white);
		
	}
	
	
	
	
}
