package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PantallaDeVictoriaController {

    @FXML
    public Button salirDelJuego;
    @FXML
    public Label labelVictoria;
    @FXML
    public ImageView imagenDefault;
    @FXML
    public ImageView fondo;


    public void setPantallaVictoria(String entrenadorContrarioNombre) {

        labelVictoria.setText("Felicidades " + entrenadorContrarioNombre + " ha ganado la batalla");

    }

    @FXML
    public void salir(){
        System.exit(0);
    }
}
