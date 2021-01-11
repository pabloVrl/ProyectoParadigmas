import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DepartamentoUI extends JPanel{

	JLabel bienvenido;
	JButton eliminar;
	JButton ingresar;
	JButton cantTrabajadores;
	JButton nrotrabajadores_depa;
	URL sonido, sonido2;
	
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
			
			botonOpDepa(botones[i],16);
			hoverAction(botones[i]);
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
				
				
				cantTrabajadores();
			}
			
		});
		
		nrotrabajadores_depa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				nrotrabajadores_depa();
			}
			
		});
		//-------------------------------------------------------------------//
	}
	
	//PANEL INGRESAR DEPARTAMENTO
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
		
		JButton agregar = new JButton("AGREGAR");
		agregar.setBounds(240, 320, 100, 40);
		
		botonOpDepa(agregar,13);
		hoverAction(agregar);
		
		//ACCIÓN BOTONES
		agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dep = fieldNombre.getText().trim();
				if(!validacion(dep)||dep.equals("")||dep.equals(null)) {
					sonidoerror();
					JOptionPane.showMessageDialog(null, "Introduzca un nombre que solo contenga letras");
				}else{
				Departamento p = new Departamento(fieldNombre.getText());
				sonidoVerificador();
				JOptionPane.showMessageDialog(null, "Departamento creado con éxito");
				home();
				}
			}
			//VALIDACIÓN NOMBRE DEPARTAMENTO
			private boolean validacion(String nom) {
				
				return nom.matches("[A-Z]*[a-z]*");
				
			}
		});
		
		add(textNombre);
		add(textTitulo);
		add(agregar);
		add(fieldNombre);
		repaint();
	}
	//PANEL ELIMINAR DEPARTAMENTO
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
		
		botonOpDepa(delete,13);
		hoverAction(delete);
		
		//ACCIÓN DE LOS BOTONES
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				    int aux=0;
					remove(depa);
					try {
				    Departamento.eliminarDepa((String) depa.getSelectedItem());
					if(depa.getSelectedItem()==null) {
						aux=1;
					}
			
				    
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
					JComboBox depa = new JComboBox(Departamento.getNombresDeptos().toArray());
        			depa.setBounds(240, 200, 200, 25);
        			add(depa);
        			repaint();
        			revalidate();
        			
        			if(aux==1) {
        				sonidoerror();
        				JOptionPane.showMessageDialog(null, "No se encontró ningún departamento, por favor cree uno");
        				
        			}else {
        				sonidoVerificador();
        				JOptionPane.showMessageDialog(null, "Departamento eliminado");
        				eliminar();	
        			}
    				
        					
				
			}
			
		});

		add(textNombre);
		add(textTitulo);
		add(depa);
		add(delete);
		repaint();
		validate();
	}
	//PANEL CANTIDAD TOTAL DE TRABAJADORES
	private void cantTrabajadores() {
		removeAll();
		JLabel textTitulo = new JLabel("CANTIDAD TOTAL DE TRABAJADORES");
		textTitulo.setBounds(40, 45, 600, 50);
		textTitulo.setFont(new Font("",Font.BOLD,29));
		
		JLabel textTitulo2 = new JLabel("DE LA EMPRESA");
		textTitulo2.setBounds(190, 80, 600, 50);
		textTitulo2.setFont(new Font("",Font.BOLD,29));
		
		JLabel NroTotalTrabajadores = new JLabel("La cantidad es de:   " + Departamento.getNroTotalTrabajadores()+"  trabajadores.");
		NroTotalTrabajadores.setBounds(60, 240, 600, 40);
		NroTotalTrabajadores.setFont(new Font("",Font.BOLD,29));
		
		
		add(textTitulo);
		add(textTitulo2);
		add(NroTotalTrabajadores);
		repaint();
	}
	//PANEL NÚMERO DE TRABAJADORES
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
		nroTrab.setBounds(460, 250, 200, 25);
		nroTrab.setFont(new Font("",Font.BOLD,20));
		
		//ACCIÓN BOTON
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
	public void botonOpDepa(JButton boton,int n){
		
		boton.setBackground(new Color(82, 82, 78));
		boton.setFocusPainted(false);
		boton.setFont(new Font("",Font.BOLD,n));
		boton.setForeground(Color.white);
		
	}
	//EFECTO HOVER BOTON
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
