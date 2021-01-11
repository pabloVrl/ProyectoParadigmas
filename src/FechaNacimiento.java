import java.util.ArrayList;

public class FechaNacimiento {
	private String dia, mes, anio;
	
	public static ArrayList<String> arrDia = new ArrayList<>();
	public static ArrayList<String> arrMes = new ArrayList<>();
	public static ArrayList<String> arrAnio = new ArrayList<>();
	
	public FechaNacimiento(String dia, String mes, String anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	//FUNCIÓN QUE LLENA LOS DIAS, MESES Y AÑOS
	public static void llenarArrays() {
		for(int i = 1; i <= 31; i++) {
			arrDia.add(String.valueOf(i));
		};
		
		for(int i = 1; i <= 12; i++) {
			arrMes.add(String.valueOf(i));
		};
		
		for(int i = 2020; i > 1900; i--) {
			arrAnio.add(String.valueOf(i));
		};
	}

	//FUNCIÓN QUE RETORNA EL STRING DIA
	public String getDia() {
		return dia;
	}
 
	//FUNCIÓN QUE ACTUALIZA EL DIA EN LA CLASE
	public void setDia(String dia) {
		this.dia = dia;
	}
    //FUNCIÓN QUE RETORNA EL STRING MES
	public String getMes() {
		return mes;
	}

	//FUNCIÓN QUE ACTUALIZA EL MES EN LA CLASE
	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
}
