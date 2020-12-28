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
	
	public Departamento(String nombreDepa){
		
		if(departamentos.isEmpty()) {
			ID = 1;
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
	
	public static ArrayList<String> getNombresDeptos() {
		ArrayList<String> nombres = new ArrayList<>();
		JSONObject depto;
		for(int i = 0; i < departamentos.length(); i++) {
			depto = departamentos.getJSONObject(i);
			nombres.add(depto.getString("nombre"));
		}
		
		return nombres;
	}
	
	public static void eliminarDepa(String name) {
		JSONObject obj;
		for(int i = 0; i < departamentos.length(); i++) {
			obj = departamentos.getJSONObject(i);
			if(obj.getString("nombre").equals(name)) {
				departamentos.remove(i);
			}
		}
		actualizarJson();
	}
	
	public static void cargarDatos() throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("departamentos.json")));
		JSONObject obj = new JSONObject(content);
		JSONArray deptosCargados = obj.getJSONArray("departamentos");
		
		for(int i = 0; i < deptosCargados.length(); i++) {
			obj = deptosCargados.getJSONObject(i);
			departamentos.put(obj);
		}
	}
	
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
	
	private JSONObject toJson() {
		JSONObject depto = new JSONObject();
		depto.put("ID", ID);
		depto.put("nombre", nombre);
		depto.put("numeroTrabajadores", numeroTrabajadores);
		return depto;
	}
	
	public static String getNroTotalTrabajadores() {
		JSONObject obj;
		int nroTotal = 0;
		 for(int i = 0; i < departamentos.length(); i++) {
			 obj = departamentos.getJSONObject(i);
			 nroTotal += obj.getInt("numeroTrabajadores");
		 }
		 
		return String.valueOf(nroTotal);
	}
	
	 
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

    public String getNombreDepa() {
		return nombre;
	}
	
	public void setNumeroTrabajadores(int numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}
	
	public void setNombreDepa(String nombreDepa) {
		this.nombre = nombreDepa;
	}

	  
}

  
  
  
  
  
  