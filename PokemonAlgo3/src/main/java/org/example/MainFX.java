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
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainFX extends Application {



    @FXML
    public TextField nombre_jugador_1;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primeStage) throws IOException {
        inicializar(primeStage);

    }

    public void inicializar( Stage primeStage) throws IOException {

        primeStage.getIcons().add(new Image(new File("imagenes/icono.png").toURI().toString()));

        Juego juego = new Juego();
        juego = juego.iniciarJuegoConJSON("Partida.json");

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("elegirJSON.fxml"));
        Parent root = fxmlloader.load();

        ElegirJSONController json = fxmlloader.getController();
        json.setPrimaryStage(primeStage);
        json.setJuego(juego);


        Scene scene = new Scene(root);


        primeStage.setScene(scene);
        primeStage.setTitle("Pidiendo Nombre");
        primeStage.show();
        Soundtrack.getSonido().reproducirTitulo();

    }
}
