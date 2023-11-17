package unitarios;

import org.example.items.Mochila;
import org.example.items.Pocion;
import org.example.pokemon.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MochilaTest {

    @Test
    public void mochilaExisteAlInicializarse(){
        Mochila mochila = new Mochila();
        assertNotEquals(mochila,null);
    }
    @Test
    public void usarItemGastaElItem(){
        //arrange
        Mochila mochila = new Mochila();
        Pocion pocion = mock(Pocion.class);
        mochila.agregarObjeto(pocion);
        Pokemon pokemon = mock(Pokemon.class);
        //act
        when(pocion.getDisponibles()).thenReturn(2);
        Integer usoIniciales = mochila.getUsosItem(1);
        when(pocion.quedanDisponibles()).thenReturn(true);
        mochila.usarItem(pokemon, 1);
        when(pocion.getDisponibles()).thenReturn(1);
        //assert
        assertNotEquals(usoIniciales, mochila.getUsosItem(1));
    }
}
