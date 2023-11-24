package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.Elemento.*;
import org.example.habilidad.HabilidadAtaque;
import org.example.pokemon.Pokemon;

public class Main extends Application {
    public static void main(String[] args) {

        Juego juego = new Juego();
        juego.iniciar_Juego();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}