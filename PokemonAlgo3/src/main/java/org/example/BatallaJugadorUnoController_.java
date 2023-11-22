package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class BatallaJugadorUnoController_ {
    private Stage stage;
    private Juego juego;
    @FXML
    public Text info_juego;
    @FXML
    public Button atacar;
    @FXML
    public Button cambiar_pokemon;
    @FXML
    public Button mochila_;
    @FXML
    public Button rendirse;
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

    public HashMap<String, ProgressBar> barras_vida_pokemones;


    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void inicializarDatosdeBatalla() {

        crear_barras_de_vida();
        nombre_jugador_actual.setText(juego.getEntrenadorUnoNombre());
        nombre_jugador_no_actual.setText(juego.getEntrenadorDosNombre());
        info_juego.setText(nombre_jugador_actual.getText() + ", ¿qué deseas hacer?");

       ///////////////////////// manejo_barra_vida_turno();

        //Se asigna que las barras en vista sean las del juego:
      //////////////////  barra_vida_actual=barras_vida_pokemones.get(juego.getNombrePokemonAtacante());
     ////////////////   barra_vida_actual=barras_vida_pokemones.get(juego.getNombrePokemon_a_Atacar());


    }
    //////////Descomentar una vez arreglado que al llegar a esta escena ya estan seteados lso entrenadores con su pokemon actual.
//    private void manejo_barra_vida_turno(){
//        Double vida_actual=juego.getVidaPokemonAtacante();
//        Double vida_max=barras_vida_pokemones.get(juego.getNombrePokemonAtacante()).getMaxHeight();
//        cant_vida.setText(vida_actual+"/"+vida_max);
//    }
////////////////////////////////

//Crea un mapa del estilo <NombrePOkemon, barra_de_Vida>  con la barra de vida maxima segun la vida con la que inica cada Pokemon.
        private void crear_barras_de_vida() {
            HashMap<String,Double> dicc_vidasMax=juego.entrenador1.diccionario_Pokemon_vidaMax();
            dicc_vidasMax=juego.entrenador1.diccionario_Pokemon_vidaMax();

            barras_vida_pokemones = new HashMap<String, ProgressBar>();

            for (HashMap.Entry<String,Double> entry : dicc_vidasMax.entrySet()) {
                ProgressBar barra_vida=new ProgressBar();
                barra_vida.setMaxHeight(entry.getValue());
                barras_vida_pokemones.put(entry.getKey(),barra_vida);
            }

            dicc_vidasMax=juego.entrenador2.diccionario_Pokemon_vidaMax();
            for (HashMap.Entry<String,Double> entry : dicc_vidasMax.entrySet()) {
                ProgressBar barra_vida=new ProgressBar();
                barra_vida.setMaxHeight(entry.getValue());
                barras_vida_pokemones.put(entry.getKey(),barra_vida);
            }
    }



    //Manejo de Botones:
    @FXML
    public void clickCambiarPokemon() throws IOException {
        System.out.println("entro");
        try {
            activarEscenaCambiarPokemon();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void activarEscenaCambiarPokemon() throws IOException{
        System.out.println(1444);
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("elegirPokemon.fxml"));
        System.out.println(1222);
        Parent root = fxmlloader.load();
        System.out.println(1);

        ElegirPokemonController elegirPokemones = fxmlloader.getController();
        elegirPokemones.setPrimaryStage(this.stage);
        elegirPokemones.setJuego(this.juego);
        System.out.println(333);
        elegirPokemones.inicializarDataPokemones();
        System.out.println(2);
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.setTitle("Batalla");
        this.stage.show();
    }

    @FXML
    public void activarEscenaRendirse() throws IOException {
        try {
            activarEscenaRendirse_();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void activarEscenaRendirse_()throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("confirmacionRendirse.fxml"));
        //Aqui se guardan los atributos
        Parent root = fxmlloader.load();

        ConfirmarRendirseController confirmar_rendirse = fxmlloader.getController();
        confirmar_rendirse.setPrimaryStage(this.stage);
        confirmar_rendirse.setJuego(this.juego);
        //confirmar_rendirse.inicializarDataEscenaConfirmarRedirse();  //Carga los datos de imagenes y nombres correctos

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("Pidiendo Pokemon");
        this.stage.show();




    }



}
