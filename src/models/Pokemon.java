package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {

	//-----Atributos
	private int numero;
	private String nombre;
	private TipoPokemon tipo1;
	private TipoPokemon tipo2;
	private Estado estado;
	private double attack;
	private double defense;
	private double specialAttack;
	private double specialDefense;
	private double speed;
	private ArrayList<Movimiento> movimientos;
	private double maxHP;
	private double actualHP;
	private int level;
	
	//-----Constructores
	
	/**
	 * Construye un Pokemon que sea de 2 tipos
	 */
	public Pokemon(int numero, String nombre, TipoPokemon tipo1, TipoPokemon tipo2, Estado estado, double attack,
			double defense, double specialAttack, double specialDefense, double speed, ArrayList<Movimiento> movimientos,
			double maxHP, double actualHP, int level) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.estado = estado;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
		this.movimientos = movimientos;
		this.maxHP = maxHP;
		this.actualHP = actualHP;
		this.level = level;
	}
	
	/**
	 * Construye un Pokemon que sea de 1 tipo
	 */
	public Pokemon(int numero, String nombre, TipoPokemon tipo1, Estado estado, double attack,
			double defense, double specialAttack, double specialDefense, double speed, ArrayList<Movimiento> movimientos,
			double maxHP, double actualHP, int level) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.estado = estado;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
		this.movimientos = movimientos;
		this.maxHP = maxHP;
		this.actualHP = actualHP;
		this.level = level;
	}

	//-----Getters & Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPokemon getTipo1() {
		return tipo1;
	}

	public void setTipo1(TipoPokemon tipo1) {
		this.tipo1 = tipo1;
	}

	public TipoPokemon getTipo2() {
		return tipo2;
	}

	public void setTipo2(TipoPokemon tipo2) {
		this.tipo2 = tipo2;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(double specialAttack) {
		this.specialAttack = specialAttack;
	}

	public double getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(double specialDefense) {
		this.specialDefense = specialDefense;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public double getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(double maxHP) {
		this.maxHP = maxHP;
	}

	public double getActualHP() {
		return actualHP;
	}

	public void setActualHP(double actualHP) {
		this.actualHP = actualHP;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	//-----Métodos
	
	/**
	 * Pide al usuario elegir un movimiento. Posterior a ello, en caso de
	 * que el movimiento seleccionado tenga PP, indicará cual fue el movimiento 
	 * seleccionado, el daño que inflinge, el estado que aplica y mostrará
	 * cuanto daño recibe el oponente en caso de haber recibido un estado.
	 * @return Movimiento elegido
	 */
	public Movimiento elegirMovimientoPlayer() {
		String resp;
		boolean posible;
		do {
			posible = true;
			System.out.print("\n  • »» Respuesta: ");
			Scanner sc = new Scanner (System.in);
			resp = sc.next().toUpperCase();	
			
			switch (resp) {
			
			case "A": //Elige el primer movimiento
				if (movimientos.get(0).getActualPP() > 0) {
				movimientos.get(0).setActualPP(movimientos.get(0).getActualPP()-1);
				System.out.println("\n╭─────────────────────────────────────────────────────────╮");
				System.out.print("    »» Movimiento: " + movimientos.get(0).getNombre());
				return movimientos.get(0);
				} else {
					err0rPP();
					posible = false;
				}
				break;
			case "B": //Elige el segundo movimiento
				if (movimientos.get(1).getActualPP() > 0) {
					movimientos.get(1).setActualPP(movimientos.get(1).getActualPP()-1);
					System.out.println("\n╭─────────────────────────────────────────────────────────╮");
					System.out.print("    »» Movimiento: " + movimientos.get(1).getNombre());
					return movimientos.get(1);
					} else {
						err0rPP();
						posible = false;
					}
				break;
			case "C": //Elige el tercer movimiento
				if (movimientos.get(2).getActualPP() > 0) {
					movimientos.get(2).setActualPP(movimientos.get(2).getActualPP()-1);
					System.out.println("\n╭─────────────────────────────────────────────────────────╮");
					System.out.print("    »» Movimiento: " + movimientos.get(2).getNombre());
					return movimientos.get(2);
					} else {
						err0rPP();
						posible = false;
					}
				break;
			case "D": //Elige el cuarto movimiento
				if (movimientos.get(3).getActualPP() > 0) {
					movimientos.get(3).setActualPP(movimientos.get(3).getActualPP()-1);
					System.out.println("\n╭─────────────────────────────────────────────────────────╮");
					System.out.print("    »» Movimiento: " + movimientos.get(3).getNombre());
					return movimientos.get(3);
					} else {
						err0rPP();
						posible = false;
					}
				break;
			default: //Imprime Err0r
				err0rMenus();
				posible = false;
			}
		} while (!posible);
		return null;
	}
	
	/**
	 * Método automático que hace elegir un movimiento a la CPU de manera aleatoria.
	 * Posterior a ello, en caso de que el movimiento seleccionado tenga PP, indicará 
	 * cual fue el movimiento seleccionado, el daño que inflinge, el estado que aplica 
	 * y mostrara cuanto daño recibe el oponente en caso de haber recibido un estado.
	 * @return Movimiento elegido
	 */
	public Movimiento elegirMovimientoCPU() {
		int resp;
		boolean posible;
		do {
			posible = true;
			resp = (int) (Math.random()*4+1);

			switch (resp) {
			
			case 1: //Elige el primer movimiento
				if (movimientos.get(0).getActualPP() > 0) {
				movimientos.get(0).setActualPP(movimientos.get(0).getActualPP()-1);
				System.out.println("\n  • »» Respuesta: A");
				System.out.println("\n╭─────────────────────────────────────────────────────────╮");
				System.out.print("    »» Movimiento: " + movimientos.get(0).getNombre());
				return movimientos.get(0);
				} else {
					err0rPP();
					posible = false;
				}
				break;
			case 2: //Elige el segundo movimiento
				if (movimientos.get(1).getActualPP() > 0) {
					movimientos.get(1).setActualPP(movimientos.get(1).getActualPP()-1);
					System.out.println("\n  • »» Respuesta: B");
					System.out.println("\n╭─────────────────────────────────────────────────────────╮");
					System.out.print("    »» Movimiento: " + movimientos.get(1).getNombre());
					return movimientos.get(1);
					} else {
						err0rPP();
						posible = false;
					}
				break;
			case 3: //Elige el tercer movimiento
				if (movimientos.get(2).getActualPP() > 0) {
					movimientos.get(2).setActualPP(movimientos.get(2).getActualPP()-1);
					System.out.println("\n  • »» Respuesta: C");
					System.out.println("\n╭─────────────────────────────────────────────────────────╮");
					System.out.print("    »» Movimiento: " + movimientos.get(2).getNombre());
					return movimientos.get(2);
					} else {
						err0rPP();
						posible = false;
					}
				break;
			case 4: //Elige el cuarto movimiento
				if (movimientos.get(3).getActualPP() > 0) {
					movimientos.get(3).setActualPP(movimientos.get(3).getActualPP()-1);
					System.out.println("\n  • »» Respuesta: D");
					System.out.println("\n╭─────────────────────────────────────────────────────────╮");
					System.out.print("    »» Movimiento: " + movimientos.get(3).getNombre());
					return movimientos.get(3);
					} else {
						err0rPP();
						posible = false;
					}
				break;
			}
		} while (!posible);
		return null;
	}
	
	/**
	 * Imprime el panel de combate, muestra la HP de cada Pokemon junto a su nombre
	 * Indica de quien es el turno y muestra los movimientos posibles con sus PP
	 * @param p1 Pokemon 1
	 * @param p2 Pokemon 2
	 */
	public void imprimePanel(Pokemon p1, Pokemon p2) {
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃░░░░░░░░░░░░░░░░░░░ PANEL DE COMBATE ░░░░░░░░░░░░░░░░░░░░┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                                                         ┃");
		System.out.println("         "+p1.getNombre()+": "+p1.getActualHP()+"HP        "+p2.getNombre()+": "+p2.getActualHP()+"HP");
		System.out.println("");
		System.out.println("                   Turno de "+p1.getNombre()+"");
		System.out.println("            Elige un movimiento a continuación          ");
		System.out.println("");
		System.out.println("  A »» "+movimientos.get(0).getNombre() + " "+ movimientos.get(0).getActualPP()+"/"+ movimientos.get(0).getMaxPP()+" PP"
					+ "\n" + "  B »» "+movimientos.get(1).getNombre() + " "+ movimientos.get(1).getActualPP()+"/"+ movimientos.get(1).getMaxPP()+" PP");
		System.out.println("  C »» "+movimientos.get(2).getNombre() + " "+ movimientos.get(2).getActualPP()+"/"+ movimientos.get(2).getMaxPP()+" PP"
					+ "\n" + "  D »» "+movimientos.get(3).getNombre() + " "+ movimientos.get(3).getActualPP()+"/"+ movimientos.get(3).getMaxPP()+" PP");
		System.out.println("");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	/**
	 * Imprime un error por haber introducido un valor incorrecto como respuesta a un menú
	 */
	public static void err0rMenus() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>> El valor indicado, no corresponde <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>  a una de las opciones del menú   <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>        Vuelve a Intentarlo        <<<< ERR0R!│ ");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	/**
	 * Imprime un error por haber indicado un movimiento que tiene 0 PP
	 */
	public static void err0rPP() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>>   El movimiento seleccionado no   <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>      cuenta con suficiente PP     <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>        Vuelve a Intentarlo        <<<< ERR0R!│ ");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	
	
	
	
}
