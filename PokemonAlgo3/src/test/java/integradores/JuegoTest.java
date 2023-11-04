package integradores;

import org.example.Entrenador;
import org.example.Juego;
import org.example.items.Mochila;
import org.example.pokebola.Pokebola;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class JuegoTest {

    public void setUp() {
        Juego juego = new Juego();


    }

    @Test
    public void testInicializar() {
        Juego juego = new Juego();

        Mochila mochila = juego.inicializarItems();
        Mochila mochilaEsperado = new Mochila();

        assertEquals(mochila.getClass(), mochilaEsperado.getClass());
    }

    @Test
    public void nombreValido() {
        Juego juego = new Juego();
        assertTrue(juego.nombreValido("nombreValido"));
    }
    @Test
    public void nombreInvalido() {
        Juego juego = new Juego();
        assertFalse(juego.nombreValido(""));
    }

    @Test
    public void inicializarItems() {
        String input = "nombreEntrenador1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Llama al método que requiere entrada desde stdin
        Juego juego = new Juego();


        Mochila mochila = juego.inicializarItems();
        Mochila mochilaEsperada=new Mochila();

        assertEquals(mochila.getClass(), mochilaEsperada.getClass());
    }
    @Test
    public void existenJugadores() {
        //arrange
        String input = "pedro\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //act
        Juego juego = new Juego();
        System.setIn(sysInBackup);

        String input2 = "Pikachu\n";
        ByteArrayInputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
    }

    @Test
    public void crearEntrenador1() {
        Pokebola pokebola=new Pokebola(6);
        Mochila mochila=new Mochila();

        Entrenador entrenadorEsperado=new Entrenador(pokebola,mochila,"nombre");

        // Configura la entrada simulada
        String input = "nombreEntrenador1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Juego juego = new Juego();


        assertEquals(entrenadorEsperado.getClass(),juego.crearEntrenador1().getClass());
    }
    @Test
    public void crearEntrenador2() {
        Pokebola pokebola=new Pokebola(6);
        Mochila mochila=new Mochila();

        Entrenador entrenadorEsperado=new Entrenador(pokebola,mochila,"nombre");

        String input = "nombreEntrenador2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Juego juego = new Juego();


        assertEquals(entrenadorEsperado.getClass(),juego.crearEntrenador2().getClass());
    }


    public void borrado() {
        // Configura la entrada simulada
        String input = "nombreEntrenador1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Llama al método que requiere entrada desde stdin
        Juego juego = new Juego();


        juego.crearEntrenador1();
    }
}