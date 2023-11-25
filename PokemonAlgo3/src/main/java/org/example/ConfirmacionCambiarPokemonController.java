package org.example;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ConfirmacionCambiarPokemonController {
    private Stage stage;

    private String nombreNuevoPokemonActual;
    private ManejadorDeDatosBatalla manejador;

    public void setPrimaryStage(Stage stage) {this.stage = stage;
    }

    public void inicializarDataDeFondo(String nombreNuevoPokemonActual) {
        this.nombreNuevoPokemonActual=nombreNuevoPokemonActual;
    }


    @FXML
    public void clickSiSeguro(){
        System.out.println(222);
            manejador.cambiaPokemon(this.nombreNuevoPokemonActual);
            System.out.println(manejador.getNombrePokemonAtacante());
    }
    @FXML
    public void clickNoSeguro(){
            //llamara a escena anterior
    }


    public void setManejador(ManejadorDeDatosBatalla manejador) {
        this.manejador = manejador;
    }
}
