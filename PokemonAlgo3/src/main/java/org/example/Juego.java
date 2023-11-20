package org.example;
import java.util.ArrayList;
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

    public Entrenador crearEntrenador1(String nombre){
        Mochila mochilaEntrenador = inicializarItems();
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        Entrenador entrenador = new Entrenador(new Pokebola(POKEMONES_POR_POKEBOLA) , mochilaEntrenador , nombre);
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
        System.out.println("Se creo el entrenador 1 en Juego!");
        return entrenador;
    }

    public Entrenador crearEntrenador2(String nombre){
        Mochila mochilaEntrenador = inicializarItems();
        Entrenador entrenador = new Entrenador(new Pokebola(POKEMONES_POR_POKEBOLA) , mochilaEntrenador , nombre);
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
        System.out.println("Se creo el entrenador 2 en Juego!");
        return entrenador;
    }

    public void inicializar(){

        entrenador1.cambiarPokemonActual("");

        entrenador2.cambiarPokemonActual("");
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

    public void setEntrenador1(Entrenador entrenador) {
        this.entrenador1 = entrenador;
    }

    public void setEntrenador2(Entrenador entrenador) {
        this.entrenador2 = entrenador;
    }

    public String getEntrenadorUnoNombre(){
        return this.entrenador1.getNombre();
    }
    public String getEntrenadorDosNombre(){
        return this.entrenador2.getNombre();
    }

    public ArrayList<String> getPokemonesPokebolaUno() {
        return this.entrenador1.listaPokemones();
    }

    public ArrayList<String> getPokemonesPokebolaDos() {
        return this.entrenador2.listaPokemones();
    }

    public void cambiarPokemonEntrenadorUno(String pokemon) {
        this.entrenador1.cambiarPokemonActual(pokemon);
    }
    public void cambiarPokemonEntrenadorDos(String pokemon) {
        this.entrenador2.cambiarPokemonActual(pokemon);
    }
}
