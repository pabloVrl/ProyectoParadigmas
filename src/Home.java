import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Home {
	
	private JPanel principal, nav;
	private JButton home, trabajadores, depa;
	private TrabajadoresUI trab;
	private DepartamentoUI depto = new DepartamentoUI();
	private Bienvenida bienvenida = new Bienvenida();
	private final Color fondo = new Color(82, 82, 78);
	private JPanel panelActual = bienvenida;
	 
	
	public Home(){
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
		
		home = new JButton("Home");
		home.setBounds(0, 50, 170, 50);
		
		trabajadores = new JButton("Trabajadores");
		trabajadores.setBounds(0, 100, 170, 50);
		
		depa = new JButton("Departamentos");
		depa.setBounds(0, 150, 170, 50);
		
		JButton botones[] = {home, trabajadores, depa};
		for(int i = 0; i < 3; i++) {
			botones[i].setBackground(fondo);
			botones[i].setBorder(new LineBorder(new Color(102, 102, 98), 6));
			botones[i].setFocusPainted(false);
			botones[i].setForeground(Color.WHITE);
			nav.add(botones[i]);
		}
		
		principal.add(nav);
		principal.add(bienvenida);
		
		//Accion de botones
		
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarBienv();
			}
			
		});
		
		depa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarDepto();
			}
			
		});
		
		trabajadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarTrabajadores();
			}
			
		});
		
	}
	
	private void mostrarBienv() {
		this.removerPanelActual();
		principal.add(bienvenida);
		principal.repaint();
		this.addPanelActual(bienvenida);
	}
	
	private void mostrarDepto() {
		this.removerPanelActual();
		depto.home();
		principal.add(depto);
		principal.repaint();
		this.addPanelActual(depto);
	}
	
	private void mostrarTrabajadores() {
		this.removerPanelActual();
		trab = new TrabajadoresUI();
		principal.add(trab);
		principal.repaint();
		this.addPanelActual(trab);
	}
	
	public JPanel getprincipalPanel(){
		return principal;
	}
	
	private void removerPanelActual() {
		principal.remove(panelActual);
	}
	
	private void addPanelActual(JPanel p) {
		this.panelActual = p;
	}

	
}
