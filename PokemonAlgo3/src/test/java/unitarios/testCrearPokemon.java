package unitarios;


import org.example.Elemento.Lucha;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;
import org.example.pokemon.PokemonBuilder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

//@ExtendWith(MockitoExtension.class)
public class testCrearPokemon {
    @Test
public void testUno(){
        Habilidad habilidad = mock(Habilidad.class);

        Pokemon pokemon = new Pokemon("nomkjbre","historia",habilidad,"estadistica");

        assertEquals("nombre",pokemon.getNombre());

    }


}
