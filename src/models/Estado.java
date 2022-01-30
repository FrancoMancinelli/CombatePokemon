package models;

public class Estado {

	//-----Atributos
	private String nombre;

	//-----Constructores
	public Estado(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	//-----Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
