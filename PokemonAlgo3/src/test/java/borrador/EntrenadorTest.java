package borrador;

import org.example.Entrenador;
import org.example.items.Mochila;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EntrenadorTest {

    private Entrenador entrenador;

    @BeforeEach
    public void setup() {
        Pokebola pokebola =mock(Pokebola.class);
        Mochila mochila =mock(Mochila.class);

        Pokemon pokemon =mock(Pokemon.class);


        this.entrenador= new Entrenador(pokebola,mochila, "nombre");


    }

    @Test
    public void entrenadorEsnulo(){
        assertNull(entrenador);
    }


    @Test
    public void getPokemonActual() {
        Pokebola pokebola =mock(Pokebola.class);
        Mochila mochila =mock(Mochila.class);

        entrenador= new Entrenador(pokebola,mochila, "nombre");

        //Debe de fallar sin pokemon:
        assertNull(this.entrenador.getPokemonActual());


        //Debe funcionar con pokemon
        Pokemon pokemon =mock(Pokemon.class);
        when(pokebola.cambiarPokemon()).thenReturn(pokemon);
        entrenador.cambiarPokemonActual();
        assertEquals(pokemon,entrenador.getPokemonActual());
    }

}