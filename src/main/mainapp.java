package main;

import java.util.ArrayList;
import java.util.Scanner;

import models.Combate;
import models.Entrenador;
import models.Equipo;
import models.Estado;
import models.Movimiento;
import models.Pokemon;
import models.TipoPokemon;
import models.Movimiento.Categoria;

public class mainapp {

	public static void main(String[] args) {
		initialize();
	}
	
	/**
	 * Inicia el programa dando la bienvenida y mostrando
	 * un panel de opciones de modo de juego
	 */
	public static void initialize() {	
		
		nuevaPartida();
		String resp;
		
		do { //Pedirá una respuesta hasta que sea valida
			System.out.print("\n  • »» Respuesta: ");
			Scanner sc = new Scanner (System.in);
			resp = sc.next().toUpperCase();
			
			switch (resp) {
			
				case "A": //Crea un combate Pokemon jugador vs jugador
					crearCombatePvP();
					break;
		
				case "B": //Crea un combate Pokemon jugador vs CPU
					crearCombateCPU();
					break;
					
				case "C": //Imprime mensaje de salida y termina el programa
					salir();
					break;
				
				default: //Imprime un Err0r
					err0rMenus();
					break;
			}
		
		} while(!resp.equals("C"));
		
		
		
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
	 * Imprime un mensaje de despedida
	 */
	public static void salir() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│                                                         │");
		System.out.println("│    Oh, que triste verte partir... Vuelve pronto crack   │");
		System.out.println("│                                                         │");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	/**
	 * Crea un combate Pokemon de modalidad Player vs Player
	 */
	public static void crearCombatePvP() {

		//Creo ambos equipos
		Equipo equi1 = new Equipo();
		Equipo equi2 = new Equipo();
	
		//Creo los Pokemones y los asigno a cada equipo
		setPokemones(equi1, equi2);
		
		//Creo ambos entrenadores
		Entrenador entrenador1 = new Entrenador("Entrenador 1", equi1);
		Entrenador entrenador2 = new Entrenador("Entrenador 2", equi2);
		
		//Creo un combate
		Combate combate = new Combate(entrenador1, entrenador2);

		//Mientrtas ningún Pokemon muera, la partida seguirá
		while(!combate.isFinished()) {
			
			//Imprime el panel del primer jugador
			combate.primero().imprimePanel(combate.primero(), combate.segundo());
			combate.aplicarMovimientoPlayer(combate.primero().elegirMovimientoPlayer(), combate.primero(), combate.segundo());
			
			//Antes de imprimir el panel del siguiente jugador, volverá a comprobar
			//que la partida no haya acabado en el anterior turno.
			if(!combate.isFinished()) { 
				combate.segundo().imprimePanel(combate.segundo(), combate.primero());
				combate.aplicarMovimientoPlayer(combate.segundo().elegirMovimientoPlayer(), combate.segundo(), combate.primero());
			}
		}
		nuevaPartida();
	}
	
	/**
	 * Construye dos Pokemones, junto a sus movimientos y
	 * son agregados a su equipo correspondiente
	 * @param e1 Equipo 1
	 * @param e2 Equipo 2
	 */
	public static void setPokemones(Equipo e1, Equipo e2) {
		//Creo los movimientos de Charmander
				Movimiento arañazo = new Movimiento("Arañazo", new TipoPokemon("Normal"), 20, 40, 0, 0, 0, 0, 0, new Estado("Ninguno"), Categoria.Fisico );
				Movimiento gruñido = new Movimiento("Gruñido", new TipoPokemon("Normal"), 20, 0, 0, 1, 0, 0, 0, new Estado("Ninguno"), Categoria.Estado);
				Movimiento ascuas = new Movimiento("Ascuas", new TipoPokemon("Fuego"), 15, 40, 0, 0, 0, 0, 0, new Estado("Quemado"), Categoria.Especial);
				Movimiento danza_espada = new Movimiento("Danza espada", new TipoPokemon("Normal"), 5, 0, 0, 0, 0, 0, 0, new Estado("Ninguno"), Categoria.Estado);
				
				//Creo los movimientos de Squirtle
				Movimiento placaje = new Movimiento("Placaje", new TipoPokemon("Normal"), 20, 40, 1, 1, 1, 1, 1, new Estado("Ninguno"), Categoria.Fisico);
				Movimiento latigo = new Movimiento("Látigo", new TipoPokemon("Normal"), 20, 0, 1, 0, 0, 0, 0, new Estado("Ninguno"), Categoria.Estado);
				Movimiento pistola_agua = new Movimiento("Pistola agua", new TipoPokemon("Agua"), 15, 40, 1, 1, 1, 1, 1, new Estado("Ninguno"), Categoria.Especial);
				Movimiento refugio = new Movimiento("Refugio", new TipoPokemon("Agua"), 5, 0, 0, 1, 0, 0, 0, new Estado("Ninguno"), Categoria.Estado);
				
				//Creo los arrays de movimientos, para cada Pokemon
				//y les añado los movimientos correspondientes
				ArrayList<Movimiento> movesCharmander = new ArrayList<Movimiento>();
				ArrayList<Movimiento> movesSquirtle = new ArrayList<Movimiento>();
				movesCharmander.add(arañazo);
				movesCharmander.add(gruñido);
				movesCharmander.add(ascuas);
				movesCharmander.add(danza_espada);
				
				movesSquirtle.add(placaje);
				movesSquirtle.add(latigo);
				movesSquirtle.add(pistola_agua);
				movesSquirtle.add(refugio);
				
				//Creo ambos Pokemones
				//Stats sacados de https://pokemondb.net/pokedex/charmander
				Pokemon charmander = new Pokemon(4, "Charmander", new TipoPokemon("Fuego"), 
						new Estado("Ninguno"), 52, 43, 60, 50, 65, movesCharmander, 200, 200, 50);
				//Stats sacados de https://pokemondb.net/pokedex/squirtle
				Pokemon squirtle = new Pokemon(7, "Squirtle", new TipoPokemon("Agua"),
						new Estado("Ninguno"), 48, 65, 50, 64, 43, movesSquirtle, 200, 200, 50);
				
				e1.getPokemonesArray().add(charmander);
				e2.getPokemonesArray().add(squirtle);
	}
	
	/**
	 * Crea un combate Pokemon de modalidad Player vs CPU
	 */
	public static void crearCombateCPU() {

		//Creo ambos equipos
		Equipo equi1 = new Equipo();
		Equipo equi2 = new Equipo();
	
		//Creo los Pokemones y los asigno a cada equipo
		setPokemones(equi1, equi2);
		
		//Creo ambos entrenadores
		Entrenador entrenador1 = new Entrenador("Entrenador 1", equi1);
		Entrenador entrenador2 = new Entrenador("Entrenador 2", equi2);
		
		//Creo un combate
		Combate combate = new Combate(entrenador1, entrenador2);

		//Mientrtas ningún Pokemon muera, la partida seguirá
		while(!combate.isFinished()) {
			
			//Imprime el panel del jugador
			combate.primero().imprimePanel(combate.primero(), combate.segundo());
			combate.aplicarMovimientoPlayer(combate.primero().elegirMovimientoPlayer(), combate.primero(), combate.segundo());
			
			//Antes de imprimir el panel de la CPU, volverá a comprobar
			//que la partida no haya acabado en el anterior turno.
			if(!combate.isFinished()) { 
				combate.segundo().imprimePanel(combate.segundo(), combate.primero());
				combate.aplicarMovimientoPlayer(combate.segundo().elegirMovimientoCPU(), combate.segundo(), combate.primero());
			}
		}
		nuevaPartida();
	}
	
	/**
	 * Imprime el panel de menú principal
	 */
	public static void nuevaPartida() {
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃░░░░░░░░░░░░░░░░░░░░ BATALLA POKEMON ░░░░░░░░░░░░░░░░░░░░┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃      Bienvenid@ a la Batalla Pokemon, a continuación    ┃");
		System.out.println("┃                indica una opción del menú               ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┃ A »» Iniciar Combate [PvsP]                             ┃");
		System.out.println("┃ B »» Iniciar Combate [PvsCPU]                           ┃");
		System.out.println("┃ C »» Salir                                              ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	
}
