
public class Rut {
	private String digitos;
	private String verificador;
	
	public Rut(String digitos, String verificador) {
		this.digitos = digitos;
		this.verificador = verificador;
	}

	public String getString() {
		return digitos + "-" + verificador;
	}

	public String getDigitos() {
		return digitos;
	}

	public void setDigitos(String digitos) {
		this.digitos = digitos;
	}

	public String getVerificador() {
		return verificador;
	}

	public void setVerificador(String verificador) {
		this.verificador = verificador;
	}

	
}