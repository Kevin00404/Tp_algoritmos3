package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PedirPokemonController {
    private Stage stage;
    private Juego juego;

    @FXML
    public Label presentar_pokemones;
    @FXML
    public Button b_pok_1;
    @FXML
    public Button b_pok_2;
    @FXML
    public Button b_pok_3;
    @FXML
    public Button b_pok_4;
    @FXML
    public Button b_pok_5;

    public Integer clickContador;


    public void inicializarDataSegundoJugador(){
        ArrayList<String> listaPokemones = juego.getPokemonesPokebolaDos();
        presentar_pokemones.setText(this.juego.getEntrenadorDosNombre() + ", por favor ingrese el pokemon con el que quiere empezar");
        b_pok_1.setText(listaPokemones.get(0));
        b_pok_2.setText(listaPokemones.get(1));
        b_pok_3.setText(listaPokemones.get(2));
        b_pok_4.setText(listaPokemones.get(3));
        b_pok_5.setText(listaPokemones.get(4));

    }
    @FXML
    public void clickBotonPrimero() throws IOException {
        clickContador+=1;
        if(clickContador < 2) {
            juego.cambiarPokemonEntrenadorUno(b_pok_1.getText());
            inicializarDataSegundoJugador();
        } else {
            juego.cambiarPokemonEntrenadorDos(b_pok_1.getText());
            cambiarEscenaBatalla();
        }
    }
    @FXML
    public void clickBotonSegundo() throws IOException {
        clickContador+=1;
        if(clickContador < 2) {
            juego.cambiarPokemonEntrenadorUno(b_pok_2.getText());
            inicializarDataSegundoJugador();
        } else {
            juego.cambiarPokemonEntrenadorDos(b_pok_2.getText());
            cambiarEscenaBatalla();
        }
    }
    @FXML
    public void clickBotonTercero() throws IOException {
        clickContador+=1;
        if(clickContador < 2) {
            juego.cambiarPokemonEntrenadorUno(b_pok_3.getText());
            inicializarDataSegundoJugador();
        } else {
            juego.cambiarPokemonEntrenadorDos(b_pok_3.getText());
            cambiarEscenaBatalla();
        }
    }


    @FXML
    public void clickBotonCuarto() throws IOException {
        clickContador+=1;
        if(clickContador < 2) {
            juego.cambiarPokemonEntrenadorUno(b_pok_4.getText());
            inicializarDataSegundoJugador();
        } else {
            juego.cambiarPokemonEntrenadorDos(b_pok_4.getText());
            cambiarEscenaBatalla();
        }
    }
    @FXML
    public void clickBotonQuinto() throws IOException {
        clickContador+=1;
        if(clickContador < 2) {
            juego.cambiarPokemonEntrenadorUno(b_pok_5.getText());
            inicializarDataSegundoJugador();
        } else {
            juego.cambiarPokemonEntrenadorDos(b_pok_5.getText());
            cambiarEscenaBatalla();
        }
    }


    private void cambiarEscenaBatalla() throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("batalla_uno.fxml"));
        Parent root = fxmlloader.load();
        BatallaJugadorUnoController_ batallaUno = fxmlloader.getController();
        batallaUno.setPrimaryStage(this.stage);
        batallaUno.setJuego(this.juego);
        batallaUno.inicializarDatosdeBatalla();



        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        batallaUno.setScene(scene);

        batallaUno.guardarEscenaBatalla(this.stage,scene);

        this.stage.setTitle("Batalla");
        this.stage.show();
    }

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void inicializarDataPrimerJugador() {
        clickContador = 0;
        ArrayList<String> listaPokemones = juego.getPokemonesPokebolaUno();
        System.out.println("Seteo el label de presentar pokemones");
        presentar_pokemones.setText(this.juego.getEntrenadorUnoNombre() + ", por favor ingrese el pokemon con el que quiere empezar");
        b_pok_1.setText(listaPokemones.get(0));
        b_pok_2.setText(listaPokemones.get(1));
        b_pok_3.setText(listaPokemones.get(2));
        b_pok_4.setText(listaPokemones.get(3));
        b_pok_5.setText(listaPokemones.get(4));
    }
}
