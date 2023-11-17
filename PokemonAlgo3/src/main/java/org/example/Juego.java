package org.example;
import java.util.Scanner;

import org.example.Clima.ManejoDeClima;
import org.example.Elemento.*;
import org.example.Estadistica.ModificacionEstadistica;
import org.example.Log.Log;
import org.example.Eventos.Eventos;
import org.example.items.*;
import org.example.jugada.Jugada;
import org.example.jugada.JugadaFactory;
import org.example.pokebola.Pokebola;
import org.example.pokemon.PokemonBuilder;

public class Juego {
    Entrenador entrenador1;
    Entrenador entrenador2;
    final Integer POKEMONES_POR_POKEBOLA = 6;
    public ModificacionEstadistica modificacionEstadisticaPokemon;
    private Scanner scanner;
    public Juego(){
        scanner = new Scanner(System.in);
    }
    public void iniciar_Juego(){
        this.inicializar();
        this.batalla();
    }

    public void batalla() {
        Log.getLog().log("¡Comienza la batalla de Pokémon!");
        while (entrenador1.tienePokemonDisponible() && entrenador2.tienePokemonDisponible()) {
            // Turno de entrenador1
            turnoJugador(entrenador1, entrenador2);
            entrenador1.efectosPasivos();
            Eventos.getEventos().ejecutarEvento();
            //verificar si se rindio
            if (entrenador1.murio()){
                break;
            }
            // Verificar si entrenador2 sigue vivo
            if (entrenador2.murio()) {
                Log.getLog().log("entrenador 2 ha perdido.");
                break;
            }
            ManejoDeClima.getTerreno().aplicarDanioTerreno(entrenador1,entrenador2);
            // Turno de entrenador2
            turnoJugador(entrenador2, entrenador1);
            entrenador2.efectosPasivos();
            Eventos.getEventos().ejecutarEvento();
            //verificar si se rindio
            if (entrenador2.murio()){
                break;
            }
            // Verificar si entrenador1 sigue vivo
            if (entrenador1.murio()) {
                Log.getLog().log("entrenador 1 ha perdido.");
                break;
            }
            ManejoDeClima.getTerreno().aplicarDanioTerreno(entrenador1,entrenador2);
        }

        System.out.println("¡Fin del juego!");
    }

    public void turnoJugador(Entrenador jugador, Entrenador oponente) {
        jugador.actualizarPokemonActual();
        boolean pasarTurno = false;
        JugadaFactory jugadaFactory = new JugadaFactory(jugador, oponente);
        while(!pasarTurno){
            Jugada jugada = jugadaFactory.inicializarJugada();
            pasarTurno = jugada.jugar();
            Eventos.getEventos().ejecutarEvento();
        }
    }

    public Entrenador crearEntrenador1(){
        Mochila mochilaEntrenador = inicializarItems();
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        Entrenador entrenador = new Entrenador(new Pokebola(POKEMONES_POR_POKEBOLA) , mochilaEntrenador , preguntarNombre(1));
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Charmander").setElemento(new Fuego()).setHistoria("Nacio en un volcan(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Pikachu").setElemento(new Electrico()).setHistoria("Hijo de los rayos").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Bulbasaur").setElemento(new Planta()).setHistoria("Nacio en un bosque(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Flygon").setElemento(new Dragon()).setHistoria("Nacio en el cielo(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Swellow").setElemento(new Volador()).setHistoria("Pollito de fuego").crearPokemon());
        return entrenador;
    }

    public Entrenador crearEntrenador2(){
        Mochila mochilaEntrenador = inicializarItems();
        Entrenador entrenador = new Entrenador(new Pokebola(POKEMONES_POR_POKEBOLA) , mochilaEntrenador , preguntarNombre(2));
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Hariyama").setElemento(new Lucha()).setHistoria("Le gusta pelear(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Swampert").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Claydol").setElemento(new Electrico()).setHistoria("Hijo de los rayos").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Exploud").setElemento(new Normal()).setHistoria("Nacio en un bosque(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Ludicolo").setElemento(new Planta()).setHistoria("Nacio en el bosque(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Cacnea").setElemento(new Volador()).setHistoria("Nacio en el bosque").crearPokemon());
        return entrenador;
    }

    public void inicializar(){
        PokemonBuilder pokemonBuilder = new PokemonBuilder();

        this.entrenador1 = crearEntrenador1();
        entrenador1.cambiarPokemonActual();

        this.entrenador2 = crearEntrenador2();
        entrenador2.cambiarPokemonActual();
    }



    public String preguntarNombre(Integer numero) {
        String nombre = " ";
        System.out.println("jugador "+ numero + " ingresa tu nombre: ");
        nombre = scanner.next();
        while (!nombreValido(nombre)){
            System.out.println("nombre no valido");
            System.out.println("jugador "+ numero + " ingresa tu nombre: ");
            nombre = scanner.next();
        }
        return nombre;
    }

    public Boolean nombreValido(String nombre){
        if (nombre == ""){
            return false;
        } else if (nombre == " "){
            return false;
        } else if ( nombre.length() >50){
            return false;
        }
        return true;
    }

    /* INICIALIZACION DE ITEMS */
    public Mochila inicializarItems(){
        CuraTotal curaTotal = new CuraTotal("cura total" , 1);
        PocionDespertarDormido despertar = new PocionDespertarDormido("despertar" , 1);
        PocionAntiVeneno antiVeneno = new PocionAntiVeneno("antiveneno" , 1);
        PocionCurarParalisis curarParalisis = new PocionCurarParalisis("antiparalisis" , 1);
        Pocion pocionBasica = new Pocion(20.0 ,"pocion basica" , 1);
        Pocion megaPocion = new Pocion(50.0 , "mega pocion" , 1);
        Pocion hiperPocion = new Pocion(100.0 , "hiper pocion" , 1);
        Revivir revivir = new Revivir(20.0 , "revivir" , 1);
        Revivir maxRevivir = new Revivir(100.0 , "max revivir" , 1);
        PocionDeAtaque ataqueX = new PocionDeAtaque("ataque x", 10.0 , 1);
        PocionDeDefensa defensaX = new PocionDeDefensa("defensa x" , 10.0 , 1);
        Mochila mochilaEntrenador = new Mochila();
        mochilaEntrenador.agregarObjeto(pocionBasica);
        mochilaEntrenador.agregarObjeto(megaPocion);
        mochilaEntrenador.agregarObjeto(hiperPocion);
        mochilaEntrenador.agregarObjeto(curaTotal);
        mochilaEntrenador.agregarObjeto(antiVeneno);
        mochilaEntrenador.agregarObjeto(despertar);
        mochilaEntrenador.agregarObjeto(curarParalisis);
        mochilaEntrenador.agregarObjeto(revivir);
        mochilaEntrenador.agregarObjeto(maxRevivir);
        mochilaEntrenador.agregarObjeto(ataqueX);
        mochilaEntrenador.agregarObjeto(defensaX);
        return mochilaEntrenador;
    }
}
