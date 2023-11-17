package unitarios;

import org.example.Elemento.Agua;
import org.example.items.*;
import org.example.pokemon.Pokemon;
import org.example.pokemon.PokemonBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {
    @Test
    public void pocionEsUsadaCorrectamente(){
        Pocion pocion = new Pocion(10.0, "pocion", 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = pocion.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
    @Test
    public void curaTotalEsUsadoCorrectamente(){
        CuraTotal cura = new CuraTotal("cura", 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = cura.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
    @Test
    public void antiVenenoEsUsadoCorrectamente(){
        PocionAntiVeneno antiVeneno = new PocionAntiVeneno("antiVeneno", 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = antiVeneno.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
    @Test
    public void curaParalisisEsUsadoCorrectamente(){
        PocionCurarParalisis antiParalisis = new PocionCurarParalisis("antiParalisis", 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = antiParalisis.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
    @Test
    public void pocionAtaqueEsUsadoCorrectamente(){
        PocionDeAtaque ataque = new PocionDeAtaque("ataqueX", 10.0, 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = ataque.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
    @Test
    public void despertarDormidoEsUsadoCorrectamente(){
        PocionDespertarDormido despertar = new PocionDespertarDormido("despertar", 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = despertar.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
    @Test
    public void revivirEsUsadoCorrectamente(){
        Revivir revivir = new Revivir(10.0, "revivir", 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = revivir.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
    @Test
    public void pocionDeDefensaEsUsadoCorrectamente(){
        PocionDeDefensa defensa = new PocionDeDefensa("defensaX", 10.0, 1);
        Pokemon pokemon = mock(Pokemon.class);
        Boolean sePudoUsar = defensa.usarItem(pokemon);
        assertEquals(sePudoUsar, true);
    }
}
