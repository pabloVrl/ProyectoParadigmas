
public class departamento {

	private int numeroDepa;
	private String nombreDepa;
	private int numeroTrabajadores;
	public Trabajador infoTrabajador;
	
	 public departamento(int numeroDepa,String nombreDepa,int numeroTrabajadores,Trabajador infoTrabajador){
		  
		  this.numeroDepa=numeroDepa;
		  this.nombreDepa = nombreDepa;
		  this.numeroTrabajadores = numeroTrabajadores;
		  this.infoTrabajador = infoTrabajador;
		  
	  }
	
	 public ingresarDepa(int numeroDepa,String nombreDepa,int numeroTrabajadores,Trabajador infoTrabajador){
		  
		  this.numeroDepa=numeroDepa;
		  this.nombreDepa=nombreDepa;
		  this.numeroTrabajadores=numeroTrabajadores;
		  this.infoTrabajador=infoTrabajador;
		  
		  
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

  
  
  
  
  
  