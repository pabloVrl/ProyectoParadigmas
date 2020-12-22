
public class Trabajador {
	private Rut Rut;
	private String nombre, apellidoP, apellidoM;
	private FechaNacimiento fechaNac;
	private String tipoContrato;
	private float salarioxHora;

	public static String[] contratos = {"Part-time", "Full-time"};

	public Trabajador(Rut Rut, String nombre, String apellidoP, String apellidoM, FechaNacimiento fechaNac, String tipoContrato, float salario) {
		this.Rut = Rut;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.fechaNac = fechaNac;
		this.tipoContrato = tipoContrato;
		this.salarioxHora = salario;
	}

	public Rut getRUT() {
		return Rut;
	}

	public void setRUT(Rut Rut) {
		this.Rut = Rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public FechaNacimiento getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(FechaNacimiento fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public float getSalarioxHora() {
		return salarioxHora;
	}

	public void setSalarioxHora(float salarioxHora) {
		this.salarioxHora = salarioxHora;
	}
	
	
}
