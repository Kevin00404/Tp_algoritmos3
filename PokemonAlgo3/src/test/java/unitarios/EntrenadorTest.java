package unitarios;

import org.example.Entrenador;
import org.example.items.Mochila;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EntrenadorTest {
    private Pokebola pokebola;
    private Entrenador entrenador;

    @Before
    public void setup() {
        this.pokebola =mock(Pokebola.class);
        Mochila mochila =mock(Mochila.class);
        Pokemon pokemon =mock(Pokemon.class);
        this.entrenador= new Entrenador(pokebola,mochila, "nombre");
    }


    @Test
    public void getPokemonActual() {
        //Debe de fallar sin pokemon:
        assertNull(this.entrenador.getPokemonActual());

        //Debe funcionar con pokemon
        Pokemon pokemon =mock(Pokemon.class);
        when(pokebola.cambiarPokemon("")).thenReturn(pokemon);
        entrenador.cambiarPokemonActual("");
        assertEquals(pokemon,entrenador.getPokemonActual());
    }

    @Test
    public void murio() {
        assertFalse(entrenador.murio());

        when(pokebola.murieronTodos()).thenReturn(true);
        assertTrue(entrenador.murio());
    }
   
    @Test
    public void getPokemon() {
        Pokemon pokemon =mock(Pokemon.class);
        when(pokebola.cambiarPokemon("")).thenReturn(pokemon);
        entrenador.cambiarPokemonActual("");

        assertEquals(entrenador.getPokemon(),pokemon);
    }
    @Test
    public void getNroEntrenador() {
        assertEquals("nombre",entrenador.getNroEntrenador());
    }

    @Test
    public void variosMetodos() {
        when(pokebola.murieronTodos()).thenReturn(true);
        assertTrue(entrenador.murio());

        Pokemon pokemon =mock(Pokemon.class);
        entrenador.capturarPokemon(pokemon);
    }
    @Test
    public void entrenadorNoEsnulo(){
        Pokebola pokebola =mock(Pokebola.class);
        Mochila mochila =mock(Mochila.class);

        Entrenador entrenador= new Entrenador(pokebola,mochila, "nombre");

        assertNotNull(entrenador);
    }

}