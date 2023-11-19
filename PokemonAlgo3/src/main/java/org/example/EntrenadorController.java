package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class EntrenadorController extends Application {
    private static Entrenador entrenador_uno;
    private Entrenador entrenador_dos;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }


    public void setEntrenadorUno(Entrenador entrenador) {
        if(entrenador != null){System.out.println("Entrenador uno fue guardado");}
        entrenador_uno = entrenador;
    }
    public void setEntrenadorDos(Entrenador entrenador) {
        this.entrenador_dos = entrenador;
    }

    public String getEntrenador1Nombre() {
        return this.entrenador_uno.getNombre();
    }

    public ArrayList<String> getListaPokemonesActualesEntrenadorUno() {
        return this.entrenador_uno.listaPokemones();
    }
}
