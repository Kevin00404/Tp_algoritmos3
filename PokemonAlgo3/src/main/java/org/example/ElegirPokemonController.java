package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ElegirPokemonController implements Initializable {
    private Stage stage;
    private Juego juego;
    @FXML
    private ListView<String> lista_pokemones;

    String[] pokemones;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista_pokemones.getItems().addAll(pokemones);

    }

    public void inicializarDataPokemones(){
        juego.getPokemonesPokebolaUno().toArray(pokemones);
    }

    public void setPrimaryStage(Stage stage) {this.stage = stage;
    }
    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
