package models;

public class TipoPokemon {

	//-----Atributos
	public String nombre;

	//-----Constructores
	public TipoPokemon(String nombre) {
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
	
	//-----Métodos
	public double getEfectividad(TipoPokemon tipo) {
		//TODO
		return 0;
	}
}
