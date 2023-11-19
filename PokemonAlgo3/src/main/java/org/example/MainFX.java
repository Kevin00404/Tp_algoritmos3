package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {



    @FXML
    public TextField nombre_jugador_1;
    public static JuegoFX juegofx;

    @FXML
    public Label pregunta_nombre_label;
    @FXML
    public Button boton_de_envio;

    private static Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primeStage) throws IOException {
        juegofx = new JuegoFX();
        stage = primeStage;
        escenaPreguntaEntrenadorUno();

        /*juego.iniciar_Juego();*/
    }

    public void escenaPreguntaEntrenadorUno() throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("preguntar_primer_jugador_nombre.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 1000, 1000);
        stage.setScene(scene);
        stage.show();
        Juego juego = new Juego();
        juegofx.setJuego(juego);
    }

    public void escenaPreguntaEntrenadorDos() {
        pregunta_nombre_label.setText("Por favor, seleccione el nombre del entrenador (Jugador 2): ");
        boton_de_envio.setOnAction(e -> {
            try {
                enviarNombreSegundoAlClickear();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println("Se setea nueva accion en el boton");
    }

    @FXML
    public void enviarNombrePrimeroAlClickear(ActionEvent event){
        String nombre_ingresado = nombre_jugador_1.getText();
        juegofx.guardarEntrenadorUno(nombre_ingresado);
        escenaPreguntaEntrenadorDos();
    }

    @FXML
    public void enviarNombreSegundoAlClickear() throws IOException {
        String nombre_ingresado = nombre_jugador_1.getText();
        juegofx.guardarEntrenadorDos(nombre_ingresado);
        crearEscenaPedidoPokemon();
    }

    @FXML
    public void crearEscenaPedidoPokemon() throws IOException {
        juegofx.crearEscenaPedidoPokemonActual(stage);
    }
}
