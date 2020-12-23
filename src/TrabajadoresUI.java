import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TrabajadoresUI extends JPanel{
	JLabel bienvenida;
	JButton ingresar;
	JButton modificar;
	JButton eliminar;
	JButton consultar;
	JButton generarLiquidacion;
	
	private final Color fondo = new Color(0xe9e9e5);
	
	public TrabajadoresUI() {
		this.setBounds(170, 0, 615, 500);
		this.setBackground(fondo);
		this.setLayout(null);
		home();
		
		
	}
	public void home() {
		this.removeAll();
		
		bienvenida = new JLabel("PANEL DE TRABAJADORES");
		bienvenida.setBounds(115, 45, 500, 50);
		bienvenida.setFont(new Font("", Font.BOLD,29));
		
		JButton ingresar = new JButton("INGRESAR TRABAJADOR");
	    ingresar.setBounds(60, 140, 500, 50);
		
		JButton eliminar = new JButton("ELIMINAR TRABAJADOR");
		eliminar.setBounds(60, 200, 500, 50);
		
		JButton modificar = new JButton("MODIFICAR TRABAJADOR");
		modificar.setBounds(60, 260, 500, 50);
		
		JButton consultar = new JButton("CONSULTAR DATOS DEL TRABAJADOR");
		consultar.setBounds(60, 320, 500, 50);
		
		JButton generarLiquidacion = new JButton("GENERAR LIQUIDACION");
		generarLiquidacion.setBounds(60, 380, 500, 50);
		
		JButton botones[] = {ingresar, eliminar, modificar,consultar ,generarLiquidacion};
		
		for(int i=0;i<5;i++) {
			
			botones[i].setBackground(new Color(82, 82, 78));
			botones[i].setFocusPainted(false);
			botones[i].setFont(new Font("",Font.BOLD,20));
			botones[i].setForeground(Color.white);
			add(botones[i]);
		
		}
		add(bienvenida);
		
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
				
				//eliminar();
			}
			
		});
		
		modificar .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//modificar ();
			}
			
		});
		
		consultar .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//consultar ();
			}
			
		});
		
		generarLiquidacion .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//generarLiquidacion ();
			}
			
		});
		
		
		
	}
	
	public void ingresar() {
		
		removeAll();
		JLabel textTitulo = new JLabel("INGRESAR TRABAJADOR");
		textTitulo.setBounds(115, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textNombre = new JLabel("Nombre:");
		textNombre.setBounds(90, 120, 100, 25);
		textNombre.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldNombre = new JTextField();
		fieldNombre.setBounds(240, 120, 250, 25);
		
		JLabel textApellidoP = new JLabel("Apellido Paterno:");
		textApellidoP.setBounds(60, 150, 200, 25);
		textApellidoP.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldApellidoP = new JTextField();
		fieldApellidoP.setBounds(240, 150, 250, 25);
		
		JLabel textApellidoM = new JLabel("Apellido Materno:");
		textApellidoM.setBounds(60, 180, 200, 25);
		textApellidoM.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldApellidoM = new JTextField();
		fieldApellidoM.setBounds(240, 180, 250, 25);
		
		JLabel textRut = new JLabel("RUT:");
		textRut.setBounds(110, 210, 200, 25);
		textRut.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldRut = new JTextField();
		fieldRut.setBounds(240, 210, 210, 25);
		
		JLabel textGuion = new JLabel("-");
		textGuion.setBounds(455, 205, 200, 25);
		textGuion.setFont(new Font("",Font.BOLD,28));
		
		JTextField fieldRutVerif = new JTextField();
		fieldRutVerif.setBounds(470, 210, 20, 25);
		
		JLabel textContrato = new JLabel("Tipo Contrato:");
		textContrato.setBounds(60, 270, 200, 25);
		textContrato.setFont(new Font("",Font.BOLD,16));
		
		JButton agregar = new JButton("AGREGAR");
		agregar.setBounds(250, 270, 100, 40);
		
		JComboBox tipoContrato = new JComboBox(Trabajador.contratos);
		tipoContrato.setBounds(240, 270, 200, 25);
		
		botonOpDepa(agregar);
		
		add(textNombre);
		add(textTitulo);
		add(textApellidoM);
		add(textApellidoP);
		add(fieldApellidoM);
		add(fieldApellidoP);
		add(agregar);
		add(fieldNombre);
		add(textContrato);
		add(tipoContrato);
		add(textRut); add(fieldRut); add(fieldRutVerif); add(textGuion);
		revalidate();
		repaint();
	}
	
	
   public void botonOpDepa(JButton boton){
		
		boton.setBackground(new Color(82, 82, 78));
		boton.setFocusPainted(false);
		boton.setFont(new Font("",Font.BOLD,13));
		boton.setForeground(Color.white);
		
	}
}
