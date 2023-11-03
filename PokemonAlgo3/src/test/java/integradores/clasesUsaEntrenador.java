package integradores;

import org.example.Elemento.*;
import org.example.Entrenador;
import org.example.Estadisticas.EstadisticaPokemon;
import org.example.Estadisticas.Estadisticas;
import org.example.habilidad.Habilidad;
import org.example.items.*;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.example.pokemon.PokemonBuilder;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Hashtable;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

public class clasesUsaEntrenador {
    private Entrenador entrenador;
    private Pokebola pokebola;
    private Mochila mochila;
    @BeforeEach
    public void setup() {
        this.entrenador= crearEntrenador();
    }

    @Test
    public void inicio() {
        Hashtable<Integer, Habilidad> habilidades = new Hashtable<>();
        Fuego fuego = new Fuego();

        // Crear un objeto de estadísticas (debes proporcionar los valores adecuados)
        Estadisticas estadisticas = new EstadisticaPokemon(100.0, 20.0, 20.0, 10.0, fuego);

        // Crear un Pokemon con nombre, historia, habilidades y estadísticas
        Pokemon pokemon = new Pokemon("Charmander", "Nacio en un volcan(?", habilidades, estadisticas);


        assertNotNull(this.entrenador);
        Pokemon pokemonActual = entrenador.getPokemonActual();

        //Al inicio el pokemon Actual es Null
        assertNull(pokemonActual);

    }


    @Test
    public void testCambiarPokemon() {
        Pokebola pokebola_= new Pokebola(6);

        // Definir la entrada de usuario simulada
        String input = "Pikachu\n"; // Ingresa el nombre del primer Pokémon

        // Convertir la entrada simulada en un flujo de entrada
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Llamar a tu método que utiliza System.in
        Pokemon pokemonElegido = pokebola_.cambiarPokemon();

        // Restaurar System.in
        System.setIn(System.in);

        // Verificar que el Pokémon elegido sea el primero del diccionario
        String nombrePokemonEsperado = "Pikachu"; // Nombre del primer Pokémon en el diccionario
        assertEquals(nombrePokemonEsperado, pokemonElegido.getNombre());
    }

    @Test
    void verificaSalidade_CambiarPOkemon() {



        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Llamar a entrenador.cambiarPokemonActual();
        entrenador.cambiarPokemonActual();

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Obtener la salida como una cadena
        String output = outputStream.toString().trim(); // trim() para eliminar espacios en blanco adicionales

        // Verificar que la primera línea sea igual a lo que esperas
        String primeraLineaEsperada = "Pokemones disponibles: ";
        assertEquals(primeraLineaEsperada, output.split("\n")[0]);



        //assertSame(pokemon2, pokemon);

    }



    @Test
    void getPokemonActual() {
    }

    @Test
    void cambiarPokemonActual() {
    }

    @Test
    void murio() {
    }

    @Test
    void jugarTurno() {
    }

    @Test
    void actualizarPokemonActual() {
    }

    @Test
    void getPokebola() {
    }

    @Test
    void atacar() {
    }

    @Test
    void getPokemon() {
    }

    @Test
    void pokemonEstaVivo() {
    }

    @Test
    void tienePokemonDisponible() {
    }

    @Test
    void usarItemEnMochila() {
    }

    @Test
    void verMochila() {
    }

    @Test
    void verEquipo() {
    }

    @Test
    void getNroEntrenador() {
    }

    @Test
    void rendirse() {
    }

    @Test
    void mostrarPokemonEnBatalla() {
    }

    @Test
    void aplicarEfectos() {
    }

    @Test
    void getNombre() {
    }

    @Test
    void capturarPokemon() {
    }

    @Test
    void mostrarHabilidadesDePokemon() {
    }

    @Test
    void efectosPasivos() {
    }



    private Entrenador crearEntrenador(){
        Mochila mochilaEntrenador = inicializarItems();
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        Entrenador entrenador = new Entrenador(new Pokebola(6) , mochilaEntrenador , "JugadorNombre");
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
