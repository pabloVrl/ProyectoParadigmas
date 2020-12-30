import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaDatos {
	private JScrollPane sp;
	private JTable tabla;
	
	public TablaDatos(int x, int y, int h, int w) {
		Trabajador.llenarMatriz();
		tabla = new JTable(Trabajador.matriz, Trabajador.atributos);
		tabla.setEnabled(false);
		
		sp = new JScrollPane(tabla);
		sp.setBounds(x, y, h, w);
		
	}
	
	public JScrollPane getSP() {
		return sp;
	}
}
