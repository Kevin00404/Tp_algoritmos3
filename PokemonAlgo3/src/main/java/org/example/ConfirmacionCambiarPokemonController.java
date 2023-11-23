package org.example;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ConfirmacionCambiarPokemonController {
    private Stage stage;
    private Juego juego;

    private String nombreNuevoPokemonActual;
    public void setPrimaryStage(Stage stage) {this.stage = stage;
    }
    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void inicializarDataDeFondo(String nombreNuevoPokemonActual) {
        this.nombreNuevoPokemonActual=nombreNuevoPokemonActual;
    }


    @FXML
    public void clickSiSeguro(){
        System.out.println(222);
            juego.cambiaPokemonJugadorActual(this.nombreNuevoPokemonActual);
            System.out.println(juego.getPokemonActualNombre());
    }
    @FXML
    public void clickNoSeguro(){
            //llamara a escena anterior
    }




}
