package unitarios;

import org.example.Elemento.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class rocaTest {


    private Element elemento;

    @Before
    public void setUp() {
        elemento = new Roca();
    }

    @Test
    public void mixElement() {
        Element elemento = new Roca();
        Double resultado = elemento.mixElement(elemento);
        assertEquals(resultado, 1.0, 0.01);
    }

    @Test
    public void multiplicador_danio_tipo() {
        assertEquals(elemento.multiplicador_danio_tipo(new Dragon()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo() {
        assertEquals(elemento.multiplicador_danio_tipo(new Agua()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo1() {
        assertEquals(elemento.multiplicador_danio_tipo(new Bicho()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo2() {
        assertEquals(elemento.multiplicador_danio_tipo(new Electrico()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo3() {
        assertEquals(elemento.multiplicador_danio_tipo(new Fantasma()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo4() {
        assertEquals(elemento.multiplicador_danio_tipo(new Fuego()), 0.5, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo5() {
        assertEquals(elemento.multiplicador_danio_tipo(new Hielo()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo6() {
        assertEquals(elemento.multiplicador_danio_tipo(new Lucha()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo7() {
        assertEquals(elemento.multiplicador_danio_tipo(new Normal()), 0.5, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo8() {
        assertEquals(elemento.multiplicador_danio_tipo(new Planta()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo9() {
        assertEquals(elemento.multiplicador_danio_tipo(new Psiquico()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo10() {
        assertEquals(elemento.multiplicador_danio_tipo(new Roca()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo11() {
        assertEquals(elemento.multiplicador_danio_tipo(new Tierra()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo12() {
        assertEquals(elemento.multiplicador_danio_tipo(new Veneno()), 0.5, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo13() {
        assertEquals(elemento.multiplicador_danio_tipo(new Volador()), 0.5, 0.1);
    }
}



