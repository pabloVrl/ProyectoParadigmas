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
	public static String[] atributosLiquidacion = {"Haberes","        ","Descuentos","        "};
	public static String[][] matriz = new String[trabajadores.length()][6];  
	public static String[][] matrizLiquidacion = new String[11][4];

	//CONSTRUCTOR
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
	//FUNCI�N MODIFICAR TRABAJADOR
	public static void modificarTrab(JSONObject trabajador) {
		for(int i = 0; i < trabajadores.length(); i++) {
			JSONObject t = trabajadores.getJSONObject(i);
			if(trabajador == t) {
				trabajadores.remove(i);
			}
		}
	}
	//FUNCI�N RETORNA TODOS LOS RUT DEL JSON
	public static JSONObject getObjRut(String rut) {
		JSONObject t = new JSONObject();
		for(int i = 0; i < trabajadores.length(); i++) {
			t = trabajadores.getJSONObject(i);
			if(rut.equals(t.getString("rut"))) {
				return t;
			}
		}
		
		return null;
	}
	//FUNCI�N ELIMINA TRABAJADOR POR DEPARTAMENTO
	public static void eliminarTrabPorDepa(String nombre) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("trabajadores.json")));
		JSONObject obj = new JSONObject(content);
		JSONArray trabajCargados = obj.getJSONArray("trabajadores");
		
		for(int i = 0; i < trabajCargados.length(); i++) {
			obj = trabajCargados.getJSONObject(i);
			if(obj.getString("departamento").equals(nombre)) {
				eliminarTrabajador(obj.getString("rut"));
			}
		}
	}
	//FUNCI�N ELIMINA TRABAJADOR DEL JSON
	public static void eliminarTrabajador(String rut) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("trabajadores.json")));
		JSONObject obj = new JSONObject(content);
		JSONArray trabajCargados = obj.getJSONArray("trabajadores");
		
		for(int i = 0; i < trabajCargados.length(); i++) {
			obj = trabajCargados.getJSONObject(i);
			if(obj.getString("rut").equals(rut)) {
				Departamento.eliminarTrabajador(obj.getString("departamento"));
				trabajadores.remove(i);
			}
		}
		actualizarJson();
		llenarMatriz();
	}
	//FUNCI�N RETORNA TODOS LOS RUT EN UN STRING
	public static String[] getRuts() {
		String[] ruts = new String[trabajadores.length()];
		JSONObject t = new JSONObject();
		for(int i = 0; i < trabajadores.length(); i++) {
			t = trabajadores.getJSONObject(i);
			ruts[i] = t.getString("rut");
		}
		
		return ruts;
	}
	//FUNCI�N LLENA MATRIZ CON LOS DATOS DEL TRABAJADOR
	public static void llenarMatriz() {
		JSONObject obj = new JSONObject();
		matriz = new String[trabajadores.length()][6];
		for(int i = 0; i < trabajadores.length(); i++) {
			obj = trabajadores.getJSONObject(i);
			matriz[i][0] = obj.getString("rut");
			matriz[i][1] = obj.getString("nombre") + " "+ obj.getString("apellidoPaterno");
			matriz[i][2] = obj.getJSONObject("fechaNacimiento").getString("dia") + "/" + obj.getJSONObject("fechaNacimiento").getString("mes")+ "/" + obj.getJSONObject("fechaNacimiento").getString("a�o");
			matriz[i][3] = obj.getString("tipoContrato");
			matriz[i][4] = String.valueOf(obj.getInt("salarioPorHora"));
			matriz[i][5] = obj.getString("departamento");
		}
	}
	
	//FUNCI�N ENCARGADA DE LLENAR LA MATRIZ DE LIQUIDACI�N
	public static void llenarMatrizLiquidacion(String rut) {
		
		matrizLiquidacion = new String [11][4];
		JSONObject trabajador = new JSONObject();
		String horario;
		int sueldo;
		
		for(int i=0;i<trabajadores.length();i++) {
			trabajador = trabajadores.getJSONObject(i);
			
			 if( trabajador.getString("rut").equals(rut)) {
				horario = trabajador.getString("tipoContrato");
				sueldo = trabajador.getInt("salarioPorHora");
				
				if(horario.equals("Part-time")) {
					
					subMatrizLiquidacion(sueldo*120,0,30000);
					
				}
					
				if(horario.equals("Full-time")) {
					
					subMatrizLiquidacion(sueldo*180,4000*20,30000);
					
				}
			
				
			}
			
		}
		
		

		
	}
	//FUNCION PARA LLENAR LA MATRIZ SEGUN PART-TIME O FULL-TIME
	public static void subMatrizLiquidacion(int sueldo,int colacion,int movilizacion) {
		
		int aux;
		matrizLiquidacion[0][0] = "Sueldo Base"; 
		matrizLiquidacion[0][1] = "               "+sueldo;
		matrizLiquidacion[1][0] = "Asignaci�n Movilizaci�n";
		matrizLiquidacion[1][1] = "                "+movilizacion;	
		matrizLiquidacion[2][0] = "Asignaci�n Colaci�n";
		matrizLiquidacion[2][1] = "                "+colacion;
		matrizLiquidacion[7][0] = "Total Haberes";
		matrizLiquidacion[7][1] = "               "+(sueldo+colacion+movilizacion);
		
		matrizLiquidacion[0][2] = "Sistema de prevension";
		aux=(int) (sueldo*0.07);
		matrizLiquidacion[0][3] = "               "+aux;
		matrizLiquidacion[1][2] = "AFP";
		aux=(int) (sueldo*0.1);
	    matrizLiquidacion[1][3] = "               "+aux;
	    matrizLiquidacion[7][2] = "Total Descuentos";
	    aux=(int) ((sueldo*0.07)+(sueldo*0.1));
	    matrizLiquidacion[7][3] = "              - "+aux;
	    
	    matrizLiquidacion[10][2] = "Alcance Liquido";
	    matrizLiquidacion[10][3] = "               "+((sueldo+colacion+movilizacion)-(aux));
		
		
	}
	//FUNCI�N 
	public static ArrayList<String> getNombresTrabajadores() {
		
		ArrayList<String> nombres = new ArrayList<>();
		JSONObject trabajador;
		
		for(int i = 0; i < trabajadores.length();i++) {
			
			trabajador = trabajadores.getJSONObject(i);
			nombres.add(trabajador.getString("nombre"));
		}
		
		return nombres;
		
	}
	//METODO QUE PASA LOS DATOS DE UN TRABAJADOR A UN OBJETO 
	private JSONObject toJson() {
		JSONObject trabajador = new JSONObject();
		JSONObject fecha = new JSONObject();
		//
		fecha.put("dia", fechaNac.getDia());
		fecha.put("mes", fechaNac.getMes());
		fecha.put("a�o", fechaNac.getAnio());
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
	//FUNCI�N CARGA LOS DATOS DEL ARCHIVO TRABAJADORES.JSON
	public static void cargarDatos() throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("trabajadores.json")));
		JSONObject obj = new JSONObject(content);
		JSONArray trabajCargados = obj.getJSONArray("trabajadores");
		
		for(int i = 0; i < trabajCargados.length(); i++) {
			obj = trabajCargados.getJSONObject(i);
			trabajadores.put(obj);
		}
	}
	//METODO PARA ACTUALIZAR EL ARCHIVO JSON PARA GUARDAR CAMBIOS
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
