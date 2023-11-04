package unitarios;

import org.example.Entrenador;
import org.example.jugada.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class JugadaFactoryTest {
    @Test
    public void inicializarJugada() {
    }

    @Test
    public void jugadaElegida() {
        Entrenador entrenador1=mock(Entrenador.class);
        Entrenador entrenador2=mock(Entrenador.class);

        JugadaFactory jugada=new JugadaFactory(entrenador1,entrenador2);

        JugadaAtaque respuesta1 =new JugadaAtaque(entrenador2, entrenador1);
        assertEquals(jugada.jugadaElegida(1).getClass(),respuesta1.getClass());


        JugadaItem respuesta2 =new JugadaItem(entrenador2, entrenador1);
        assertEquals(jugada.jugadaElegida(2).getClass(),respuesta2.getClass());

        JugadaMirarCampo respuesta3 =new JugadaMirarCampo(entrenador2, entrenador1);
        assertEquals(jugada.jugadaElegida(3).getClass(),respuesta3.getClass());

        JugadaCambioPokemon respuesta4 =new JugadaCambioPokemon(entrenador2, entrenador1);
        assertEquals(jugada.jugadaElegida(4).getClass(),respuesta4.getClass());

        JugadaRendicion respuesta5 =new JugadaRendicion(entrenador2, entrenador1);
        assertEquals(jugada.jugadaElegida(5).getClass(),respuesta5.getClass());

    }
}