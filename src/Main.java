import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.*;
// PROYECTO CREADO POR:
// PABLO VILLARROEL ANTILLANCA 20.487.087-K
// ELVIS RODRIGUEZ DURAN 20.255.414-8
//
// INGENIERIA DE EJECUCIÓN EN COMPUTACIÓN E INFORMÁTICA
public class Main { 

	public static void main(String[] args) throws IOException {
		try {
			Departamento.cargarDatos();
			Trabajador.cargarDatos();
		}catch (Exception e) {
			
		}
		// Funcion que permite que hayan valores en la seleccion de nacimiento
		FechaNacimiento.llenarArrays();
		
		JFrame v = new JFrame();
		v.setLayout(null);
		v.setSize(800, 500);
		v.setTitle("La Choza de Concreto");
		Image icon = Toolkit.getDefaultToolkit().getImage("./res/img/choza.png");    
		v.setIconImage(icon);    
		v.setResizable(false);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Home h = new Home();
//		//TrabajadoresUI t = new TrabajadoresUI();
//		DepartamentoUI d = new DepartamentoUI();
//		v.add(d);
//		//v.add(t);
		v.add(h.getprincipalPanel());
		
		v.setVisible(true);
	}
}
