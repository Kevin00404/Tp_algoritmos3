package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ElegirPokemonController implements Initializable {
    //TODO hcer 5 funbciones para ocntrolar dependiendo dde que pokemon se debe cambiar.

    private Stage stage;

    private String nombnrePokemonActual;

    public ListView<String> lista_pokemones;
    public HashMap<String, ProgressBar> barras_vida_pokemones;

    ArrayList<String> pokemones;
    @FXML
    public Label nombre1;
    @FXML
    public Label nombre2;
    @FXML
    public Label nombre3;
    @FXML
    public Label nombre4;
    @FXML
    public Label nombre5;
    public List<String> pokemonesDisponibles;
    private ManejadorDeDatosBatalla manejador;

    //@FXML
    //public Label nombreActual;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void inicializarDataPokemones(HashMap<String, ProgressBar> barras_vida_pokemones,ArrayList<String> pokemones){
        this.barras_vida_pokemones=barras_vida_pokemones;
        this.pokemones=pokemones;
        setearBotonesNombres_Barras_nivelVida();

    }


    public void setearBotonesNombres_Barras_nivelVida(){
        String nombre_actual=manejador.getNombrePokemonAtacante();


        List<String> resultadoFiltrado = pokemones.stream()
                .filter(s -> !s.contains(nombre_actual))
                .collect(Collectors.toList());
        System.out.println(resultadoFiltrado);


        this.nombre1.setText(resultadoFiltrado.get(0));
        this.nombre2.setText(resultadoFiltrado.get(1));
        this.nombre3.setText(resultadoFiltrado.get(2));
        this.nombre4.setText(resultadoFiltrado.get(3));
        this.nombre5.setText(resultadoFiltrado.get(4));

        //actualizo lista solo los pokemones disponibles
        this.pokemonesDisponibles=resultadoFiltrado;
    }

    public void setearBarras_y_NivelVida(){

    }




    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void clickBotonPrimero() throws IOException {
        cambiarEscenaConfirmarCambioPokemon(pokemonesDisponibles.get(0));

    }
    @FXML
    public void clickBotonSegundo() throws IOException {
        cambiarEscenaConfirmarCambioPokemon(pokemonesDisponibles.get(1));

    }
    @FXML
    public void clickBotonTercero() throws IOException {
        cambiarEscenaConfirmarCambioPokemon(pokemonesDisponibles.get(2));

    }
    @FXML
    public void clickBotonCuarto() throws IOException {
        cambiarEscenaConfirmarCambioPokemon(pokemonesDisponibles.get(4));

    }
    @FXML
    public void clickBotonQuinto() throws IOException {
        cambiarEscenaConfirmarCambioPokemon(pokemonesDisponibles.get(5));
    }




    private void cambiarEscenaConfirmarCambioPokemon(String nombreNBuevoPOkemonActual) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("confirmacionCambiarPokemon.fxml"));
        Parent root = fxmlloader.load();
        ConfirmacionCambiarPokemonController cambiarPokemonConfirmar = fxmlloader.getController();
        cambiarPokemonConfirmar.setPrimaryStage(this.stage);
        cambiarPokemonConfirmar.setManejador(this.manejador);


        cambiarPokemonConfirmar.inicializarDataDeFondo(nombreNBuevoPOkemonActual);

        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.setTitle("Confirmacion");
        this.stage.show();
    }

    public void setManejador(ManejadorDeDatosBatalla manejador) {
        this.manejador = manejador;
    }


//    @FXML
//    public void clickBotonSegundo() throws IOException {
//        if(clickContador < 2) {
//            juego.cambiarPokemonEntrenadorUno(b_pok_2.getText());
//            inicializarDataSegundoJugador();
//        } else {
//            juego.cambiarPokemonEntrenadorDos(b_pok_2.getText());
//            cambiarEscenaBatalla();
//        }
//    }
//    @FXML
//    public void clickBotonTercero() throws IOException {
//        if(clickContador < 2) {
//            juego.cambiarPokemonEntrenadorUno(b_pok_3.getText());
//            inicializarDataSegundoJugador();
//        } else {
//            juego.cambiarPokemonEntrenadorDos(b_pok_3.getText());
//            cambiarEscenaBatalla();
//        }
//    }
//
//
//    @FXML
//    public void clickBotonCuarto() throws IOException {
//        if(clickContador < 2) {
//            System.out.println("Pokemon que se va a ingresar: " + b_pok_4.getText());
//            juego.cambiarPokemonEntrenadorUno(b_pok_4.getText());
//            inicializarDataSegundoJugador();
//        } else {
//            juego.cambiarPokemonEntrenadorDos(b_pok_4.getText());
//            cambiarEscenaBatalla();
//        }
//    }
//    @FXML
//    public void clickBotonQuinto() throws IOException {
//            juego.cambiarPokemonEntrenadorUno(b_pok_5.getText());
//            inicializarDataSegundoJugador();
//        }
//    }

}
