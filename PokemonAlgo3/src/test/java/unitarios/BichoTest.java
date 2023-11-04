package unitarios;

import org.example.Elemento.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BichoTest {


    private Element elemento;

    @Before
    public void setUp() {
        elemento = new Bicho();
    }

    @Test
    public void mixElement() {
        Element elemento = new Bicho();
        Double resultado = elemento.mixElement(elemento);
        assertEquals(resultado, 1.0, 0.01);
    }

    @Test
    public void bonus_mismo_tipo() {
        double resultado=elemento.bonus_mismo_tipo(new Bicho());
        assertEquals(resultado,1.5,0.01);


        double resultado2=elemento.bonus_mismo_tipo(new Fuego());
        assertEquals(resultado2,1.0,0.01);
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
        assertEquals(elemento.multiplicador_danio_tipo(new Fuego()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo5() {
        assertEquals(elemento.multiplicador_danio_tipo(new Hielo()), 1.0, 0.1);
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
        assertEquals(elemento.multiplicador_danio_tipo(new Tierra()), 0.5, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo12() {
        assertEquals(elemento.multiplicador_danio_tipo(new Veneno()), 2.0, 0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo13() {
        assertEquals(elemento.multiplicador_danio_tipo(new Volador()), 2.0, 0.1);
    }
}
