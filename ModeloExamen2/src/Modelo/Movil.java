package Modelo;

public class Movil{

	private int id;
	private String tecnico;
	private String movil;
	private String fechaReparacion;
	private String fechaReparacionMaxima;
	private String descripcion;
	private int numReparaciones;
	
	public Movil() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getFechaReparacion() {
		return fechaReparacion;
	}

	public void setFechaReparacion(String fechaReparacion) {
		this.fechaReparacion = fechaReparacion;
	}

	public String getFechaReparacionMaxima() {
		return fechaReparacionMaxima;
	}

	public void setFechaReparacionMaxima(String fechaReparacionMaxima) {
		this.fechaReparacionMaxima = fechaReparacionMaxima;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumReparaciones() {
		return numReparaciones;
	}

	public void setNumReparaciones(int numReparaciones) {
		this.numReparaciones = numReparaciones;
	}
}
