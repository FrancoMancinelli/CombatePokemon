package models;

import java.util.ArrayList;

public class Equipo {

	//-----Atributos
	private static ArrayList <Pokemon> equipoPokemones;

	//-----Constructores
	@SuppressWarnings("static-access")
	public Equipo() {
		super();
		this.equipoPokemones = new ArrayList <Pokemon> ();
	}

	//-----Getters & Setters
	public static ArrayList<Pokemon> getPokemonesArray() {
		return equipoPokemones;
	}

	public static void setPokemonesArray(ArrayList<Pokemon> pokemonesArray) {
		Equipo.equipoPokemones = pokemonesArray;
	}
	
	
}
