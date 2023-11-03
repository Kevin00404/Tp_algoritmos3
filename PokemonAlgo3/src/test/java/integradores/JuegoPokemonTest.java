package integradores;

import org.example.Entrenador;
import org.example.Juego;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class JuegoPokemonTest {

    @Test
    public void existenJugadores(){
        //arrange
        String input = "pedro\nPikachu\njuan\nLudicolo\n5";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //act
        Juego juego = new Juego();
        System.setIn(sysInBackup);
        Boolean jugador1 = juego.getEntrenador1() != null;
        Boolean jugador2 = juego.getEntrenador2() != null;
        //assert
        assertNotEquals(jugador1, null);
        assertNotEquals(jugador2, null);
    }

}
