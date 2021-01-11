import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Home {
	
	private JPanel principal, nav;
	private JButton home, trabajadores, depa;
	private TrabajadoresUI trab;
	private DepartamentoUI depto = new DepartamentoUI();
	private Bienvenida bienvenida = new Bienvenida();
	private final Color fondo = new Color(82, 82, 78);
	private JPanel panelActual = bienvenida;
	 
    
	//CONSTRUCTOR
	public Home(){
		
		ImageIcon img1 = new ImageIcon("./res/img/home.png");
		ImageIcon img2 = new ImageIcon("./res/img/departamentos.png");
		ImageIcon img3 = new ImageIcon("./res/img/trabajadores.png");
		
		// Panel Principal
		principal = new JPanel();
		principal.setLayout(null);
		principal.setSize(800, 500);
		
		// PANEL NAV
		nav = new JPanel();
		nav.setBounds(0, 0, 170, 500);
		nav.setBackground(fondo);
		nav.setLayout(null);
		nav.setVisible(true);
		
		
		
		home = new JButton("            Home             ",img1);
		home.setBounds(0, 50, 170, 50);
	 
		trabajadores = new JButton("    Trabajadores      ",img3);
		trabajadores.setBounds(0, 100, 170, 50);
		
		depa = new JButton("   Departamentos    ",img2);
		depa.setBounds(0, 150, 170, 50);
		
		JButton botones[] = {home, trabajadores, depa};
		for(int i = 0; i < 3; i++) {
			botones[i].setBackground(fondo);
			botones[i].setBorder(new LineBorder(new Color(102, 102, 98), 6));
			botones[i].setFocusPainted(false);
			botones[i].setForeground(Color.WHITE);
			hoverAction(botones[i]);
			nav.add(botones[i]);
		}
		
		
		
		principal.add(nav);
		principal.add(bienvenida);
		
		
		//ACCIÓN BOTONES
		
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mostrarBienv();
			}
			
		});
		
		depa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mostrarDepto();
			}
			
		});
		
		trabajadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mostrarTrabajadores();
			}
			
		});
		
	}
	//METODO PARA MOSTRAR EL INICIO
	private void mostrarBienv() {
		this.removerPanelActual();
		principal.add(bienvenida);
		principal.repaint();
		this.addPanelActual(bienvenida);
	}
	//METODO PARA MOSTRAR EL MENU DE DEPARTAMENTO
	private void mostrarDepto() {
		this.removerPanelActual();
		depto.home();
		principal.add(depto);
		principal.repaint();
		this.addPanelActual(depto);
	}
	//METODO PARA MOSTRAR EL MENU TRABAJADORES
	private void mostrarTrabajadores() {
		this.removerPanelActual();
		trab = new TrabajadoresUI();
		principal.add(trab);
		principal.repaint();
		this.addPanelActual(trab);
	}
	//FUNCIÓN QUE TE PERMITE CARGAR EL PANEL
	public JPanel getprincipalPanel(){
		return principal;
	}
	//METODO QUE REMOVE LOS ITEMS DENTRO DEL PANEL
	private void removerPanelActual() {
		principal.remove(panelActual);
	}
	//METODO QUE AGREGA EL PANEL QUE SE VA A OCUPAR EN EL PANEL ACTUAL
	private void addPanelActual(JPanel p) {
		this.panelActual = p;
	}

	//EFECTO HOVER BOTONES
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
	
}
