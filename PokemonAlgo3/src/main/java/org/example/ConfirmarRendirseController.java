package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfirmarRendirseController {
    private Stage stage;
    private Juego juego;
    @FXML
    public Text nombre_jugador_actual;
    @FXML
    public Text nombre_jugador_no_actual;
    @FXML
    public ProgressBar barra_vida_actual;
    @FXML
    public ProgressBar barra_vida_no_actual;
    @FXML
    public Text cant_vida;

    @FXML
    public void clickBotonSi(ActionEvent actionEvent) {
    }

    @FXML
    public void clickBotonNo(ActionEvent actionEvent) {
        
    }


    public void inicializarDataEscenaConfirmarRedirse(Text jugador_Actual, Text jugador_no_Actual,ProgressBar barra_vida_actual,ProgressBar barra_vida_no_actual,Text cant_vida){
        nombre_jugador_actual.setText(jugador_Actual.getText());
        nombre_jugador_no_actual.setText(jugador_no_Actual.getText());
        this.cant_vida.setText(cant_vida.getText());

        //TODO Verificar barras funciona
        this.barra_vida_actual=barra_vida_actual;
        this.barra_vida_no_actual=barra_vida_no_actual;
        //TODO Falta actualizar las imagenes segun los pokemones en batalla:
    }



    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }


}
