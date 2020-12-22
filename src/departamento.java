import java.util.ArrayList;

public class Departamento {

	private int numeroDepa;
	private String nombreDepa;
	private int numeroTrabajadores;
	private ArrayList<Trabajador> trabajadores;
	
	 public Departamento(int numeroDepa,String nombreDepa,int numeroTrabajadores,Trabajador infoTrabajador){
		  
		  this.numeroDepa=numeroDepa;
		  this.nombreDepa = nombreDepa;
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

  
  
  
  
  
  