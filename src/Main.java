import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame v = new JFrame();
		v.setSize(800, 500);
		v.setTitle("La Choza de Concreto");
		v.setResizable(false);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		
		Nav nav = new Nav();
		
		
		v.add(nav);
		v.add(p);
		
		
		v.setVisible(true);
		
		
	}
}
