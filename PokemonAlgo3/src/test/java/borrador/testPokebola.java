package borrador;

import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.example.Log.Log;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class testPokebola{
    @Mock
    private Log logMock;

    @Before
    public void setUp() {
        // Configura el logMock para que no imprima mensajes en la consola
        logMock = Mockito.mock(Log.class);
        //Log.setLog(logMock);
    }

}
