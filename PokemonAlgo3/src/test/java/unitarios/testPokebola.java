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

    @Test
    public void testCambiarPokemon() {
        // Configurar el diccionario de Pokemon con datos de prueba
        Pokebola pokebola = new Pokebola(5);
        //Pokemon pokemon1 = new Pokemon("Bulbasaur"); descomentar
        //Pokemon pokemon2 = new Pokemon("Charmander"); descomentar
        //pokebola.agregarPokemon(pokemon1); descomentar
        //pokebola.agregarPokemon(pokemon2); descomentar

        // Simular la entrada del usuario a través de System.in
        String input = "Charmander\n"; // Elige "Charmander"
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Llamar al método cambiarPokemon()
        Pokemon pokemonElegido = pokebola.cambiarPokemon();

        // Verificar que se eligió el Pokémon correcto
        assertEquals("Charmander", pokemonElegido.getNombre());
    }
}
