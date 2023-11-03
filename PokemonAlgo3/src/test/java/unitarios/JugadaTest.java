package unitarios;

import org.example.Entrenador;
import org.example.jugada.JugadaAtaque;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class JugadaTest {
   /* private JugadaAtaque jugadaAtaque;
    private Entrenador jugador;
    private Entrenador oponente;
    @Mock
    private Scanner scanner;

    @Before
    public void setUp() {
        jugador = mock(Entrenador.class);
        oponente = mock(Entrenador.class);
        MockitoAnnotations.initMocks(this);
        jugadaAtaque = new JugadaAtaque(jugador, oponente);
    }

    @Test
    public void JugarValido() {
        String input = "1\n";
        InputStream sysInBackup = System.in;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        when(scanner.nextInt()).thenReturn(1);
        System.setIn(sysInBackup);
        assertTrue(jugadaAtaque.jugar());
        verify(jugador, times(1)).mostrarHabilidadesDePokemon();
        verify(jugador, times(1)).atacar(oponente, 1);
    }

    @Test
    public void jugarNovalido() {
        String input = "5\n";
        InputStream sysInBackup = System.in;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        when(scanner.nextInt()).thenReturn(5);
        System.setIn(sysInBackup);
        assertFalse(jugadaAtaque.jugar());
        verify(jugador, times(1)).mostrarHabilidadesDePokemon();
        verifyNoInteractions(oponente);
    }

    */
}