package borrador;

import org.example.Entrenador;
import org.example.items.Mochila;
import org.example.pokebola.Pokebola;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

public class testEntrenador {

    @Test
    public void tieneSeisPokemones(){

    }
@Test
    public void entrenadorNoEsnulo(){
        Pokebola pokebola =mock(Pokebola.class);
        Mochila mochila =mock(Mochila.class);

        Entrenador entrenador= new Entrenador(pokebola,mochila, "nombre");

        assertNotNull(entrenador);
    }




}
