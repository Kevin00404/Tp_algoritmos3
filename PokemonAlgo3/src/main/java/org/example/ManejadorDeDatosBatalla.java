package org.example;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.example.Clima.ManejoDeClima;
import org.example.Estadisticas.Estadisticas;
import org.example.Eventos.Eventos;
import org.example.jugada.JugadaAtaque;
import org.example.pokemon.Pokemon;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class ManejadorDeDatosBatalla {

    Entrenador entrenador_actual;
    Entrenador entrenador_contrario;
    Juego juego;
    Pokemon pokemon_entrenador_actual;
    Pokemon pokemon_entrenador_contrario;
    Integer jugador_actual_num;
    Integer jugador_contrario_num;
    Estadisticas estadisticas_pokemon_actual;

    Estadisticas estadisticas_pokemon_contrario;


    public ManejadorDeDatosBatalla() {
        jugador_actual_num = 1;
        jugador_contrario_num = 2;
    }

    public Double getVidaPokemon(Integer nroEntrenador){
        return this.juego.getEntrenador(nroEntrenador).getPokemonActual().getEstadisticas().getVida();
    }

    public Double getMaxVidaPokemon(Integer nroEntrenador){
        return this.juego.getEntrenador(nroEntrenador).getPokemonActual().getEstadisticas().getMaxVida();
    }

    public void ordenarData(Juego juego) {
        this.juego = juego;
        entrenador_actual = this.juego.getEntrenador(jugador_actual_num);
        entrenador_contrario = this.juego.getEntrenador(jugador_contrario_num);
        pokemon_entrenador_actual = entrenador_actual.getPokemonActual();
        pokemon_entrenador_contrario = entrenador_contrario.getPokemonActual();
        estadisticas_pokemon_actual = pokemon_entrenador_actual.getEstadisticas();
        estadisticas_pokemon_contrario = pokemon_entrenador_contrario.getEstadisticas();
    }

    public HashMap<String, Double> getVidaMaximaJugadorActual() {
        return entrenador_actual.diccionario_Pokemon_vidaMax();
    }

    public HashMap<String, Double> getVidaMaximaJugadorContrario() {
        return entrenador_contrario.diccionario_Pokemon_vidaMax();
    }

    public String getNombrePokemonAtacante() {
        return pokemon_entrenador_actual.getNombre();
    }

    public String getNombrePokemonContrario() {
        return pokemon_entrenador_contrario.getNombre();
    }

    public Double getVidaPokemonAtacante() {
        return estadisticas_pokemon_actual.getVida();
    }

    public Double getVidaPokemonContrario() {
        return estadisticas_pokemon_contrario.getVida();
    }

    public String getEntrenadorActualNombre() {
        return entrenador_actual.getNombre();
    }

    public String getEntrenadorContrarioNombre() {
        return entrenador_contrario.getNombre();
    }

    public ArrayList<String> getPokemonesPokebolaJugadorActual() {
        return entrenador_actual.listaPokemones();
    }

    public void cambiaPokemon(String nombreNuevoPokemonActual) {
        entrenador_actual.cambiarPokemonActual(nombreNuevoPokemonActual);
    }

    public Entrenador getEntrenador_actual() {
        return entrenador_actual;
    }

    public void cambiarJugadores(ProgressBar barraAtacante, ProgressBar barraOponente, Text jugadorActual, Text jugadorContrario){
        if (jugador_actual_num == 1 && jugador_contrario_num == 2){
            jugador_actual_num = 2;
            jugador_contrario_num = 1;
        } else {
            jugador_actual_num = 1;
            jugador_contrario_num = 2;
        }
        cambiarBarrasDeLugares(barraAtacante, barraOponente);
        cambiarLabelsDeLugar(jugadorActual, jugadorContrario);
        ordenarData(this.juego);
    }

    private void cambiarLabelsDeLugar(Text jugadorActual, Text jugadorContrario) {
        jugadorActual.setText(this.entrenador_contrario.getNombre());
        jugadorContrario.setText(this.entrenador_actual.getNombre());
    }

    private void cambiarBarrasDeLugares(ProgressBar barraAtacante, ProgressBar barraOponente) {
        if (barraAtacante.getLayoutX() >= 303.0){
            barraAtacante.setLayoutX(237.0);
            barraAtacante.setLayoutY(37.0);
        } else {
            barraAtacante.setLayoutX(304.0);
            barraAtacante.setLayoutY(214.0);
        }
        if (barraOponente.getLayoutX() <= 238.0){
            barraOponente.setLayoutX(304.0);
            barraOponente.setLayoutY(214.0);
        } else {
            barraOponente.setLayoutX(237.0);
            barraOponente.setLayoutY(37.0);
        }
    }


    public Estadisticas getEstadisticasPokemonActual() {
        return estadisticas_pokemon_actual;
    }

    public void cargarHabilidades(Button h1, Button h2, Button h3, Button h4) {
        h1.setText(pokemon_entrenador_actual.getPrimeraHabilidad());
        h2.setText(pokemon_entrenador_actual.getSegundaHabilidad());
        h3.setText(pokemon_entrenador_actual.getTerceraHabilidad());
        h4.setText(pokemon_entrenador_actual.getCuartaHabilidad());
    }

    public void ejecutarHabilidadUno() throws InterruptedException {
        JugadaAtaque jugada = new JugadaAtaque(entrenador_actual, entrenador_contrario);
        jugada.setHabilidad(1);
        jugada.jugar();
        Eventos.getEventos().ejecutarEvento();
    }

    public void ejecutarHabilidadDos() throws InterruptedException {
        JugadaAtaque jugada = new JugadaAtaque(entrenador_actual, entrenador_contrario);
        jugada.setHabilidad(2);
        jugada.jugar();
        Eventos.getEventos().ejecutarEvento();
    }

    public void ejecutarHabilidadTres() throws InterruptedException {
        JugadaAtaque jugada = new JugadaAtaque(entrenador_actual, entrenador_contrario);
        jugada.setHabilidad(3);
        jugada.jugar();
        Eventos.getEventos().ejecutarEvento();
    }

    public void ejecutarHabilidadCuatro() throws InterruptedException {
        JugadaAtaque jugada = new JugadaAtaque(entrenador_actual, entrenador_contrario);
        jugada.setHabilidad(4);
        jugada.jugar();
        Eventos.getEventos().ejecutarEvento();
    }

    public double getMaxVidaPokemonAtacante() {
        return estadisticas_pokemon_actual.getMaxVida();
    }

    public double getMaxVidaPokemonContrario() {
        return estadisticas_pokemon_contrario.getMaxVida();
    }

    public void setearEstados(ImageView paralizadoAtacante, ImageView venenoAtacante, ImageView zzzAtacante, ImageView confusoAtacante, ImageView paralizadoContrario, ImageView venenoContrario, ImageView zzzContrario, ImageView confusoContrario) {
        if (pokemon_entrenador_actual.getEstado().existeEstadoParalizado()) {
            paralizadoAtacante.setVisible(true);
        } else {
            paralizadoAtacante.setVisible(false);
        }
        if (pokemon_entrenador_actual.getEstado().existeEstadoDormido()) {
            zzzAtacante.setVisible(true);
        } else {
            zzzAtacante.setVisible(false);
        }
        if (pokemon_entrenador_actual.getEstado().existeEstadoConfuso()) {
            confusoAtacante.setVisible(true);
        } else {
            confusoAtacante.setVisible(false);
        }
        if (pokemon_entrenador_actual.getEstado().existeEstadoEnvenenado()) {
            venenoAtacante.setVisible(true);
        } else {
            venenoAtacante.setVisible(false);
        }
        if (pokemon_entrenador_contrario.getEstado().existeEstadoEnvenenado()) {
            venenoContrario.setVisible(true);
        } else {
            venenoContrario.setVisible(false);
        }
        if (pokemon_entrenador_contrario.getEstado().existeEstadoParalizado()) {
            paralizadoContrario.setVisible(true);
        } else {
            paralizadoContrario.setVisible(false);
        }
        if (pokemon_entrenador_contrario.getEstado().existeEstadoConfuso()) {
            confusoContrario.setVisible(true);
        } else {
            confusoContrario.setVisible(false);
        }
        if (pokemon_entrenador_contrario.getEstado().existeEstadoDormido()) {
            zzzContrario.setVisible(true);
        } else {
            zzzContrario.setVisible(false);
        }
    }

    public void ejecutarPasivos() {
        ManejoDeClima.getTerreno().aplicarDanioTerreno(entrenador_actual,entrenador_contrario);
        entrenador_contrario.efectosPasivos();
    }

    public String analizarMuertos() {
        if(entrenador_actual.murio()){
            return entrenador_contrario.getNombre();
        }
        if(entrenador_contrario.murio()){
            return entrenador_actual.getNombre();
        }
        return null;
    }

    public boolean pokemon_entrenador_actual_murio() {
        return estadisticas_pokemon_actual.getVida() <= 0;
    }

    public void matarPokemonActual() {
        this.estadisticas_pokemon_actual.setVida(-1);
    }

    public void matarPokemonContrario() {
        this.estadisticas_pokemon_contrario.setVida(-1);
    }

    public void cambiarClima(ImageView despejado, ImageView huracan, ImageView soleado, ImageView niebla, ImageView lluvia, ImageView tormentaDeArena, ImageView tormentaDeRayo, ImageView granizo) {
        desaparecerTodos(despejado, huracan, soleado, niebla, lluvia, tormentaDeArena, tormentaDeRayo, granizo);
        if (ManejoDeClima.getClima() == "Despejado"){  despejado.setVisible(true);  }
        if (ManejoDeClima.getClima() == "Granizo"){  granizo.setVisible(true);  }
        if (ManejoDeClima.getClima() == "Huracan"){  huracan.setVisible(true);  }
        if (ManejoDeClima.getClima() == "Lluvia"){  lluvia.setVisible(true);  }
        if (ManejoDeClima.getClima() == "Niebla"){  niebla.setVisible(true);  }
        if (ManejoDeClima.getClima() == "Soleado"){  soleado.setVisible(true);  }
        if (ManejoDeClima.getClima() == "Tormenta de Arena"){  tormentaDeArena.setVisible(true);  }
        if (ManejoDeClima.getClima() == "Tormenta de rayos"){  tormentaDeRayo.setVisible(true);  }
        ManejoDeClima.getTerreno().aplicarDanioTerreno(entrenador_actual,entrenador_contrario);
    }

    private void desaparecerTodos(ImageView despejado, ImageView huracan, ImageView soleado, ImageView niebla, ImageView lluvia, ImageView tormentaDeArena, ImageView tormentaDeRayo, ImageView granizo) {
        despejado.setVisible(false);
        huracan.setVisible(false);
        soleado.setVisible(false);
        niebla.setVisible(false);
        tormentaDeArena.setVisible(false);
        tormentaDeRayo.setVisible(false);
        lluvia.setVisible(false);
        granizo.setVisible(false);

    }
}
