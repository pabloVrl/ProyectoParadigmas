import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Departamento {

	private int numeroDepa;
	private String nombreDepa;
	private int numeroTrabajadores;
	private ArrayList<Trabajador> trabajadores;
	
	public static ArrayList<String> departamentos;
	
	public Departamento(int numeroDepa,String nombreDepa,int numeroTrabajadores){

		this.numeroDepa = numeroDepa;
		this.nombreDepa = nombreDepa;
		this.numeroTrabajadores = numeroTrabajadores;
	}
	
	public static ArrayList<String> deptosActuales() throws IOException {
		departamentos = new ArrayList<String>();
		String content = new String(Files.readAllBytes(Paths.get("departamentos.json")));
		JSONArray depLeidos = new JSONArray(content);
		
		for(int i = 0; i < depLeidos.length(); i++) {
			JSONObject depto = depLeidos.getJSONObject(i);
			departamentos.add(depto.getString("nombre"));
		}
		
		System.out.println(departamentos.toString());
		
		return departamentos;
		
		
	}
	
	public void addJson() {
		FileWriter file;
		try {
			file = new FileWriter("departamentos.json", true);
			file.append(convertirAJson().toString(1));
			file.append("\n");
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	 
	private JSONObject convertirAJson() {
		JSONObject depa = new JSONObject();
		depa.put("nombre", this.nombreDepa);
		depa.put("numero", this.numeroDepa);
		depa.put("numeroTrabajadores", this.numeroTrabajadores);

		return depa;
	}
	 
	 
	 public void ingresarTrabajador(Trabajador t) {
		 trabajadores.add(t);
	 }
	 
	 public int getNumeroTrabajadores() {
		return numeroTrabajadores;
	}

    public String getNombreDepa() {
		return nombreDepa;
	}

    public int getNumeroDepa() {
		return numeroDepa;
	}
	
	public void setNumeroTrabajadores(int numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}

	public void setNumeroDepa(int numeroDepa) {
		this.numeroDepa = numeroDepa;
	}

	public void setNombreDepa(String nombreDepa) {
		this.nombreDepa = nombreDepa;
	}

	  
}

  
  
  
  
  
  