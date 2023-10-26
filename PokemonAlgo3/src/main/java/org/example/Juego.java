package org.example;
import java.util.Scanner;
import org.example.Elemento.*;
import org.example.Estadistica.ModificacionEstadistica;
import org.example.Log.Log;
import org.example.items.*;
import org.example.jugada.Jugada;
import org.example.jugada.JugadaFactory;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.example.pokemon.PokemonBuilder;

public class Juego {
    Entrenador entrenador1;
    Entrenador entrenador2;
    final Integer POKEMONES_POR_POKEBOLA = 6;
    public  EstadoPokemon estadoMiPokemon;

    public ModificacionEstadistica modificacionEstadisticaPokemon;
    private Scanner scanner;
    public Juego(){
        scanner = new Scanner(System.in);
        this.inicializar();
        this.batalla();
    }

    public void batalla() {
        Log.getLog().log("¡Comienza la batalla de Pokémon!");
        while (entrenador1.tienePokemonDisponible() && entrenador2.tienePokemonDisponible()) {
            entrenador1.jugarTurno(entrenador2);
            // Turno de entrenador1
            turnoJugador(entrenador1, entrenador2);
            //verificar si se rindio
            if (!entrenador1.tienePokemonDisponible()){
                break;
            }
            // Verificar si entrenador2 sigue vivo
            if (!entrenador2.tienePokemonDisponible()) {
                System.out.println("entrenador 2 ha perdido.");
                break;
            }
            if(!entrenador2.pokemonEstaVivo()){
                entrenador2.setPokemonActual(entrenador2.pokebola.cambiarPokemon());
            }
            // Turno de entrenador2
            turnoJugador(entrenador2, entrenador1);
            //verificar si se rindio
            if (!entrenador2.tienePokemonDisponible()){
                break;
            }
            // Verificar si entrenador1 sigue vivo
            if (!entrenador1.tienePokemonDisponible()) {
                System.out.println("entrenador 1 ha perdido.");
                break;
            }
        }

        System.out.println("¡Fin del juego!");
    }
    private void compararVelocidades() {
        if (entrenador1.pokemonActual.getVelocidad() > entrenador2.pokemonActual.getVelocidad()){

        } else {

        }
    }

    public void turnoJugador(Entrenador jugador, Entrenador oponente) {
        boolean pasarTurno = false;
        JugadaFactory jugadaFactory = new JugadaFactory(jugador, oponente);
        while(!pasarTurno){
            Jugada jugada = jugadaFactory.inicializarJugada();
            pasarTurno = jugada.jugar();
            switch (opcion) {
                case 1:
                    mostrarHabilidades(jugador.getPokemon()); /* ACÁ SE DEBERÍA BUSCAR EN JUGADOR.POKEBOLA.GETACTIVO() O ALGO ASÍ Y LUEGO LAS HABILIDADES DE ESE POKEMON*/
                    int habilidadElegida = scanner.nextInt();
                    if (habilidadElegida == 5){
                        break;
                    }
                    //Habilidad habilidad = jugador.getPokemon()/* ACÁ TAMBIÉN */.habilidades.get(habilidadElegida);
                    jugador.atacar(oponente/* ACÁ TAMBIÉN */, habilidadElegida /* ACÁ VAN LOS PARÁMETROS DEL MÉTODO DE LA CLASE ESTADO */);
                    break;
                case 2:
                    /* ACÁ TIENE QUE IR A BUSCAR AL POKEMON ACTIVO Y APLICARLE EL ITEM SELECCIONADO */
                    System.out.println("seleccione item: ");
                    jugador.verMochila();
                    int objetoElegido = scanner.nextInt();
                    if (objetoElegido == 0){
                        break;
                    }
                    System.out.println("se ha Elegido: "+ objetoElegido);
                    System.out.println("seleccione pokemon: ");
                    jugador.verEquipo();
                    String pokemonElegido = scanner.next();
                    jugador.usarItemEnMochila(objetoElegido , pokemonElegido);
                    //jugador.aplicarEfectos();
                    break;
                case 3:
                    campoDeBatalla(jugador, oponente);
                    break;
                case 4:
                    jugador.aplicarEfectos();
                    System.out.println("x: cancelar");
                    Pokemon opcionElegida = jugador.pokebola.cambiarPokemon();
                    if (opcionElegida == null){
                        break;
                    }
                    jugador.setPokemonActual(opcionElegida);
                    turno = true;
                    break;
                case 5:
                    jugador.rendirse();
                    System.out.println("jugador " + jugador.getNroEntrenador() + " se ha rendido. " + "jugador " + oponente.getNroEntrenador() + " gana la batalla.");
                    turno = true;
                    break;
                default:
                    System.out.println("Opción no válida. Se considera un turno sin acción.");
                    break;
            }
        }
    }
    private void mostrarHabilidades(Pokemon pokemon) {
        pokemon.mostrarHabilidades();
    }
    public void campoDeBatalla(Entrenador jugador, Entrenador oponente){
        System.out.println("Detalles del campo de Batalla:");
        System.out.println("tu pokemon:");
        jugador.mostrarPokemonEnBatalla();
        System.out.println("pokemon enemigo");
        oponente.mostrarPokemonEnBatalla();
    }

    private Entrenador crearEntrenador1(PokemonBuilder pokemonBuilder){
        Mochila mochilaEntrenador = inicializarItems();
        Entrenador entrenador = new Entrenador(new Pokebola(POKEMONES_POR_POKEBOLA) , mochilaEntrenador , preguntarNombre(1));
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Charmander").setElemento(new Fuego()).setHistoria("Nacio en un volcan(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Pikachu").setElemento(new Electrico()).setHistoria("Hijo de los rayos").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Bulbasaur").setElemento(new Planta()).setHistoria("Nacio en un bosque(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Flygon").setElemento(new Dragon()).setHistoria("Nacio en el cielo(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Swellow").setElemento(new Volador()).setHistoria("Pollito de fuego").crearPokemon());
        return entrenador;
    }

    private Entrenador crearEntrenador2(PokemonBuilder pokemonBuilder){
        Mochila mochilaEntrenador = inicializarItems();
        Entrenador entrenador = new Entrenador(new Pokebola(POKEMONES_POR_POKEBOLA) , mochilaEntrenador , preguntarNombre(2));
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Hariyama").setElemento(new Lucha()).setHistoria("Le gusta pelear(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Swampert").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Claydol").setElemento(new Electrico()).setHistoria("Hijo de los rayos").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Exploud").setElemento(new Normal()).setHistoria("Nacio en un bosque(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Ludicolo").setElemento(new Planta()).setHistoria("Nacio en el bosque(?").crearPokemon());
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Cacnea").setElemento(new Volador()).setHistoria("Nacio en el bosque").crearPokemon());
        return entrenador;
    }

    private void inicializar(){
        PokemonBuilder pokemonBuilder = new PokemonBuilder();

        this.entrenador1 = crearEntrenador1(pokemonBuilder);
        entrenador1.cambiarPokemonActual();

        this.entrenador2 = crearEntrenador2(pokemonBuilder);
        entrenador2.cambiarPokemonActual();
    }

    private String preguntarNombre(Integer numero) {
        String nombre = " ";
        System.out.println("jugador "+ numero + " ingresa tu nombre: ");
        nombre = scanner.next();
        while (nombre.length() > 50){
            System.out.println("nombre muy largo");
            System.out.println("jugador "+ numero + " ingresa tu nombre: ");
            nombre = scanner.next();
        }
        return nombre;
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
