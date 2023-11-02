package unitarios;

import org.example.Elemento.Electrico;
import org.example.Elemento.Element;
import org.example.Elemento.Fuego;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ElectricoTest {
    final  double MATCH_TIPO_ATAQUE_Y_POKEMON=1.5;
    final double NO_MATCH_TIPO_ATAQUE_Y_POKEMON=1.0;
    @Test
    public void testBonusMismoTipo_Match() {
        Electrico electrico = new Electrico();
        Element otroElemento = mock(Element.class);

        // Configuramos el elemento de prueba para que tenga el mismo tipo que Electrico
        Mockito.when(otroElemento.get_tipo()).thenReturn("Electrico");

        Double resultado = electrico.bonus_mismo_tipo(otroElemento);

        // Verificamos que el resultado sea el esperado
        assertEquals(1.5, resultado, 0.01); // Usamos un delta pequeño para comparar números de punto flotante
    }

    @Test
    public void testBonusMismoTipo_NoMatch() {
        Electrico electrico = new Electrico();
        Element otroElemento = mock(Element.class);

        // Configuramos el elemento de prueba para que tenga un tipo diferente
        Mockito.when(otroElemento.get_tipo()).thenReturn("Agua");

        Double resultado = electrico.bonus_mismo_tipo(otroElemento);

        // Verificamos que el resultado sea el esperado (no hay coincidencia, por lo que debe devolver NO_MATCH_TIPO_ATAQUE_Y_POKEMON)
        assertEquals(1.0, resultado, 0.01);
    }

    @Test
    public void testMultiplicadorDanioTipo_Fuego() {
        Electrico electrico = new Electrico();
        Fuego fuego = mock(Fuego.class);

        // Llama al método multiplicador_danio_tipo con el objeto Fuego como argumento
        Double resultado = electrico.multiplicador_danio_tipo(fuego);

        // Verifica que el resultado sea el esperado para Electrico contra Fuego
        assertEquals(1.0, resultado, 0.01); // Usamos un delta pequeño para comparar números de punto flotante
    }
}
