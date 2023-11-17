package unitarios;


import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PokebolaTest {

    private Pokebola pokebola;
    @BeforeEach
    void setUp() {
        int cantidad_pokemones=6;
        pokebola=new Pokebola(cantidad_pokemones);
    }

    @Test
    void agregarPokemon() {
        Pokemon pokemon =mock(Pokemon.class);
        pokebola.agregarPokemon(pokemon);

        assertEquals(1,pokebola.cantidadPokemones());

    }

    @Test
    void cambiarPokemon() {

        Pokemon pokemon1 = mock(Pokemon.class);
        when(pokemon1.getNombre()).thenReturn("Charmander");
        when(pokemon1.vida()).thenReturn(100.0);
        when(pokemon1.chequeoDeVida()).thenReturn(true);



        Pokemon pokemon2 = mock(Pokemon.class);
        when(pokemon2.getNombre()).thenReturn("Squirtle");
        when(pokemon2.vida()).thenReturn(100.0);
        when(pokemon2.chequeoDeVida()).thenReturn(true);


        pokebola.agregarPokemon(pokemon1);
        pokebola.agregarPokemon(pokemon2);

        assertEquals(2,pokebola.cantidadPokemones());


        String input = "Charmander\n";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);


        Pokemon pokemonElegido = pokebola.cambiarPokemon();
        System.setIn(System.in);


        String nombrePokemonEsperado = "Charmander";
        assertEquals(nombrePokemonEsperado, pokemonElegido.getNombre());
    }

    @Test
    void obtenerPokemon() {

        Pokemon pokemon1 = mock(Pokemon.class);
        when(pokemon1.getNombre()).thenReturn("Charmander");
        when(pokemon1.vida()).thenReturn(100.0);
        when(pokemon1.chequeoDeVida()).thenReturn(true);



        Pokemon pokemon2 = mock(Pokemon.class);
        when(pokemon2.getNombre()).thenReturn("Squirtle");
        when(pokemon2.vida()).thenReturn(100.0);
        when(pokemon2.chequeoDeVida()).thenReturn(true);

        pokebola.agregarPokemon(pokemon1);
        pokebola.agregarPokemon(pokemon2);

        assertEquals(2,pokebola.cantidadPokemones());

        Pokemon respuesta=pokebola.obtenerPokemon("Charmander");

        assertEquals(respuesta,pokemon1);
    }

    @Test
    void setPokemonInicial() {
        Pokemon pokemon1 = mock(Pokemon.class);
        when(pokemon1.getNombre()).thenReturn("Charmander");
        when(pokemon1.vida()).thenReturn(100.0);
        when(pokemon1.chequeoDeVida()).thenReturn(true);


        pokebola.agregarPokemon(pokemon1);

        Pokemon respuesta= pokebola.setPokemonInicial();
        assertNotNull(respuesta);
        assertEquals(0,pokebola.pokemonesDebilitados());
    }

    @Test
    void enPokebolaSinPokemones() {
        assertEquals(0,pokebola.pokemonesDebilitados());
        assertFalse(pokebola.murieronTodos());
        assertEquals(0,pokebola.pokemonesDebilitados());
    }
    @Test
    void enPOkebolaConTodosLosPokemones() {
        Pokemon pokemon1 = mock(Pokemon.class);
        when(pokemon1.getNombre()).thenReturn("Charmander");
        when(pokemon1.vida()).thenReturn(100.0);
        when(pokemon1.chequeoDeVida()).thenReturn(false);
        when(pokemon1.estaDebilitado()).thenReturn(true);

        Pokemon pokemon2 = mock(Pokemon.class);
        when(pokemon2.getNombre()).thenReturn("Squirtle");
        when(pokemon2.vida()).thenReturn(100.0);
        when(pokemon2.chequeoDeVida()).thenReturn(false);
        when(pokemon2.estaDebilitado()).thenReturn(true);

        Pokemon pokemon3 = mock(Pokemon.class);
        when(pokemon3.getNombre()).thenReturn("pika");
        when(pokemon3.vida()).thenReturn(100.0);
        when(pokemon3.chequeoDeVida()).thenReturn(false);
        when(pokemon3.estaDebilitado()).thenReturn(true);

        Pokemon pokemon4 = mock(Pokemon.class);
        when(pokemon4.getNombre()).thenReturn("nombre4");
        when(pokemon4.vida()).thenReturn(100.0);
        when(pokemon4.chequeoDeVida()).thenReturn(false);
        when(pokemon4.estaDebilitado()).thenReturn(true);

        Pokemon pokemon5 = mock(Pokemon.class);
        when(pokemon5.getNombre()).thenReturn("nombre5");
        when(pokemon5.vida()).thenReturn(100.0);
        when(pokemon5.chequeoDeVida()).thenReturn(false);
        when(pokemon5.estaDebilitado()).thenReturn(true);

        Pokemon pokemon6 = mock(Pokemon.class);
        when(pokemon6.getNombre()).thenReturn("nombre6");
        when(pokemon6.vida()).thenReturn(100.0);
        when(pokemon6.chequeoDeVida()).thenReturn(false);
        when(pokemon6.estaDebilitado()).thenReturn(true);

        pokebola.agregarPokemon(pokemon1);
        pokebola.agregarPokemon(pokemon2);
        pokebola.agregarPokemon(pokemon3);
        pokebola.agregarPokemon(pokemon4);
        pokebola.agregarPokemon(pokemon5);
        pokebola.agregarPokemon(pokemon6);


        //Pruebas:
        assertEquals(6,pokebola.cantidadPokemones());

        pokebola.debilitarEquipo();
        boolean respuesta_murieron = pokebola.murieronTodos();

        assertTrue(respuesta_murieron);

        assertEquals(6,pokebola.pokemonesDebilitados());
    }


}