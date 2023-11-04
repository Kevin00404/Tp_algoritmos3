package unitarios;

import org.example.Entrenador;
import org.example.Juego;
import org.example.items.CuraTotal;
import org.example.items.Mochila;
import org.example.items.Pocion;
import org.example.pokemon.Pokemon;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

public class JuegoPokemonTest {

    @Test
    public void itemSeEliminaAlQuedarseSinUsos(){
        Mochila mochila = new Mochila();
        Pokemon pokemon = mock(Pokemon.class);
        Pocion pocion = mock(Pocion.class);
        CuraTotal cura = mock(CuraTotal.class);
        mochila.agregarObjeto(pocion);
        mochila.agregarObjeto(cura);
        Integer cantidadItems = mochila.getCantidadItems();
        mochila.usarItem(pokemon, 1);
        assertNotEquals(cantidadItems, mochila.getCantidadItems());
    }
}
