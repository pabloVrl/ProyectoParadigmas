import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.*;

import org.json.JSONException;
import org.json.JSONObject;

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
		removeAll();
		
		bienvenida = new JLabel("PANEL DE TRABAJADORES");
		bienvenida.setBounds(115, 45, 500, 50);
		bienvenida.setFont(new Font("", Font.BOLD,29));
		
		JButton ingresar = new JButton("INGRESAR TRABAJADOR");
	    ingresar.setBounds(60, 140, 500, 50);
		
		JButton eliminar = new JButton("OPERACIONES CON TRABAJADORES");
		eliminar.setBounds(60, 200, 500, 50);
		

		JButton botones[] = {ingresar, eliminar};
		
		for(int i=0;i<2;i++) {
			
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
				
				operaciones();
			}
			
		});
	}
	//FUNCI�N QUE AGREGA UN TRABAJADOR AL SISTEMA
	public void ingresar() {
		if(!Departamento.departamentos.isEmpty()) {
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

			JComboBox<String> tipoContrato = new JComboBox<String>(Trabajador.contratos);
			tipoContrato.setBounds(240, 240, 250, 25);

			JLabel textDepa = new JLabel("Departamento:");
			textDepa.setBounds(75, 270, 200, 25);
			textDepa.setFont(new Font("",Font.BOLD,16));

			JComboBox departamento = new JComboBox(Departamento.getNombresDeptos().toArray());
			departamento.setBounds(240, 270, 250, 25);

			JLabel textNacimiento = new JLabel("Nacimiento:");
			textNacimiento.setBounds(80, 300, 200, 25);
			textNacimiento.setFont(new Font("",Font.BOLD,16));

			JComboBox dia = new JComboBox(FechaNacimiento.arrDia.toArray());
			dia.setBounds(240, 300, 50, 25);

			JComboBox mes = new JComboBox(FechaNacimiento.arrMes.toArray());
			mes.setBounds(300, 300, 50, 25);

			JComboBox anio = new JComboBox(FechaNacimiento.arrAnio.toArray());
			anio.setBounds(360, 300, 100, 25);

			JLabel textSalario = new JLabel("Salario por hora:");
			textSalario.setBounds(60, 330, 200, 25);
			textSalario.setFont(new Font("",Font.BOLD,16));

			JTextField fieldSalario = new JTextField();
			fieldSalario.setBounds(240, 330, 250, 25);

			JButton agregar = new JButton("AGREGAR");
			agregar.setBounds(250, 380, 100, 40);

			//VALIDACI�N SALARIO
			fieldSalario.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
					validacionDeNumeros(fieldSalario,ke);
				}
			});

			//VALIDACI�N RUT
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

			agregar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Rut rut = new Rut(fieldRut.getText(), fieldRutVerif.getText());
					String nombre = fieldNombre.getText();
					String apellidoP = fieldApellidoP.getText();
					String apellidoM = fieldApellidoM.getText();
					String diaNac = (String) dia.getSelectedItem();
					String mesNac = (String) mes.getSelectedItem();
					String anioNac = (String) anio.getSelectedItem();
					FechaNacimiento fechaNac = new FechaNacimiento(diaNac, mesNac, anioNac);
					String contrato = (String) tipoContrato.getSelectedItem();
					int salario = Integer.parseInt(fieldSalario.getText());
					String depa = (String) departamento.getSelectedItem();
					new Trabajador(rut, nombre, apellidoP, apellidoM, fechaNac, contrato, salario, depa);
					Departamento.addTrabajador(depa);
					JOptionPane.showMessageDialog(null, "Usuario creado!");
					ingresar();
				}

			});

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
		else {
			JOptionPane.showMessageDialog(null, "NO se puede crear trabajador si NO hay departamentos");
			home();
		}
	}
	//FUNCI�N QUE ELIMINA UN TRABAJADOR DEL SISTEMA
	public void operaciones() {
		removeAll();
		JLabel textTitulo = new JLabel("Ingrese el rut de un trabajador");
		textTitulo.setBounds(115, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textRut = new JLabel("RUT:");
		textRut.setBounds(120, 100, 200, 25);
		textRut.setFont(new Font("",Font.BOLD,16));
		
		JTextField fieldRut = new JTextField();
		fieldRut.setBounds(240, 100, 210, 25);
		
		JLabel textGuion = new JLabel("-");
		textGuion.setBounds(455, 95, 200, 25);
		textGuion.setFont(new Font("",Font.BOLD,28));
		
		JTextField fieldRutVerif = new JTextField();
		fieldRutVerif.setBounds(470, 100, 20, 25);
		
		JButton delete = new JButton("ELIMINAR");
		delete.setBounds(70, 395, 100, 40);
		botonOpTrab(delete);
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBounds(190, 395, 100, 40);
		botonOpTrab(modificar);
		
		JButton consultar = new JButton("DATOS");
		consultar.setBounds(310, 395, 100, 40);
		botonOpTrab(consultar);
		
		JButton liquidacion = new JButton("LIQUIDACI�N");
		liquidacion.setBounds(430, 395, 110, 40);
		botonOpTrab(liquidacion);
		
		Trabajador.llenarMatriz();
		
		TablaDatos datos = new TablaDatos(35, 150, 550, 225);
		
		liquidacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean entro = false;
				String rut = fieldRut.getText()+"-"+fieldRutVerif.getText();
				for(String r: Trabajador.getRuts()) {
					if(rut.equals(r)) {
						MostrarLiquidacion(rut);
						entro = true;
					}
				}

				if(!entro) {
					JOptionPane.showMessageDialog(null, "RUT INV�LIDO");
				}
			}
			
		});
		
		consultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean entro = false;
				String rut = fieldRut.getText()+"-"+fieldRutVerif.getText();
				for(String r: Trabajador.getRuts()) {
					if(rut.equals(r)) {
						mostrarDatos(rut);
						entro = true;
					}
				}

				if(!entro) {
					JOptionPane.showMessageDialog(null, "RUT INV�LIDO");
				}
			}
			
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean entro = false;
				String rut = fieldRut.getText()+"-"+fieldRutVerif.getText();
				for(String r: Trabajador.getRuts()) {
					if(rut.equals(r)) {
						try {
							Trabajador.eliminarTrabajador(rut);	
							entro = true;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

				if(!entro) {
					JOptionPane.showMessageDialog(null, "RUT INV�LIDO");
				}
				
				operaciones();
				
			}
			
		});
		
		modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean entro = false;
				String rut = fieldRut.getText()+"-"+fieldRutVerif.getText();
				for(String r: Trabajador.getRuts()) {
					if(rut.equals(r)) {
						modificar(rut);
						entro = true;
					}
				}

				if(!entro) {
					JOptionPane.showMessageDialog(null, "RUT INV�LIDO");
				}
			}
		});
		
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
		add(datos.getSP());
		repaint();
		add(liquidacion);
		add(consultar);
		add(modificar);
		add(delete);
		add(textTitulo);
		add(textRut); add(fieldRut); add(fieldRutVerif); add(textGuion);
		setVisible(true);
		repaint();
		validate();
		
	}
	
	private void mostrarDatos(String rut) {
		removeAll();

		JSONObject t = Trabajador.getObjRut(rut);
		JSONObject nac = t.getJSONObject("fechaNacimiento");
		
		JLabel nombre, r, contr, depto, naci, sal;
		
		nombre = new JLabel("Nombre: " + t.getString("nombre")+ " " + t.getString("apellidoPaterno") + " " + t.getString("apellidoMaterno"));
		nombre.setBounds(30, 30, 500, 25);
		nombre.setFont(new Font("",Font.BOLD,16));
		
		r = new JLabel("RUT: " + rut);
		r.setBounds(30, 60, 500, 25);
		r.setFont(new Font("",Font.BOLD,16));
		
		contr = new JLabel("Contrato: " + t.getString("tipoContrato"));
		contr.setBounds(30, 90, 500, 25);
		contr.setFont(new Font("",Font.BOLD,16));
		
		depto = new JLabel("Departamento: " + t.getString("departamento"));
		depto.setBounds(30, 120, 500, 25);
		depto.setFont(new Font("",Font.BOLD,16));
		
		naci = new JLabel("Fecha Nacimiento: " + nac.getString("dia")+"/"+nac.getString("mes")+"/"+nac.getString("a�o"));
		naci.setBounds(30, 150, 500, 25);
		naci.setFont(new Font("",Font.BOLD,16));
		
		sal = new JLabel("Salario por hora: " + String.valueOf(t.getInt("salarioPorHora")));
		sal.setBounds(30, 180, 500, 25);
		sal.setFont(new Font("",Font.BOLD,16));
		
		JButton volver = new JButton("Volver");
		volver.setBounds(30, 250, 100, 25);
		botonOpTrab(volver);
		
		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				operaciones();
			}
			
		});
		
		add(volver);
		add(sal);
		add(naci);
		add(depto);
		add(contr);
		add(r);
		add(nombre);
		
		repaint();
	}
	//FUNCI�N QUE MODIFICA INFORMACI�N DE UN TRABAJADOR
	private void modificar(String rut) {
		removeAll();
		
		JSONObject t = Trabajador.getObjRut(rut);
		
		JLabel textTitulo = new JLabel("MODIFICAR TRABAJADOR");
		textTitulo.setBounds(115, 45, 500, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));

		JLabel textNombre = new JLabel("Nombre:");
		textNombre.setBounds(90, 120, 100, 25);
		textNombre.setFont(new Font("",Font.BOLD,16));

		JTextField fieldNombre = new JTextField(t.getString("nombre"));
		fieldNombre.setBounds(240, 120, 250, 25);

		JLabel textApellidoP = new JLabel("Apellido Paterno:");
		textApellidoP.setBounds(60, 150, 200, 25);
		textApellidoP.setFont(new Font("",Font.BOLD,16));

		JTextField fieldApellidoP = new JTextField(t.getString("apellidoPaterno"));
		fieldApellidoP.setBounds(240, 150, 250, 25);

		JLabel textApellidoM = new JLabel("Apellido Materno:");
		textApellidoM.setBounds(60, 180, 200, 25);
		textApellidoM.setFont(new Font("",Font.BOLD,16));

		JTextField fieldApellidoM = new JTextField(t.getString("apellidoMaterno"));
		fieldApellidoM.setBounds(240, 180, 250, 25);

		JLabel textRut = new JLabel("RUT:");
		textRut.setBounds(110, 210, 200, 25);
		textRut.setFont(new Font("",Font.BOLD,16));

		JTextField fieldRut = new JTextField(t.getString("rut").split("-")[0]);
		fieldRut.setBounds(240, 210, 210, 25);

		JLabel textGuion = new JLabel("-");
		textGuion.setBounds(455, 205, 200, 25);
		textGuion.setFont(new Font("",Font.BOLD,28));

		JTextField fieldRutVerif = new JTextField(t.getString("rut").split("-")[1]);
		fieldRutVerif.setBounds(470, 210, 20, 25);

		JLabel textContrato = new JLabel("Tipo Contrato:");
		textContrato.setBounds(75, 240, 200, 25);
		textContrato.setFont(new Font("",Font.BOLD,16));

		JComboBox<String> tipoContrato = new JComboBox<String>(Trabajador.contratos);
		tipoContrato.setBounds(240, 240, 250, 25);

		JLabel textDepa = new JLabel("Departamento:");
		textDepa.setBounds(75, 270, 200, 25);
		textDepa.setFont(new Font("",Font.BOLD,16));

		JComboBox departamento = new JComboBox(Departamento.getNombresDeptos().toArray());
		departamento.setBounds(240, 270, 250, 25);
		for(int i = 0; i < Departamento.departamentos.length(); i++) {
			String actual = (String) departamento.getItemAt(i);
			if(actual.equals(t.getString("departamento"))) {
				departamento.setSelectedIndex(i);
				break;
			}
		}

		JLabel textNacimiento = new JLabel("Nacimiento:");
		textNacimiento.setBounds(80, 300, 200, 25);
		textNacimiento.setFont(new Font("",Font.BOLD,16));
		
		JSONObject nac = t.getJSONObject("fechaNacimiento");
	
		JComboBox dia = new JComboBox(FechaNacimiento.arrDia.toArray());
		dia.setBounds(240, 300, 50, 25);
		dia.setSelectedIndex(Integer.parseInt(nac.getString("dia")) - 1);

		JComboBox mes = new JComboBox(FechaNacimiento.arrMes.toArray());
		mes.setBounds(300, 300, 50, 25);
		mes.setSelectedIndex(Integer.parseInt(nac.getString("mes")) - 1);
		

		JComboBox anio = new JComboBox(FechaNacimiento.arrAnio.toArray());
		anio.setBounds(360, 300, 100, 25);
		anio.setSelectedIndex(2020 - Integer.parseInt(nac.getString("a�o")));

		JLabel textSalario = new JLabel("Salario por hora:");
		textSalario.setBounds(60, 330, 200, 25);
		textSalario.setFont(new Font("",Font.BOLD,16));

		JTextField fieldSalario = new JTextField(String.valueOf(t.getInt("salarioPorHora")));
		fieldSalario.setBounds(240, 330, 250, 25);

		JButton modificar = new JButton("MODIFICAR");
		modificar.setBounds(250, 380, 100, 40);
		
		botonOpTrab(modificar);
		
		modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Trabajador.eliminarTrabajador(t.getString("rut"));
				} catch (JSONException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Rut rut = new Rut(fieldRut.getText(), fieldRutVerif.getText());
				String nombre = fieldNombre.getText();
				String apellidoP = fieldApellidoP.getText();
				String apellidoM = fieldApellidoM.getText();
				String diaNac = (String) dia.getSelectedItem();
				String mesNac = (String) mes.getSelectedItem();
				String anioNac = (String) anio.getSelectedItem();
				FechaNacimiento fechaNac = new FechaNacimiento(diaNac, mesNac, anioNac);
				String contrato = (String) tipoContrato.getSelectedItem();
				int salario = Integer.parseInt(fieldSalario.getText());
				String depa = (String) departamento.getSelectedItem();
				new Trabajador(rut, nombre, apellidoP, apellidoM, fechaNac, contrato, salario, depa);
				Departamento.addTrabajador(depa);
				JOptionPane.showMessageDialog(null, "Usuario actualizado!");
				operaciones();
			}
			
		});

		//VALIDACI�N SALARIO
		fieldSalario.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				validacionDeNumeros(fieldSalario,ke);
			}
		});

		//VALIDACI�N RUT
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
		
		add(textTitulo);
		add(textNombre); add(fieldNombre);
		add(textApellidoM); add(fieldApellidoM);
		add(textApellidoP); add(fieldApellidoP);
		add(modificar);
		add(textContrato); add(tipoContrato);
		add(textRut); add(fieldRut); 
		add(fieldRutVerif); add(textGuion);
		add(textDepa); add(departamento);
		add(textNacimiento); add(dia); add(mes); add(anio);
		add(textSalario); add(fieldSalario);
		revalidate();
		repaint();
	}
	//FUNCI�N QUE PEGUNTA EL NOMBRE DEL TRABAJADOR PARA BUSCAR SUS DATOS		
	public void consultar() {
		removeAll();
		JLabel textTitulo = new JLabel("CONSULTAR DATOS TRABAJADORES");
		textTitulo.setBounds(40, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel nombres = new JLabel("Nombre: ");
		nombres.setBounds(40, 200, 200, 25);
		nombres.setFont(new Font("",Font.BOLD,22));
		
		JComboBox<String> trabajadores = new JComboBox<String>();
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
	//FUNCI�N QUE MUESTRA DATOS DE UN TRABAJADOR
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
	
	//FUNCI�N QUE MUESTA LOS DATOS DE LA LIQUIDACI�N
	public void MostrarLiquidacion(String rut) {
		
		removeAll();
		JLabel textTitulo = new JLabel("LIQUIDACION DE SUELDO");
		textTitulo.setBounds(125, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		Trabajador.llenarMatrizLiquidacion(rut);
		
		JTable tabla = new JTable(Trabajador.matrizLiquidacion,Trabajador.atributosLiquidacion);
		tabla.setBounds(110, 200, 500, 500);
		tabla.setEnabled(false);
		
		
		JScrollPane sp = new JScrollPane(tabla);
		sp.setBounds(35, 150, 550, 199);
		
		
		JButton volver = new JButton("VOLVER");
		volver.setBounds(240, 380, 120, 45);
		
		botonOpTrab(volver);
		
		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				operaciones();
				
			}
				
		});
		
		
		
		add(textTitulo);
		add(sp);
		add(volver);
		repaint();
		
	}
   //FUNCI�N PARA PERSONALIZAR LOS BOTONES
   public void botonOpTrab(JButton boton){
		
		boton.setBackground(new Color(82, 82, 78));
		boton.setFocusPainted(false);
		boton.setFont(new Font("",Font.BOLD,12));
		boton.setForeground(Color.white);
		
	}
   
   //VALIDACI�N PARA SOLO INGRESAR N�MEROS
   public void validacionDeNumeros(JTextField string,KeyEvent ke) {
	   
	   String value = string.getText();
		int l = value.length();
		if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			string.setEditable(true);
		} else {
			string.setEditable(false);
		}
	   
   }
   //VALIDACI�N PARA LIMITAR EL N�MERO DE CARACTERES INGRESADOS
   public void validadorRutVerificador(JTextField fild, int num, KeyEvent e) {
	   
	   if (fild.getText().length() >= num ) // limit to 1 characters
           e.consume();
	   
   }
   
   
}
