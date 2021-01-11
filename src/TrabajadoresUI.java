import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
	URL sonido,sonido2;
	
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
	    ingresar.setBounds(60, 200, 500, 50);
	    hoverAction(ingresar);
		
		JButton eliminar = new JButton("OPERACIONES CON TRABAJADORES");
		eliminar.setBounds(60, 260, 500, 50);
		
		hoverAction(eliminar);
	
		JButton botones[] = {ingresar, eliminar};
		
		for(int i=0;i<2;i++) {
			
			botones[i].setBackground(new Color(82, 82, 78));
			botones[i].setFocusPainted(false);
			botones[i].setFont(new Font("",Font.BOLD,16));
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
	//FUNCIÓN QUE AGREGA UN TRABAJADOR AL SISTEMA
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
			agregar.setFont(new Font("",Font.BOLD,16));

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
			hoverAction(agregar);

			// ACCIÓN BOTONES
			agregar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String nom = fieldNombre.getText().trim();

					if (!validacionLetras(nom) || nom.equals("")) {
						sonidoerror();
						JOptionPane.showMessageDialog(null, "Introduzca un nombre valido");
					} else {
						nom = fieldApellidoP.getText().trim();

						if (!validacionLetras(nom) || nom.equals("")) {
							sonidoerror();
							JOptionPane.showMessageDialog(null, "Introduzca un apellido paterno que sea valido");
						} else {
							nom = fieldApellidoM.getText().trim();

							if (!validacionLetras(nom) || nom.equals("")) {
								sonidoerror();
								JOptionPane.showMessageDialog(null, "Introduzca un apellido materno que sea valido");
							} else {
								Rut rut = new Rut(fieldRut.getText(), fieldRutVerif.getText());
								String[] ruts = Trabajador.getRuts();
								for (int i = 0; i < Trabajador.trabajadores.length(); i++) {
									if (rut.getString().equals(ruts[i])) {
										JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese RUT");
									} else {
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
										new Trabajador(rut, nombre, apellidoP, apellidoM, fechaNac, contrato, salario,
												depa);
										Departamento.addTrabajador(depa);
										sonidoVerificador();
										JOptionPane.showMessageDialog(null, "Usuario creado!");
										ingresar();
									}
								}

							}
						}
					}

				}

				//VALIDACIÓN
				private boolean validacionLetras(String nom) {
					
					return nom.matches("[A-Z]*[a-z]*");
					
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
			sonidoerror();
			JOptionPane.showMessageDialog(null, "No se puede crear trabajador si no hay departamentos");
			home();
		}
	}
	//FUNCIÓN QUE ELIMINA UN TRABAJADOR DEL SISTEMA
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
		hoverAction(delete);
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBounds(190, 395, 100, 40);
		botonOpTrab(modificar);
		hoverAction(modificar);
		
		JButton consultar = new JButton("DATOS");
		consultar.setBounds(310, 395, 100, 40);
		botonOpTrab(consultar);
		hoverAction(consultar);
		
		JButton liquidacion = new JButton("LIQUIDACIÓN");
		liquidacion.setBounds(430, 395, 110, 40);
		botonOpTrab(liquidacion);
		hoverAction(liquidacion);
		
		Trabajador.llenarMatriz();
		
		TablaDatos datos = new TablaDatos(35, 150, 550, 225);
		//ACCIÓN BOTON
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
					sonidoerror();
					JOptionPane.showMessageDialog(null, "RUT INVÁLIDO");
				}
			}
			
		});
		//ACCIÓN BOTON
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
					sonidoerror();
					JOptionPane.showMessageDialog(null, "RUT INVÁLIDO");
				}
			}
			
		});
		//ACCIÓN BOTON
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
						
							e1.printStackTrace();
						}
					}
				}

				if(!entro) {
					sonidoerror();
					JOptionPane.showMessageDialog(null, "RUT INVÁLIDO");
				}
				
				operaciones();
				
			}
			
		});
		//ACCIÓN BOTON
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
					sonidoerror();
					JOptionPane.showMessageDialog(null, "RUT INVÁLIDO");
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
	//MOSTRAR DATOS DEL TRABAJADOR
	private void mostrarDatos(String rut) {
		removeAll();

		JSONObject t = Trabajador.getObjRut(rut);
		JSONObject nac = t.getJSONObject("fechaNacimiento");
		
		JLabel nombre, r, contr, depto, naci, sal,titulo;
		
		  titulo = new JLabel("DATOS");
		  titulo.setBounds(260, 40, 200, 40);
		  titulo.setFont(new Font("",Font.BOLD,29));
		
		  nombre = new JLabel("Nombre:                        "+ t.getString("nombre")+ " " + t.getString("apellidoPaterno") + " " + t.getString("apellidoMaterno"));
		  nombre.setBounds(150, 100, 500, 25);
		  nombre.setFont(new Font("",Font.BOLD,20));
		
		  r = new JLabel("RUT:                            "+rut);
		  r.setBounds(160, 140, 500, 25);
		  r.setFont(new Font("",Font.BOLD,20));
		
		  contr = new JLabel("Tipo de contrato:                   "+ t.getString("tipoContrato"));
		  contr.setBounds(100, 180, 500, 25);
		  contr.setFont(new Font("",Font.BOLD,20));
		
		  depto = new JLabel("Departamento:                     "+t.getString("departamento"));
		  depto.setBounds(110, 220, 500, 25);
		  depto.setFont(new Font("",Font.BOLD,20));
		  
		  Calendar calendar = Calendar.getInstance();
		  int edad;

          int diaActual = calendar.get(Calendar.DATE);
          int mesActual = calendar.get(Calendar.MONTH) + 1;
          int anioActual = calendar.get(Calendar.YEAR);

          int diaNac = Integer.parseInt(nac.getString("dia"));
          int mesNac = Integer.parseInt(nac.getString("mes"));
          int anioNac = Integer.parseInt(nac.getString("año"));

          if(mesNac > mesActual) {
              edad = anioActual - anioNac - 1;
          }
          else if(mesNac == mesActual && diaActual < diaNac) {
              edad = anioActual - anioNac - 1;
          }
          else {
              edad = anioActual - anioNac;
          }


          naci = new JLabel("            Edad:                         " + String.valueOf(edad));
          naci.setBounds(100, 260, 500, 25);
          naci.setFont(new Font("",Font.BOLD,20));
		  
		  sal = new JLabel("Salario por hora:                  "+ String.valueOf(t.getInt("salarioPorHora")));
		  sal.setBounds(110, 300, 500, 25);
		  sal.setFont(new Font("",Font.BOLD,20));
		  
		  
		  JButton volver = new JButton("VOLVER");
		  volver.setBounds(200, 360, 200, 50);
		  
		  botonOpTrab(volver);
		  hoverAction(volver);
		//ACCIÓN BOTON
		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				operaciones();
			}
			
		});
		
		add(volver);
		add(sal);
		add(naci);
		add(titulo);
		add(depto);
		add(contr);
		add(r);
		add(nombre);
		
		repaint();
	}
	//FUNCIÓN QUE MODIFICA INFORMACIÓN DE UN TRABAJADOR
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
		anio.setSelectedIndex(2020 - Integer.parseInt(nac.getString("año")));

		JLabel textSalario = new JLabel("Salario por hora:");
		textSalario.setBounds(60, 330, 200, 25);
		textSalario.setFont(new Font("",Font.BOLD,16));

		JTextField fieldSalario = new JTextField(String.valueOf(t.getInt("salarioPorHora")));
		fieldSalario.setBounds(240, 330, 250, 25);

		JButton modificar = new JButton("MODIFICAR");
		modificar.setBounds(250, 380, 100, 40);
		
		botonOpTrab(modificar);
		
		hoverAction(modificar);
		//ACCIÓN BOTONES
		modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Trabajador.eliminarTrabajador(t.getString("rut"));
				} catch (JSONException | IOException e1) {
					
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
				sonidoVerificador();
				JOptionPane.showMessageDialog(null, "Usuario actualizado!");
				operaciones();
			}
			
		});
		
		
		
		

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
	
	//FUNCIÓN QUE MUESTA LOS DATOS DE LA LIQUIDACIÓN
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
		
		hoverAction(volver);
		//ACCIÓN BOTON
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
   //FUNCIÓN PARA PERSONALIZAR LOS BOTONES
   public void botonOpTrab(JButton boton){
		
		boton.setBackground(new Color(82, 82, 78));
		boton.setFocusPainted(false);
		boton.setFont(new Font("",Font.BOLD,12));
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
   
   
   //EFECTO HOVER
   public void hoverAction(JButton boton) {
	
	   boton.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            boton.setBackground(new Color(120, 120, 114));
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            boton.setBackground(new Color(82, 82, 78));
	        }
	    });
		
   }
   //EFECTO SONIDO ERROR
   public void sonidoerror()
   {
	
	 sonido = getClass().getResource("erro.wav");
	 try {
       
		 AudioInputStream sound2 = AudioSystem.getAudioInputStream(sonido);
		 Clip clip2 = AudioSystem.getClip();
	     clip2.open(sound2);
	     clip2.start();
	       
    } catch (Exception e) {
        System.out.println(e);
    }
     
   }
   //EFECTO SONIDO NOTIFICACIÓN
   public void sonidoVerificador() {
		 
		 sonido2 = getClass().getResource("notif.wav");
		 try {
	       
			 AudioInputStream sound2 = AudioSystem.getAudioInputStream(sonido2);
			 Clip clip2 = AudioSystem.getClip();
		     clip2.open(sound2);
		     clip2.start();
		       
	    } catch (Exception e) {
	        System.out.println(e);
	    }
		 
		 
	 }
   
}
