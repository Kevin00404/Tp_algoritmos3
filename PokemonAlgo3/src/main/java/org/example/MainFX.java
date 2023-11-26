package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {



    @FXML
    public TextField nombre_jugador_1;

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
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("preguntar_primer_jugador_nombre.fxml"));
        Parent root = fxmlloader.load();

        //PedirNombresController es una clase que maneja la logica(modelo) de esta escena
        PedirNombresController pedirNombres = fxmlloader.getController();
        pedirNombres.setPrimaryStage(primeStage);
        pedirNombres.setJuego(new Juego());

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());



        primeStage.setScene(scene);
        primeStage.setTitle("Pidiendo Nombre");
        primeStage.show();
    }
}
