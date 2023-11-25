package org.example;

import javafx.event.ActionEvent;
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
    @FXML
    public Button habilidad_uno_boton;
    @FXML
    public Button habilidad_dos_boton;
    @FXML
    public Button habilidad_tres_boton;
    @FXML
    public Button habilidad_cuatro_boton;

    public Stage escenaBatalla;
    public Scene escenaBatallaParametro;
    public ManejadorDeDatosBatalla manejador;

    public HashMap<String, ProgressBar> barras_vida_pokemones;


    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setJuego(Juego juego) {
        this.manejador = new ManejadorDeDatosBatalla();
        manejador.ordenarData(juego);
    }

    public void inicializarDatosdeBatalla() {
        crear_barras_de_vida();
        nombre_jugador_actual.setText(manejador.getEntrenadorActualNombre());
        nombre_jugador_no_actual.setText(manejador.getEntrenadorContrarioNombre());
        info_juego.setText(nombre_jugador_actual.getText() + ", ¿qué deseas hacer?");
        //Se asigna que las barras en vista sean las del juego: se guardan en un metodo weight que no tiene relacion con el valor real del progreso en el javaFX
        barra_vida_actual=barras_vida_pokemones.get(manejador.getNombrePokemonAtacante());
        barra_vida_actual=barras_vida_pokemones.get(manejador.getNombrePokemonContrario());
        manejo_barra_vida_turno();
    }

    private void manejo_barra_vida_turno(){
        Double vida_actual=manejador.getVidaPokemonAtacante();
        Double vida_max=barras_vida_pokemones.get(manejador.getNombrePokemonAtacante()).getMaxWidth();
        cant_vida.setText(vida_actual+"/"+vida_max);
        cant_vida.setText(String.format("%.2f", vida_actual)+"/"+String.format("%.2f", vida_max));
    }


//Crea un mapa del estilo <NombrePOkemon, barra_de_Vida>  con la barra de vida maxima segun la vida con la que inica cada Pokemon.
        private void crear_barras_de_vida() {
            //HashMap<String,Double> dicc_vidasMax=juego.entrenador1.diccionario_Pokemon_vidaMax();
            HashMap<String,Double> dicc_vidasMax=manejador.getVidaMaximaJugadorActual();

            barras_vida_pokemones = new HashMap<String, ProgressBar>();

            for (HashMap.Entry<String,Double> entry : dicc_vidasMax.entrySet()) {
                ProgressBar barra_vida=new ProgressBar();
                barra_vida.setMaxWidth(entry.getValue());
                barras_vida_pokemones.put(entry.getKey(),barra_vida);
            }
            dicc_vidasMax=manejador.getVidaMaximaJugadorContrario();
            for (HashMap.Entry<String,Double> entry : dicc_vidasMax.entrySet()) {
                ProgressBar barra_vida=new ProgressBar();
                barra_vida.setMaxWidth(5555555);
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
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("elegirPokemon.fxml"));
        Parent root = fxmlloader.load();


        ElegirPokemonController elegirPokemones = fxmlloader.getController();
        elegirPokemones.setPrimaryStage(this.stage);
        elegirPokemones.setManejador(this.manejador);
        ArrayList<String> lista_pokemones=manejador.getPokemonesPokebolaJugadorActual();
        elegirPokemones.inicializarDataPokemones(barras_vida_pokemones,lista_pokemones);


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
        confirmar_rendirse.setManejador(this.manejador);
        confirmar_rendirse.inicializarDataEscenaConfirmarRedirse(nombre_jugador_actual,nombre_jugador_no_actual,barra_vida_actual,barra_vida_no_actual,cant_vida);  //Carga los datos de imagenes y nombres correctos

        Scene scene = new Scene(root);

        this.stage.setScene(scene);


        confirmar_rendirse.guardarEscenaBatalla(escenaBatalla,escenaBatallaParametro);

        this.stage.setTitle("Pidiendo Pokemon");
        this.stage.show();




    }

    //boton mochila

    @FXML
    public void clickMostrarMochila() throws IOException{
        try{
            activarEscenaMostrarMochila();
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void activarEscenaMostrarMochila() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mochila.fxml"));
        Parent root  = fxmlLoader.load();

        MochilaController mochilaController = fxmlLoader.getController();
        mochilaController.setPrimaryStage(this.stage);
        mochilaController.setManejador(this.manejador);
        mochilaController.inicializarDataMochila(manejador.getEntrenador_actual());

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("mochila");
        this.stage.show();
    }


    public void guardarEscenaBatalla(Stage stage,Scene escena) {
        this.escenaBatalla=stage;
        this.escenaBatallaParametro=escenaBatallaParametro;
    }

    @FXML
    public void elegirHabilidad(ActionEvent actionEvent) {
        inhabilitarBotonesIniciales();
        habilitarBotonesDeHabilidad();
        info_juego.setText("Que habilidad quieres usar?");
    }

    private void habilitarBotonesDeHabilidad() {
        habilidad_uno_boton.setDisable(false);
        habilidad_dos_boton.setDisable(false);
        habilidad_tres_boton.setDisable(false);
        habilidad_cuatro_boton.setDisable(false);
        habilidad_uno_boton.setVisible(true);
        habilidad_dos_boton.setVisible(true);
        habilidad_tres_boton.setVisible(true);
        habilidad_cuatro_boton.setVisible(true);
    }

    public void inhabilitarBotonesIniciales(){
        cambiar_pokemon.setDisable(true);
        mochila_.setDisable(true);
        atacar.setDisable(true);
        rendirse.setDisable(true);
        cambiar_pokemon.setVisible(false);
        mochila_.setVisible(false);
        atacar.setVisible(false);
        rendirse.setVisible(false);
    }

    public void activarHabilidadUno(ActionEvent actionEvent) {
        info_juego.setText("Se activo la habilidad 1");
    }
    public void activarHabilidadDos(ActionEvent actionEvent) {
        info_juego.setText("Se activo la habilidad 2");
    }
    public void activarHabilidadTres(ActionEvent actionEvent) {
        info_juego.setText("Se activo la habilidad 3");
    }
    public void activarHabilidadCuatro(ActionEvent actionEvent) {
        info_juego.setText("Se activo la habilidad 4");
    }

}
