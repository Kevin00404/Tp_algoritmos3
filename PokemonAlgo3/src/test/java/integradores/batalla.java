package integradores;

import org.example.Clima.ManejoDeClima;
import org.example.Elemento.*;
import org.example.Entrenador;
import org.example.Estadisticas.EstadisticaPokemon;
import org.example.Estadisticas.Estadisticas;
import org.example.Eventos.Eventos;
import org.example.Log.Log;
import org.example.habilidad.Habilidad;
import org.example.items.*;
import org.example.jugada.Jugada;
import org.example.jugada.JugadaFactory;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;
import org.example.pokemon.PokemonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class batalla {

        private Entrenador entrenador;
        private Pokebola pokebola;
        private Mochila mochila;


          @Test
    void batalla() {
          Entrenador entrenador1= crearEntrenador();
              Entrenador entrenador2= crearEntrenador();

              entrenador1.cambiarPokemonActual();


              entrenador2.cambiarPokemonActual();



              // Turno de entrenador1
              entrenador1.efectosPasivos();
          turnoJugador(entrenador1, entrenador2);


              assertFalse(entrenador1.murio());
              assertFalse(entrenador2.murio());



              System.out.println("a");

             // ManejoDeClima.getTerreno().aplicarDanioTerreno(entrenador1,entrenador2);

//              // Turno de entrenador2
//              entrenador2.efectosPasivos();
//              turnoJugador(entrenador2, entrenador1);
//              //verificar si se rindio
//              if (entrenador2.murio()){
//                  break;
//              }
//              // Verificar si entrenador1 sigue vivo
//              if (entrenador1.murio()) {
//                  Log.getLog().log("entrenador 1 ha perdido.");
//                  break;
//              }
//              ManejoDeClima.getTerreno().aplicarDanioTerreno(entrenador1,entrenador2);
          }




    public void turnoJugador(Entrenador jugador, Entrenador oponente) {
        jugador.actualizarPokemonActual();
        boolean pasarTurno = false;
        JugadaFactory jugadaFactory = new JugadaFactory(jugador, oponente);
        while(!pasarTurno){
            Jugada jugada = jugadaFactory.inicializarJugada();
            pasarTurno = jugada.jugar();
            Eventos.getEventos().ejecutarEvento();
        }
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
