package integradores;

import org.example.Elemento.*;
import org.example.Entrenador;
import org.example.items.*;
import org.example.jugada.*;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.example.pokemon.PokemonBuilder;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class jugadaTest {
    @Test
    public void jugarValido(){
        Entrenador entreanador1 =crearEntrenador();
        Entrenador entreanador2 =crearEntrenador();

        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon1 = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador1.setPokemonActual(pokemon1);

        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon2 = pokemonBuilder.setNombre("Pikachu").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador2.setPokemonActual(pokemon2);



        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        JugadaAtaque jugadaAtaque=new JugadaAtaque(entreanador1,entreanador2);


        assertTrue(jugadaAtaque.jugar());

    }

    @Test
    public void jugarInValido(){
        Entrenador entreanador1 =crearEntrenador();
        Entrenador entreanador2 =crearEntrenador();

        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon1 = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador1.setPokemonActual(pokemon1);

        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon2 = pokemonBuilder.setNombre("Pikachu").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador2.setPokemonActual(pokemon2);



        String input = "6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        JugadaAtaque jugadaAtaque=new JugadaAtaque(entreanador1,entreanador2);


        assertFalse(jugadaAtaque.jugar());
    }

    @Test
    public void  JugadaItem(){
        Entrenador entreanador1 =crearEntrenador();
        Entrenador entreanador2 =crearEntrenador();

        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon1 = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador1.setPokemonActual(pokemon1);

        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon2 = pokemonBuilder.setNombre("Pikachu").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador2.setPokemonActual(pokemon2);



        String input = "6\nPikachu\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        JugadaItem jugada=new JugadaItem(entreanador1,entreanador2);

        assertTrue(jugada.jugar());
    }

    @Test
    public void   JugadaMirarCampo(){
        Entrenador entreanador1 =crearEntrenador();
        Entrenador entreanador2 =crearEntrenador();

        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon1 = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador1.setPokemonActual(pokemon1);

        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon2 = pokemonBuilder.setNombre("Pikachu").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador2.setPokemonActual(pokemon2);



        String input = "6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        JugadaMirarCampo jugadaMirarCampo=new JugadaMirarCampo(entreanador1,entreanador2);


        assertFalse(jugadaMirarCampo.jugar());
    }


    @Test
    public void   JugadaNoJugada(){
        Entrenador entreanador1 =crearEntrenador();
        Entrenador entreanador2 =crearEntrenador();

        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon1 = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador1.setPokemonActual(pokemon1);

        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon2 = pokemonBuilder.setNombre("Pikachu").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador2.setPokemonActual(pokemon2);



        String input = "6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        JugadaNoJugada jugadaNoJugada=new JugadaNoJugada(entreanador1,entreanador2);


        assertFalse(jugadaNoJugada.jugar());
    }

    @Test
    public void   JugadaRendicion(){
        Entrenador entreanador1 =crearEntrenador();
        Entrenador entreanador2 =crearEntrenador();

        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon1 = pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador1.setPokemonActual(pokemon1);

        pokemonBuilder = new PokemonBuilder();
        Pokemon pokemon2 = pokemonBuilder.setNombre("Pikachu").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon();


        entreanador2.setPokemonActual(pokemon2);



        String input = "6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        JugadaRendicion jugadaRendicion=new JugadaRendicion(entreanador1,entreanador2);


        assertTrue(jugadaRendicion.jugar());
    }

    private Entrenador crearEntrenador(){
        Mochila mochilaEntrenador = inicializarItems();
        PokemonBuilder pokemonBuilder = new PokemonBuilder();
        Entrenador entrenador = new Entrenador(new Pokebola(6) , mochilaEntrenador , "JugadorNombre");
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Charmander").setElemento(new Fuego()).setHistoria("Nacio en un volcan(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Squirtle").setElemento(new Agua()).setHistoria("Nacio en un Lago(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Pikachu").setElemento(new Electrico()).setHistoria("Hijo de los rayos").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Bulbasaur").setElemento(new Planta()).setHistoria("Nacio en un bosque(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Flygon").setElemento(new Dragon()).setHistoria("Nacio en el cielo(?").crearPokemon());
        pokemonBuilder = new PokemonBuilder();
        entrenador.capturarPokemon(pokemonBuilder.setNombre("Swellow").setElemento(new Volador()).setHistoria("Pollito de fuego").crearPokemon());
        return entrenador;
    }

    public Mochila inicializarItems(){
        CuraTotal curaTotal = new CuraTotal("cura total" , 1);
        PocionDespertarDormido despertar = new PocionDespertarDormido("despertar" , 1);
        PocionAntiVeneno antiVeneno = new PocionAntiVeneno("antiveneno" , 1);
        PocionCurarParalisis curarParalisis = new PocionCurarParalisis("antiparalisis" , 1);
        Pocion pocionBasica = new Pocion(20.0 ,"pocion basica" , 1);
        Pocion megaPocion = new Pocion(50.0 , "mega pocion" , 1);
        Pocion hiperPocion = new Pocion(100.0 , "hiper pocion" , 1);
        Revivir revivir = new Revivir(20.0 , "revivir" , 1);
        Revivir maxRevivir = new Revivir(100.0 , "max revivir" , 1);
        PocionDeAtaque ataqueX = new PocionDeAtaque("ataque x", 10.0 , 1);
        PocionDeDefensa defensaX = new PocionDeDefensa("defensa x" , 10.0 , 1);
        Mochila mochilaEntrenador = new Mochila();
        mochilaEntrenador.agregarObjeto(pocionBasica);
        mochilaEntrenador.agregarObjeto(megaPocion);
        mochilaEntrenador.agregarObjeto(hiperPocion);
        mochilaEntrenador.agregarObjeto(curaTotal);
        mochilaEntrenador.agregarObjeto(antiVeneno);
        mochilaEntrenador.agregarObjeto(despertar);
        mochilaEntrenador.agregarObjeto(curarParalisis);
        mochilaEntrenador.agregarObjeto(revivir);
        mochilaEntrenador.agregarObjeto(maxRevivir);
        mochilaEntrenador.agregarObjeto(ataqueX);
        mochilaEntrenador.agregarObjeto(defensaX);
        return mochilaEntrenador;
    }
}
