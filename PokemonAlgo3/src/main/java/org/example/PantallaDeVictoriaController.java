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
    public Label labelvictoria2;
    @FXML
    public ImageView imagenDefault;
    @FXML
    public ImageView fondo;




    @FXML
    public MediaView mediaView;
    public File file;
    public Media media;
    public MediaPlayer mediaplayer;


    private Juego juego;


    public void inicilaizar(){
        file = new File ("video/videoCreditos.mp4");
        media = new Media(file.toURI().toString());
        mediaplayer=new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaplayer);

        mediaplayer.play();

    }




    public void setPantallaVictoria(String entrenadorContrarioNombre) {
        Soundtrack.getSonido().reproducirVictoria();
        labelVictoria.setText("Felicidades " + entrenadorContrarioNombre + " ha ganado la batalla");
        labelvictoria2.setText("Felicidades " + entrenadorContrarioNombre + " ha ganado la batalla");
        LeerArchivoJson json = new LeerArchivoJson();
        json.crearInforme(this.juego, entrenadorContrarioNombre);
        inicilaizar();

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
