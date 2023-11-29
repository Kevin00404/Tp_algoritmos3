package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.JSON.LeerArchivoJson;

public class PantallaDeVictoriaController {

    @FXML
    public Button salirDelJuego;
    @FXML
    public Label labelVictoria;
    @FXML
    public ImageView imagenDefault;
    @FXML
    public ImageView fondo;

    private Juego juego;


    public void setPantallaVictoria(String entrenadorContrarioNombre) {
        Soundtrack.getSonido().reproducirVictoria();
        labelVictoria.setText("Felicidades " + entrenadorContrarioNombre + " ha ganado la batalla");
        LeerArchivoJson json = new LeerArchivoJson();
        json.crearInforme(this.juego, entrenadorContrarioNombre);
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
