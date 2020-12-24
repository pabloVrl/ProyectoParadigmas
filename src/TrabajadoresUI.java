import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	
	//MENU PRINCIPAL DE TRABAJADORES
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
		
		//EVENTOS BOTONES MENU TRABAJADORES
		
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
		
		modificar .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//modificar ();
			}
			
		});
		
		consultar .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				consultar ();
			}
			
		});
		
		generarLiquidacion .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				generarLiquidacion ();
			}
			
		});
		
		//----------------------------------------//
		
	}
	//FUNCIÓN QUE AGREGA UN TRABAJADOR AL SISTEMA
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
		
		//VALIDACIÓN SALARIO
		fieldSalario.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				validacionDeNumeros(fieldSalario,ke);
			}
		});

		//VALIDACIÓN RUT
		fieldRut.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				validacionDeNumeros(fieldRut,ke);
			}
		});
		
		fieldRutVerif.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = fieldRutVerif.getText();
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
	        	validadorRutVerificador(fieldRutVerif, 1, e);
	        }
	    });

		
		fieldRut.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	        	validadorRutVerificador(fieldRut, 8, e);
	        }
	    });
		//------------------------------------------------------------//
		botonOpTrab(agregar);
		
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
	//FUNCIÓN QUE ELIMINA UN TRABAJADOR DEL SISTEMA
	public void eliminar() {
		removeAll();
		JLabel textTitulo = new JLabel("ELIMINAR TRABAJADOR");
		textTitulo.setBounds(115, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textRut = new JLabel("RUT:");
		textRut.setBounds(120, 210, 200, 25);
		textRut.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldRut = new JTextField();
		fieldRut.setBounds(240, 210, 210, 25);
		
		JLabel textGuion = new JLabel("-");
		textGuion.setBounds(455, 205, 200, 25);
		textGuion.setFont(new Font("",Font.BOLD,28));
		
		JTextField fieldRutVerif = new JTextField();
		fieldRutVerif.setBounds(470, 210, 20, 25);
		
		JButton delete = new JButton("ELIMINAR");
		delete.setBounds(250, 300, 100, 40);
		
		botonOpTrab(delete);
		
		//VALIDACION RUT	
		fieldRut.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				validacionDeNumeros(fieldRut,ke);
			}
		});
		
		fieldRutVerif.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = fieldRutVerif.getText();
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
	        	validadorRutVerificador(fieldRutVerif, 1, e);
	        }
	    });

		
		fieldRut.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	        	validadorRutVerificador(fieldRut, 8, e);
	        }
	    });
		
		//-----------------------------------------------------------//
	
		add(delete);
		add(textTitulo);
		add(textRut); add(fieldRut); add(fieldRutVerif); add(textGuion);
		repaint();
		
	}
	//FUNCIÓN QUE MODIFICA INFORMACIÓN DE UN TRABAJADOR
	public void modificar() {
		
	}
	//FUNCIÓN QUE PEGUNTA EL NOMBRE DEL TRABAJADOR PARA BUSCAR SUS DATOS		
	public void consultar() {
		removeAll();
		JLabel textTitulo = new JLabel("CONSULTAR DATOS TRABAJADORES");
		textTitulo.setBounds(40, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel nombres = new JLabel("Nombre: ");
		nombres.setBounds(40, 200, 200, 25);
		nombres.setFont(new Font("",Font.BOLD,22));
		
		JComboBox trabajadores = new JComboBox();
		trabajadores.setBounds(240, 200, 250, 25);
		
		JButton consultar = new JButton("CONSULTAR");
		consultar.setBounds(240, 350, 120, 45);
		
		botonOpTrab(consultar);
		
		consultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MostarDatos();	
			}	
		});
		
		add(textTitulo);
		add(nombres);
		add(trabajadores);
		add(consultar);
		
		repaint();
		validate();
		
	}
	//FUNCIÓN QUE MUESTRA DATOS DE UN TRABAJADOR
	public void MostarDatos() {
		removeAll();
		JLabel textTitulo = new JLabel("DATOS DEL TRABAJADOR");
		textTitulo.setBounds(125, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel nombres = new JLabel("Nombre: ");
		nombres.setBounds(160, 140, 100, 25);
		nombres.setFont(new Font("",Font.BOLD,22));
		
		JLabel nombreTrabajador = new JLabel("------------------");
		nombreTrabajador.setBounds(350, 140, 250, 25);
		nombreTrabajador.setFont(new Font("",Font.BOLD,22));
		
		JLabel apellidoP = new JLabel("Apellido Paterno: ");
		apellidoP.setBounds(120, 180, 200, 25);
		apellidoP.setFont(new Font("",Font.BOLD,22));
		
		JLabel apellidoPTrabajador = new JLabel("------------------");
		apellidoPTrabajador.setBounds(350, 180, 250, 25);
		apellidoPTrabajador.setFont(new Font("",Font.BOLD,22));
		
		
		JLabel apellidoM = new JLabel("Apellido Materno: ");
		apellidoM.setBounds(120, 220, 200, 25);
		apellidoM.setFont(new Font("",Font.BOLD,22));
		
		JLabel apellidoMTrabajador = new JLabel("------------------");
		apellidoMTrabajador.setBounds(350, 220, 250, 25);
		apellidoMTrabajador.setFont(new Font("",Font.BOLD,22));
		
		
		JLabel edad = new JLabel("Edad: ");
		edad.setBounds(170, 260, 100, 25);
		edad.setFont(new Font("",Font.BOLD,22));
		
		JLabel edadTrabajador = new JLabel("------------------");
		edadTrabajador.setBounds(350, 260, 210, 25);
		edadTrabajador.setFont(new Font("",Font.BOLD,22));
		
		JLabel tipoContrato = new JLabel("Tipo de contrato: ");
		tipoContrato.setBounds(120, 300, 200, 25);
		tipoContrato.setFont(new Font("",Font.BOLD,22));
		
		JLabel tipoContratoTrabajador = new JLabel("------------------");
		tipoContratoTrabajador.setBounds(350, 300, 210, 25);
		tipoContratoTrabajador.setFont(new Font("",Font.BOLD,22));
		
	
		JButton atras = new JButton("VOLVER");
		atras.setBounds(240, 350, 120, 45);
		
		botonOpTrab(atras);
		
		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				consultar();
			}
				
		});
		
		
		
		add(textTitulo);
		add(tipoContratoTrabajador);
		add(nombreTrabajador);
		add(apellidoPTrabajador);
		add(apellidoMTrabajador);
		add(edadTrabajador);
		add(nombres);
		add(apellidoM);
		add(apellidoP);
		add(edad);
		add(tipoContrato);
		add(atras);
		
		repaint();
		validate();
	}
	//FUNCIÓN QUE GENERA LA LIQUIDACIÓN DE SUELDO DE UN TRABAJADOR
	public void generarLiquidacion (){
		
		removeAll();
		JLabel textTitulo = new JLabel("GENERAR LIQUIDACION DE SUELDO");
		textTitulo.setBounds(50, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		
		JLabel nombre = new JLabel("Nombre: ");
		nombre.setBounds(40, 200, 200, 25);
		nombre.setFont(new Font("",Font.BOLD,25));
		
		JComboBox trabajadores = new JComboBox();
		trabajadores.setBounds(240, 200, 250, 25);
		
		JButton liquidacion = new JButton("GENERAR");
		liquidacion.setBounds(240, 350, 120, 45);
		
		botonOpTrab(liquidacion);
		
		liquidacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			MostrarLiquidacion();	
				
			}
			
			
				
		});
		add(textTitulo);
		add(nombre);
		add(trabajadores);
		add(liquidacion);
		
		repaint();
		validate();
	}
	//FUNCIÓN QUE MUESTA LOS DATOS DE LA LIQUIDACIÓN
	public void MostrarLiquidacion() {
		
		removeAll();
		JLabel textTitulo = new JLabel("LIQUIDACION DE SUELDO");
		textTitulo.setBounds(125, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JButton volver = new JButton("VOLVER");
		volver.setBounds(240, 350, 120, 45);
		
		botonOpTrab(volver);
		
		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				generarLiquidacion();
				
			}
				
		});
		
		add(textTitulo);
		add(volver);
		repaint();
	}
   //FUNCIÓN PARA PERSONALIZAR LOS BOTONES
   public void botonOpTrab(JButton boton){
		
		boton.setBackground(new Color(82, 82, 78));
		boton.setFocusPainted(false);
		boton.setFont(new Font("",Font.BOLD,13));
		boton.setForeground(Color.white);
		
	}
   
   //VALIDACIÓN PARA SOLO INGRESAR NÚMEROS
   public void validacionDeNumeros(JTextField string,KeyEvent ke) {
	   
	   String value = string.getText();
		int l = value.length();
		if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			string.setEditable(true);
		} else {
			string.setEditable(false);
		}
	   
   }
   //VALIDACIÓN PARA LIMITAR EL NÚMERO DE CARACTERES INGRESADOS
   public void validadorRutVerificador(JTextField fild, int num, KeyEvent e) {
	   
	   if (fild.getText().length() >= num ) // limit to 1 characters
           e.consume();
	   
   }
   
   
}
