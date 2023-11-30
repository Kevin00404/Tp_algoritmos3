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

    @FXML
    public void noSeUsaJSON() throws IOException {

        Soundtrack.getSonido().reproducirClick();

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("preguntar_primer_jugador_nombre.fxml"));
        Parent root = fxmlloader.load();

        PedirNombresController pedirNombres = fxmlloader.getController();
        pedirNombres.setPrimaryStage(this.stage);
        pedirNombres.setJuego(new Juego());
        Scene scene = new Scene(root);


        this.stage.setScene(scene);
        this.stage.setTitle("Pidiendo Nombre");
        this.stage.show();


    }

    @FXML
    public void iniciarPartida() throws IOException {

        Soundtrack.getSonido().reproducirClick();

        Juego juego = new Juego();
        juego = juego.iniciarJuegoConJSON("Partida.json");

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("PedidoPokemonActual.fxml"));

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

}
