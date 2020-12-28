import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.*;

public class Trabajador {
	private Rut rut;
	private String nombre, apellidoP, apellidoM;
	private FechaNacimiento fechaNac;
	private String tipoContrato;
	private float salarioxHora;
	private String departamento;

	public static String[] contratos = {"Part-time", "Full-time"};
	public static JSONArray trabajadores = new JSONArray();
	public static String[] atributos = {"Rut", "Nombre", "Nacimiento", "Contrato", "Salario", "Departamento"};
	public static String[][] matriz = new String[100][6];  

	public Trabajador(Rut Rut, String nombre, String apellidoP, String apellidoM, FechaNacimiento fechaNac, String tipoContrato, float salario, String departamento) {
		this.rut = Rut;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.fechaNac = fechaNac;
		this.tipoContrato = tipoContrato;
		this.salarioxHora = salario;
		this.departamento = departamento;
		
		trabajadores.put(this.toJson());
		
		actualizarJson();
	}
	
	public static void eliminarTrabajador(String rut) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("trabajadores.json")));
		JSONObject obj = new JSONObject(content);
		JSONArray trabajCargados = obj.getJSONArray("trabajadores");
		
		for(int i = 0; i < trabajCargados.length(); i++) {
			obj = trabajCargados.getJSONObject(i);
			if(obj.getString("rut").equals(rut)) {
				trabajadores.remove(i);
			}
		}
		actualizarJson();
		llenarMatriz();
	}
	
	public static void llenarMatriz() {
		JSONObject obj = new JSONObject();
		matriz = new String[100][6];
		for(int i = 0; i < trabajadores.length(); i++) {
			obj = trabajadores.getJSONObject(i);
			matriz[i][0] = obj.getString("rut");
			matriz[i][1] = obj.getString("nombre") + " "+ obj.getString("apellidoPaterno");
			matriz[i][2] = obj.getJSONObject("fechaNacimiento").getString("dia") + "/" + obj.getJSONObject("fechaNacimiento").getString("mes")+ "/" + obj.getJSONObject("fechaNacimiento").getString("año");
			matriz[i][3] = obj.getString("tipoContrato");
			matriz[i][4] = String.valueOf(obj.getInt("salarioPorHora"));
			matriz[i][5] = obj.getString("departamento");
		}
	}
	
	private JSONObject toJson() {
		JSONObject trabajador = new JSONObject();
		JSONObject fecha = new JSONObject();
		//
		fecha.put("dia", fechaNac.getDia());
		fecha.put("mes", fechaNac.getMes());
		fecha.put("año", fechaNac.getAnio());
		//
		trabajador.put("rut", rut.getString());
		trabajador.put("nombre", nombre);
		trabajador.put("apellidoPaterno", apellidoP);
		trabajador.put("apellidoMaterno", apellidoM);
		trabajador.put("apellidoPaterno", apellidoP);
		trabajador.put("fechaNacimiento", fecha);
		trabajador.put("tipoContrato", tipoContrato);
		trabajador.put("salarioPorHora", salarioxHora);
		trabajador.put("departamento", departamento);
		
		return trabajador;
	}
	
	public static void cargarDatos() throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("trabajadores.json")));
		JSONObject obj = new JSONObject(content);
		JSONArray trabajCargados = obj.getJSONArray("trabajadores");
		
		for(int i = 0; i < trabajCargados.length(); i++) {
			obj = trabajCargados.getJSONObject(i);
			trabajadores.put(obj);
		}
	}
	
	private static void actualizarJson() {
		FileWriter file;
		JSONObject obj = new JSONObject();
		obj.put("trabajadores", trabajadores);
		
		try {
			file = new FileWriter("trabajadores.json");
			file.write(obj.toString(3));
			file.flush();
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	
}
