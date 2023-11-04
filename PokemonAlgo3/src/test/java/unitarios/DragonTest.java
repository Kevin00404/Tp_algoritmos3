package unitarios;

import org.example.Elemento.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DragonTest {
    private Dragon dragon;

    @Before
    public void setUp(){
        dragon=new Dragon();
    }

    @Test
    public void mixElement() {
        Element elemento=new Dragon();
        Double resultado=dragon.mixElement(elemento);
        assertEquals(resultado,2.0,0.01);
    }

    @Test
    public void multiplicador_danio_tipo() {
        assertEquals(dragon.multiplicador_danio_tipo(new Dragon()),2.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo() {
        assertEquals(dragon.multiplicador_danio_tipo(new Agua()),0.5,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo1() {
        assertEquals(dragon.multiplicador_danio_tipo(new Bicho()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo2() {
        assertEquals(dragon.multiplicador_danio_tipo(new Electrico()),0.5,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo3() {
        assertEquals(dragon.multiplicador_danio_tipo(new Fantasma()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo4() {
        assertEquals(dragon.multiplicador_danio_tipo(new Fuego()),0.5,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo5() {
        assertEquals(dragon.multiplicador_danio_tipo(new Hielo()),2.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo6() {
        assertEquals(dragon.multiplicador_danio_tipo(new Lucha()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo7() {
        assertEquals(dragon.multiplicador_danio_tipo(new Normal()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo8() {
        assertEquals(dragon.multiplicador_danio_tipo(new Planta()),0.5,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo9() {
        assertEquals(dragon.multiplicador_danio_tipo(new Psiquico()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo10() {
        assertEquals(dragon.multiplicador_danio_tipo(new Roca()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo11() {
        assertEquals(dragon.multiplicador_danio_tipo(new Tierra()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo12() {
        assertEquals(dragon.multiplicador_danio_tipo(new Veneno()),1.0,0.1);
    }

    @Test
    public void testMultiplicador_danio_tipo13() {
        assertEquals(dragon.multiplicador_danio_tipo(new Volador()),1.0,0.1);
    }
}