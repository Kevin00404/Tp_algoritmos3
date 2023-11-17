package unitarios;

import org.example.Elemento.Electrico;
import org.example.Elemento.Element;
import org.example.Elemento.Fuego;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ElectricoTest {
    @Test
    public void testBonusMismoTipo_Match() {
        Electrico electrico = new Electrico();
        Element otroElemento = mock(Element.class);

        Mockito.when(otroElemento.get_tipo()).thenReturn("Electrico");

        Double resultado = electrico.bonus_mismo_tipo(otroElemento);

        assertEquals(1.5, resultado, 0.01);
    }

    @Test
    public void testBonusMismoTipo_NoMatch() {
        Electrico electrico = new Electrico();
        Element otroElemento = mock(Element.class);

        Mockito.when(otroElemento.get_tipo()).thenReturn("Agua");

        Double resultado = electrico.bonus_mismo_tipo(otroElemento);

        assertEquals(1.0, resultado, 0.01);
    }

    @Test
    public void testMultiplicadorDanioTipo_Fuego() {
        Electrico electrico = new Electrico();
        Fuego fuego = mock(Fuego.class);

        Double resultado = electrico.multiplicador_danio_tipo(fuego);

        assertEquals(1.0, resultado, 0.01);
    }
}
