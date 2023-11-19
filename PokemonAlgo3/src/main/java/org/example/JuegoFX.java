package org.example;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JuegoFX extends Application {

    public static Stage stage;
    public static Scene scene;

    @FXML
    public Label presentar_pokemones;
    @FXML
    public Button b_pok_1;
    @FXML
    public Button b_pok_2;
    @FXML
    public Button b_pok_3;
    @FXML
    public Button b_pok_4;
    @FXML
    public Button b_pok_5;
    private Juego juego;

    private static EntrenadorController entrenadorController;

    public JuegoFX(){
        entrenadorController = new EntrenadorController();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    public void setJuego(Juego juego){
        this.juego = juego;
    }

    public void guardarEntrenadorUno(String nombreIngresado) {
        Entrenador entrenador_uno = juego.crearEntrenador1(nombreIngresado);
        entrenadorController.setEntrenadorUno(entrenador_uno);
    }

    public void guardarEntrenadorDos(String nombreIngresado) {
        Entrenador entrenador_dos = juego.crearEntrenador2(nombreIngresado);
        entrenadorController.setEntrenadorDos(entrenador_dos);
    }

    public void crearEscenaPedidoPokemonActual(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("PedidoPokemonActual.fxml"));
        scene = new Scene(fxmlloader.load(), 1920, 1080);

    }

    @FXML
    public void initialize() {
        String nombre_entrenador_uno = entrenadorController.getEntrenador1Nombre();
        ArrayList<String> listaPokemones = entrenadorController.getListaPokemonesActualesEntrenadorUno();
        System.out.println("Seteo el label de presentar pokemones");
        presentar_pokemones.setText(nombre_entrenador_uno + ", por favor ingrese el pokemon con el que quiere empezar");
        b_pok_1.setText(listaPokemones.get(0));
        b_pok_2.setText(listaPokemones.get(1));
        b_pok_3.setText(listaPokemones.get(2));
        b_pok_4.setText(listaPokemones.get(3));
        b_pok_5.setText(listaPokemones.get(4));
        stage.setScene(scene);
        stage.show();
    }
}
