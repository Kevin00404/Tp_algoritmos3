package unitarios;

import org.example.Elemento.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class voladorTest {


    private Element elemento;

    @Before
    public void setUp() {
        elemento = new Volador();
    }

    @Test
    public void mixElement() {
        Element elemento = new Volador();
        Double resultado = elemento.mixElement(elemento);
        assertEquals(resultado, 1.0, 0.01);
    }

    @Test
    public void multiplicador_danio_tipo() {
        assertEquals(elemento.multiplicador_danio_tipo(new Dragon()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo() {
        assertEquals(elemento.multiplicador_danio_tipo(new Agua()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo1() {
        assertEquals(elemento.multiplicador_danio_tipo(new Bicho()), 0.5, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo2() {
        assertEquals(elemento.multiplicador_danio_tipo(new Electrico()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo3() {
        assertEquals(elemento.multiplicador_danio_tipo(new Fantasma()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo4() {
        assertEquals(elemento.multiplicador_danio_tipo(new Fuego()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo5() {
        assertEquals(elemento.multiplicador_danio_tipo(new Hielo()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo6() {
        assertEquals(elemento.multiplicador_danio_tipo(new Lucha()), 0.5, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo7() {
        assertEquals(elemento.multiplicador_danio_tipo(new Normal()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo8() {
        assertEquals(elemento.multiplicador_danio_tipo(new Planta()), 0.5, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo9() {
        assertEquals(elemento.multiplicador_danio_tipo(new Psiquico()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo10() {
        assertEquals(elemento.multiplicador_danio_tipo(new Roca()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo11() {
        assertEquals(elemento.multiplicador_danio_tipo(new Tierra()), 0.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo12() {
        assertEquals(elemento.multiplicador_danio_tipo(new Veneno()), 1.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo13() {
        assertEquals(elemento.multiplicador_danio_tipo(new Volador()), 1.0, 0.1);
    }
}


