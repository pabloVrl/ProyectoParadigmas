import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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
		textContrato.setBounds(75, 240, 200, 25);
		textContrato.setFont(new Font("",Font.BOLD,16));
		
		JComboBox tipoContrato = new JComboBox(Trabajador.contratos);
		tipoContrato.setBounds(240, 240, 250, 25);
		
		JLabel textDepa = new JLabel("Departamento:");
		textDepa.setBounds(75, 270, 200, 25);
		textDepa.setFont(new Font("",Font.BOLD,16));
		
		JComboBox departamento = new JComboBox();
		departamento.setBounds(240, 270, 250, 25);
		
		JLabel textNacimiento = new JLabel("Nacimiento:");
		textNacimiento.setBounds(80, 300, 200, 25);
		textNacimiento.setFont(new Font("",Font.BOLD,16));
		
		JComboBox dia = new JComboBox(Trabajador.dia.toArray());
		dia.setBounds(240, 300, 50, 25);
		
		JComboBox mes = new JComboBox(Trabajador.mes.toArray());
		mes.setBounds(300, 300, 50, 25);
		
		JComboBox anio = new JComboBox(Trabajador.anio.toArray());
		anio.setBounds(360, 300, 100, 25);
		
		JLabel textSalario = new JLabel("Salario por hora:");
		textSalario.setBounds(60, 330, 200, 25);
		textSalario.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldSalario = new JTextField();
		fieldSalario.setBounds(240, 330, 250, 25);
		
		JButton agregar = new JButton("AGREGAR");
		agregar.setBounds(250, 380, 100, 40);
		
		fieldSalario.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = fieldSalario.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					fieldSalario.setEditable(true);
				} else {
					fieldSalario.setEditable(false);
				}
			}
		});

		fieldRut.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = fieldSalario.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					fieldRut.setEditable(true);
				} else {
					fieldRut.setEditable(false);
				}
			}
		});
		
		fieldRutVerif.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = fieldSalario.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == 'K' || ke.getKeyChar() == 'k' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					fieldRutVerif.setEditable(true);
				} else {
					fieldRutVerif.setEditable(false);
				}
			}
		});
		
		fieldRutVerif.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (fieldRutVerif.getText().length() >= 1 ) // limit to 1 characters
	                e.consume();
	        }
	    });

		
		fieldRut.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (fieldRut.getText().length() >= 8 ) // limit to 9 characters
	                e.consume();
	        }
	    });
		
		botonOpDepa(agregar);
		
		add(textTitulo);
		add(textNombre); add(fieldNombre);
		add(textApellidoM); add(fieldApellidoM);
		add(textApellidoP); add(fieldApellidoP);
		add(agregar);
		add(textContrato); add(tipoContrato);
		add(textRut); add(fieldRut); 
		add(fieldRutVerif); add(textGuion);
		add(textDepa); add(departamento);
		add(textNacimiento); add(dia); add(mes); add(anio);
		add(textSalario); add(fieldSalario);
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
