
public class Rut {
	private int digitos;
	private char verificador;
	
	public Rut(int digitos, char verificador) {
		this.digitos = digitos;
		this.verificador = verificador;
	}

	public int getDigitos() {
		return digitos;
	}

	public void setDigitos(int digitos) {
		this.digitos = digitos;
	}

	public char getVerificador() {
		return verificador;
	}

	public void setVerificador(char verificador) {
		this.verificador = verificador;
	}
}