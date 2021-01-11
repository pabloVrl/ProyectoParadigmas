import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Departamento {

	private int ID;
	private String nombre;
	private int numeroTrabajadores;
	
	public static JSONArray departamentos = new JSONArray();
	
	//Constructor de la clase departamento
	public Departamento(String nombreDepa){
		
		if(departamentos.isEmpty()) {
			ID = 1;
			numeroTrabajadores = 0;
		}
		else {
			JSONObject depto = departamentos.getJSONObject(departamentos.length()-1);
			ID = depto.getInt("ID") + 1;
		}
		this.nombre = nombreDepa;
		this.numeroTrabajadores = 0;
		
		departamentos.put(this.toJson());
		
		actualizarJson();
	}
	//Función elimina trabajador del String
	public static void eliminarTrabajador(String name) {
		JSONObject obj;
		for(int i = 0; i < departamentos.length(); i++) {
			obj = departamentos.getJSONObject(i);
			if(obj.getString("nombre").equals(name)) {
				int trabajadores = obj.getInt("numeroTrabajadores") - 1;
				obj.remove("numeroTrabajadores");
				obj.put("numeroTrabajadores", trabajadores);
			}
		}
		actualizarJson();
	}
	//Función que añade al trabajador al String
	public static void addTrabajador(String name) {
		JSONObject obj;
		for(int i = 0; i < departamentos.length(); i++) {
			obj = departamentos.getJSONObject(i);
			if(obj.getString("nombre").equals(name)) {
				int trabajadores = obj.getInt("numeroTrabajadores") + 1;
				obj.remove("numeroTrabajadores");
				obj.put("numeroTrabajadores", trabajadores);
			}
		}
		actualizarJson();
	}
	//Función que retorna todos los nombres de los trabajadores
	public static ArrayList<String> getNombresDeptos() {
		ArrayList<String> nombres = new ArrayList<>();
		JSONObject depto;
		for(int i = 0; i < departamentos.length(); i++) {
			depto = departamentos.getJSONObject(i);
			nombres.add(depto.getString("nombre"));
		}
		
		return nombres;
	}
	//Función que elimina departamento del String
	public static void eliminarDepa(String name) throws IOException {
		JSONObject obj;
		Trabajador.eliminarTrabPorDepa(name);
		for(int i = 0; i < departamentos.length(); i++) {
			obj = departamentos.getJSONObject(i);
			if(obj.getString("nombre").equals(name)) {
				departamentos.remove(i);
			}
		}
		actualizarJson();
	}
	//Función permite cargar datos del archivo JSON
	public static void cargarDatos() throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("departamentos.json")));
		JSONObject obj = new JSONObject(content);
		JSONArray deptosCargados = obj.getJSONArray("departamentos");
		
		for(int i = 0; i < deptosCargados.length(); i++) {
			obj = deptosCargados.getJSONObject(i);
			departamentos.put(obj);
		}
	}
	//Metodo que crea el objecto con la etiqueta departamentos para el JSON
	private static void actualizarJson() {
		FileWriter file;
		JSONObject obj = new JSONObject();
		obj.put("departamentos", departamentos);
		
		try {
			file = new FileWriter("departamentos.json");
			file.write(obj.toString(3));
			file.flush();
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	//Metodo que retorna toda la informacion de un departamento
	private JSONObject toJson() {
		JSONObject depto = new JSONObject();
		depto.put("ID", ID);
		depto.put("nombre", nombre);
		depto.put("numeroTrabajadores", numeroTrabajadores);
		return depto;
	}
	//Función que retorna el numero total de trabajadores de un departamento
	public static String getNroTotalTrabajadores() {
		JSONObject obj;
		int nroTotal = 0;
		 for(int i = 0; i < departamentos.length(); i++) {
			 obj = departamentos.getJSONObject(i);
			 nroTotal += obj.getInt("numeroTrabajadores");
		 }
		 
		return String.valueOf(nroTotal);
	}
	
	 //Función que retorna el numero total de trabajadores en la empresa
	 public static String getNumeroTrabajadores(String nombre) {
		 JSONObject obj;
		 
		 for(int i = 0; i < departamentos.length(); i++) {
			 obj = departamentos.getJSONObject(i);
			 if(obj.getString("nombre").equals(nombre)) {
				 
				 return String.valueOf(obj.getInt("numeroTrabajadores"));
			 }
		 }
		 
		return null;
	}

	

	  
}




  
  
  
  
  
  