package unitarios;

import org.example.Elemento.Agua;
import org.example.Estadisticas.Estadisticas;

import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;
import org.example.pokemon.PokemonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runner.RunWith;


import java.util.Hashtable;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonTest {

    private Pokemon pokemon;

    @Before
    public void setup() {
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();
    }


    @Test
    public void aplicar() {
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


    }

    @Test
    public void incio() {
        assertNull(pokemon);


        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        assertEquals("Squirtle",pokemon.getNombre());

        assertNotNull(pokemon.getEstadisticas());


        Comando comando =mock(Comando.class);
        assertNotNull(pokemon.habilitarComandoSiVive(comando));

        Estado estado = mock(Estado.class);
        pokemon.curarEstado(estado);

    }



    @Test
    public void testAplicar() {

        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon atacante = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        pokemonBuilder = new PokemonBuilder();
        Pokemon defensor = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        // Configurar el comportamiento del mock de Habilidad para armar un Comando
        Habilidad habilidadMock = mock(Habilidad.class);
        Comando comandoMock = mock(Comando.class);
        when(habilidadMock.armarComando(defensor, atacante.getEstadisticas())).thenReturn(comandoMock);

        // Probar el método aplicar
        assertTrue( atacante.aplicar(defensor, 1));
    }


    @Test
    public void testRecibirDanio() {
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();

        Double vidaInicio=pokemon.vida();

        // Probar el método recibirDanio
        pokemon.recibirDanio(10.0,"mensaje");
        assertNotEquals(vidaInicio, pokemon.vida());
    }




}
