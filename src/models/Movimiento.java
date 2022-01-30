package models;

public class Movimiento {
	
	//-----Enum
	public enum Categoria {
		Fisico, Estado, Especial
	}

	//----Atributos
	private String nombre;
	private TipoPokemon tipo;
	private int maxPP;
	private int actualPP;
	private int damage;
	private int cambiaAttack;
	private int cambiaDefense;
	private int cambiaSpAttack;
	private int cambiaSpDefense;
	private int cambiaSpeed;
	private Estado aplicaEstado;
	private Categoria categoria;
	
	//-----Constructores
	public Movimiento(String nombre, TipoPokemon tipo, int maxPP, int damage, int cambiaAttack,
			int cambiaDef, int cambiaSpAttack, int cambiaSpDef, int cambiaSpeed, Estado aplicaEstado, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.maxPP = maxPP;
		this.actualPP = this.maxPP;
		this.damage = damage;
		this.cambiaAttack = cambiaAttack;
		this.cambiaDefense = cambiaDef;
		this.cambiaSpAttack = cambiaSpAttack;
		this.cambiaSpDefense = cambiaSpDef;
		this.cambiaSpeed = cambiaSpeed;
		this.aplicaEstado = aplicaEstado;
		this.categoria = categoria;
	}

	//-----Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPokemon getTipo() {
		return tipo;
	}

	public void setTipo(TipoPokemon tipo) {
		this.tipo = tipo;
	}

	public int getMaxPP() {
		return maxPP;
	}

	public void setMaxPP(int maxPP) {
		this.maxPP = maxPP;
	}

	public int getActualPP() {
		return actualPP;
	}

	public void setActualPP(int actualPP) {
		this.actualPP = actualPP;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCambiaAttack() {
		return cambiaAttack;
	}

	public void setCambiaAttack(int cambiaAttack) {
		this.cambiaAttack = cambiaAttack;
	}

	public int getCambiaDef() {
		return cambiaDefense;
	}

	public void setCambiaDef(int cambiaDef) {
		this.cambiaDefense = cambiaDef;
	}

	public int getCambiaSpAttack() {
		return cambiaSpAttack;
	}

	public void setCambiaSpAttack(int cambiaSpAttack) {
		this.cambiaSpAttack = cambiaSpAttack;
	}

	public int getCambiaSpDef() {
		return cambiaSpDefense;
	}

	public void setCambiaSpDef(int cambiaSpDef) {
		this.cambiaSpDefense = cambiaSpDef;
	}

	public int getCambiaSpeed() {
		return cambiaSpeed;
	}

	public void setCambiaSpeed(int cambiaSpeed) {
		this.cambiaSpeed = cambiaSpeed;
	}

	public Estado getAplicaEstado() {
		return aplicaEstado;
	}

	public void setAplicaEstado(Estado aplicaEstado) {
		this.aplicaEstado = aplicaEstado;
	}

	
	public int getCambiaDefense() {
		return cambiaDefense;
	}

	
	public void setCambiaDefense(int cambiaDefense) {
		this.cambiaDefense = cambiaDefense;
	}


	public int getCambiaSpDefense() {
		return cambiaSpDefense;
	}


	public void setCambiaSpDefense(int cambiaSpDefense) {
		this.cambiaSpDefense = cambiaSpDefense;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
