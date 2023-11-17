package unitarios;

import org.example.Elemento.Agua;
import org.example.Elemento.Dragon;
import org.example.Elemento.Element;
import org.example.Elemento.Fuego;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementTest {
    private Element agua;
    private Element fuego;
    private Element dragon;


    @Before
    public void setUp(){
        this.agua=new Agua();
        this.fuego=new Fuego();
        this.dragon=new Dragon();
    }
    @Test
    public void get_tipo() {
        assertEquals("Agua",agua.get_tipo());



    }

    @Test
    public void bonus_mismo_tipo() {
        double resultado=fuego.bonus_mismo_tipo(new Fuego());
        assertEquals(resultado,1.5,0.01);


        double resultado2=fuego.bonus_mismo_tipo(dragon);
        assertEquals(resultado2,1.0,0.01);
    }


    @Test
    public void multiplicador_danio_tipo() {
        Element elemento=new Agua();
        double resultado=elemento.multiplicador_danio_tipo(elemento);
        assertEquals(resultado,0.0,0.01);


    }

    @Test
    public void testMultiplicador_danio_tipo() {
    }

    @Test
    public void testMultiplicador_danio_tipo1() {
    }

    @Test
    public void testMultiplicador_danio_tipo2() {
    }

    @Test
    public void testMultiplicador_danio_tipo3() {
    }

    @Test
    public void testMultiplicador_danio_tipo4() {
    }

    @Test
    public void testMultiplicador_danio_tipo5() {
    }

    @Test
    public void testMultiplicador_danio_tipo6() {
    }

    @Test
    public void testMultiplicador_danio_tipo7() {
    }

    @Test
    public void testMultiplicador_danio_tipo8() {
    }

    @Test
    public void testMultiplicador_danio_tipo9() {
    }

    @Test
    public void testMultiplicador_danio_tipo10() {
    }

    @Test
    public void testMultiplicador_danio_tipo11() {
    }

    @Test
    public void testMultiplicador_danio_tipo12() {
    }

    @Test
    public void testMultiplicador_danio_tipo13() {
    }

    @Test
    public void testMultiplicador_danio_tipo14() {
    }

    @Test
    public void mixElement() {
    }
}