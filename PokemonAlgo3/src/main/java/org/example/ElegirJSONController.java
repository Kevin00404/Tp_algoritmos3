package org.example;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.example.JSON.LeerArchivoJson;

import java.io.File;
import java.io.IOException;

public class ElegirJSONController {
    @FXML
    public Button noUsarJSON;
    @FXML
    public Button usarJSON;
    private Stage stage;
    private  Juego juego;

    /*@FXML
    public void noSeUsaJSON() throws IOException {
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
    }*/

    @FXML
    public void iniciarPartida() throws IOException {
        Juego juego = new Juego();
        juego = juego.iniciarJuegoConJSON("Partida.json");


        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("PedidoPokemonActual.fxml"));
        //Aqui se guardan los atributos
        Parent root = fxmlloader.load();

        PedirPokemonController pedirPokemon = fxmlloader.getController();
        pedirPokemon.setPrimaryStage(this.stage);
        pedirPokemon.setJuego(this.juego);
        pedirPokemon.inicializarDataPrimerJugador();

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("Pidiendo Pokemon");
        this.stage.show();

    }

    public void setPrimaryStage(Stage primeStage) {
        this.stage = primeStage;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    //audio

    /*@FXML
    public void reproducirAudio() {
        Media media = new Media(new File("audio/Track 1.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnEndOfMedia(() -> {
            // Esto se ejecuta cuando el audio llega al final
            System.out.println("paro la musica");
            mediaPlayer.stop();
        });

        mediaPlayer.play();
    }

    @FXML
    public void reproducir() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Media media = new Media(new File("audio/Track 1.wav").toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);

                mediaPlayer.setOnEndOfMedia(() -> {
                    // Esto se ejecuta cuando el audio llega al final
                    System.out.println("paro la musica");
                    mediaPlayer.stop();
                });

                mediaPlayer.play();
                return null;
            }
        };

        new Thread(task).start();
    }*/
}
