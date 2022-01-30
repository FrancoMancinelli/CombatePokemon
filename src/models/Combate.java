package models;

import models.Movimiento.Categoria;

public class Combate {
 
	//-----Atributos
	private Entrenador entrenador1;
	private Entrenador entrenador2;
	private Pokemon pokemon1;
	private Pokemon pokemon2;
	
	//-----Constructores
	public Combate(Entrenador entrenador1, Entrenador entrenador2) {
		super();
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.pokemon1 = this.entrenador1.getEquipo().getPokemonesArray().get(0);
		this.pokemon2 = this.entrenador2.getEquipo().getPokemonesArray().get(1);
	}

	//-----Getters & Setters
	public Entrenador getEntrenador1() {
		return entrenador1;
	}

	public void setEntrenador1(Entrenador entrenador1) {
		this.entrenador1 = entrenador1;
	}

	public Entrenador getEntrenador2() {
		return entrenador2;
	}

	public void setEntrenador2(Entrenador entrenador2) {
		this.entrenador2 = entrenador2;
	}

	public Pokemon getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(Pokemon pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public Pokemon getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(Pokemon pokemon2) {
		this.pokemon2 = pokemon2;
	}
	
	//-----Métodos
	/**
	 * Comprueba quien es el primer pokemon en atacar según su velocidad
	 * @return Pokemon con mayor velocidad
	 */
	public Pokemon primero() {
		if(pokemon1.getSpeed() >= pokemon2.getSpeed()) {
			return pokemon1;
		} else {
			return pokemon2;
		}
	}
	
	/**
	 * Comprueba quien es el segundo pokemon en atacar según su velocidad
	 * @return Pokemon con menor velocidad
	 */
	public Pokemon segundo() {
		if(pokemon1.getSpeed() >= pokemon2.getSpeed()) {
			return pokemon2;
		} else {
			return pokemon1;
		}
	}
	
	/**
	 * Aplica el movimiento seleccionado por el usuario
	 * Aplica los estados, comprueba los estados y aplicará 
	 * el daño correspondiente
	 * @param move Movimiento elegido
	 * @param atacante Pokemon que ataca
	 * @param atacado Pokemon que es atacado
	 */
	public void aplicarMovimientoPlayer(Movimiento move, Pokemon atacante, Pokemon atacado){
		double damage = 0;
		double quemadura = 0;
		double probabilidad = 0;
		
		//Stats sacadas de https://pokemon.fandom.com/es/wiki/Quemado
		
		//Compruebo si el movimiento aplica un estado de quemadura
		//de ser así, tiene un 10% de probabilidad de aplicarse
		if(move.getAplicaEstado().getNombre().equals("Quemado")) {
			probabilidad = (int)(Math.random() * 100 + 1);
			if (probabilidad <= 10) {
				atacado.getEstado().setNombre("Quemado");
			}
		}
		System.out.print("\n    »» Estado Aplicado: "+atacado.getEstado().getNombre());

		
		if(move.getCategoria().equals(Categoria.Fisico)) {
			damage = (((((2 * atacante.getLevel()) / 5) + 2) * move.getDamage() * atacante.getAttack() / atacado.getDefense()) / 50) + 2;
		} else if (move.getCategoria().equals(Categoria.Especial)) {
			damage = (((((2 * atacante.getLevel()) / 5) + 2) * move.getDamage() * atacante.getSpecialAttack() / atacado.getSpecialDefense()) / 50) + 2;
		}
		
		
		//Resto el daño generado por el movimiento
		damage = (int) Math.round(damage);
		System.out.println("\n    »» Daño Inflingido: "+ damage);
		atacado.setActualHP(atacado.getActualHP() - damage);
		
		//Resto el daño generado por estado de quemadura
		if(atacado.getEstado().getNombre().equals("Quemado")) {
			quemadura = (atacado.getActualHP())*0.0625;
			quemadura = (int) Math.round(quemadura);
			atacado.setActualHP(atacado.getActualHP() - quemadura);
			atacado.getEstado().setNombre("Ninguno");
			System.out.println("    »» Daño Quemadura: "+ quemadura);

		}
		
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");

		
		//Aplico los cambios según cada movimiento
		//Como los movimientos codificados solo afectan al mismo atacante
		//de esta forma funcionaría. De lo contrario habría que aplicar otra sentencia.
		atacante.setAttack(atacante.getAttack()+move.getCambiaAttack());
		atacante.setDefense(atacante.getDefense()+move.getCambiaDefense());
		atacante.setSpecialAttack(atacante.getSpecialAttack()+move.getCambiaSpAttack());
		atacante.setSpecialDefense(atacante.getSpecialDefense()+move.getCambiaSpDefense());
		atacante.setSpeed(atacante.getSpeed()+move.getCambiaSpeed());

	}
	/**
	 * Comprueba si algún Pokemon se ha quedado sin vida, de ser así
	 * pondrá el valor de la vida en 0 e imprimirá un mensaje 
	 * señalando quien ha ganado.
	 * @return True En caso de haber un Pokemon sin vida. False, en caso contrario
	 */
	public boolean isFinished() {
		if(pokemon1.getActualHP() <= 0) {
			pokemon1.setActualHP(0);
			winnerCharmander(pokemon2);
			return true;
		} else if(pokemon2.getActualHP() <= 0) {
				pokemon2.setActualHP(0);
				winnerSquirtle(pokemon1);
				return true;
			} else {
				return false;
			}
	}
	
	/**
	 * Imprime un mensaje indicando quien ha ganado
	 * @param p Pokemon que ha ganado
	 */
	public static void winnerSquirtle(Pokemon p) {
			System.out.println("\n╔══════════════════════════════════════════════════════════╗");
			System.out.println("║ ###### >>>>     ¡La batalla ha finalizado!   <<<< ###### ║");
			System.out.println("║ FINISH >>>>     El ganador es: "+p.getNombre()+"    <<<< FINISH ║");
			System.out.println("║ ###### >>>>           ¡Felicidades!          <<<< ###### ║");
			System.out.println("╚══════════════════════════════════════════════════════════╝\n");
		}
	
	/**
	 * Imprime un mensaje indicando quien ha ganado
	 * @param p Pokemon que ha ganado
	 */
	public static void winnerCharmander(Pokemon p) {
		System.out.println("\n╔══════════════════════════════════════════════════════════╗");
		System.out.println("║ ###### >>>>     ¡La batalla ha finalizado!   <<<< ###### ║");
		System.out.println("║ FINISH >>>>      El ganador es: "+p.getNombre()+"     <<<< FINISH ║");
		System.out.println("║ ###### >>>>           ¡Felicidades!          <<<< ###### ║");
		System.out.println("╚══════════════════════════════════════════════════════════╝\n");
	
	}
	
	
	
	
	
}
