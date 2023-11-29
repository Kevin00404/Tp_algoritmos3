package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.example.JSON.LeerArchivoJson;

import java.io.File;

public class PantallaDeVictoriaController {

    @FXML
    public Button salirDelJuego;
    @FXML
    public Label labelVictoria;
    @FXML
    public ImageView imagenDefault;
    @FXML
    public ImageView fondo;
    @FXML
    public MediaView videoCreditos;

    private Juego juego;



    public void setPantallaVictoria(String entrenadorContrarioNombre) {
        Soundtrack.getSonido().reproducirVictoria();
        labelVictoria.setText("Felicidades " + entrenadorContrarioNombre + " ha ganado la batalla");
        LeerArchivoJson json = new LeerArchivoJson();
        json.crearInforme(this.juego, entrenadorContrarioNombre);

        Media video = new Media(new File("video/videoCreditos.mp4").toURI().toString());
        MediaPlayer videoCreditos = new MediaPlayer(video);
        this.videoCreditos = new MediaView(videoCreditos);
        videoCreditos.setAutoPlay(true);

    }

    public void setJuego(ManejadorDeDatosBatalla manejador){
        this.juego = manejador.juego;
    }
    @FXML
    public void salir(){

        Soundtrack.getSonido().reproducirClick();

        System.exit(0);
    }

}
