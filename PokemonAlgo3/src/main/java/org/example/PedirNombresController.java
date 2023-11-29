package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PedirNombresController {

    @FXML
    public TextField nombre_jugador_1;
    @FXML
    public Label pregunta_nombre_label;
    @FXML
    public Button boton_de_envio;
    private Stage stage;
    private Juego juego;
    public void setPrimaryStage(Stage primaryStage){
        this.stage = primaryStage;
    }

    @FXML
    public void clickBoton() throws IOException {

        Soundtrack.getSonido().reproducirClick();

        String nombre_ingresado = nombre_jugador_1.getText();
        this.juego.setEntrenador1(juego.crearEntrenador1(nombre_ingresado));
        nombre_jugador_1.clear();
        pregunta_nombre_label.setText("Por favor, seleccione el nombre del entrenador (Jugador 2): ");
        boton_de_envio.setOnAction(e -> {
            try {

                Soundtrack.getSonido().reproducirClick();

                activarEscenaPedirPokemon();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    @FXML
    public void activarEscenaPedirPokemon() throws IOException {
        String nombre_ingresado = nombre_jugador_1.getText();
        this.juego.setEntrenador2(juego.crearEntrenador2(nombre_ingresado));
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("PedidoPokemonActual.fxml"));
        //Aqui se guardan los atributos
        Parent root = fxmlloader.load();

        PedirPokemonController pedirPokemon = fxmlloader.getController();
        pedirPokemon.setPrimaryStage(this.stage);
        pedirPokemon.setJuego(this.juego);
        pedirPokemon.inicializarDataPrimerJugador();

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("Pidiendo Pokemon");
        this.stage.show();
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }


}
