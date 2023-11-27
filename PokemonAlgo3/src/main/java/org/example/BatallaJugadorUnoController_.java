package org.example;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.Log.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class BatallaJugadorUnoController_ {
    @FXML
    public ImageView zzzContrario;
    @FXML
    public ImageView confusoContrario;
    @FXML
    public ImageView paralizadoContrario;
    @FXML
    public ImageView venenoContrario;
    @FXML
    public ImageView confusoAtacante;
    @FXML
    public ImageView zzzAtacante;
    @FXML
    public ImageView paralizadoAtacante;
    @FXML
    public ImageView venenoAtacante;

    @FXML
    public ImageView clima;
    @FXML
    public ImageView Despejado;
    @FXML
    public ImageView Granizo;

    @FXML
    public ImageView Huracan;
    @FXML
    public ImageView Lluvia;
    @FXML
    public ImageView Niebla;

    @FXML
    public ImageView Soleado;
    @FXML
    public ImageView TormentaDeArena;
    @FXML
    public ImageView TormentaDeRayo;
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
    @FXML
    public VBox main;
    @FXML
    public ImageView pkmnAtacante;
    @FXML
    public Label labelRendirse;
    @FXML
    public Button siRendirse;
    @FXML
    public Button noRendirse;
    @FXML
    public GridPane opciones;


    public Stage escenaBatalla;
    public Scene escenaBatallaParametro;
    public ManejadorDeDatosBatalla manejador;

    public HashMap<String, ProgressBar> barras_vida_pokemones;
    private Scene escenaDeBatalla;


    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setJuego(Juego juego) {
        this.manejador = new ManejadorDeDatosBatalla();
        manejador.ordenarData(juego);
    }


    public void inicializarDatosdeBatalla() throws IOException {
        animacionFadeIn();
        Log.getLog().setFuente(info_juego);
        recargarDatos();
        nombre_jugador_actual.setText(manejador.getEntrenadorActualNombre());
        nombre_jugador_no_actual.setText(manejador.getEntrenadorContrarioNombre());
    }
 
    public void recargarDatos() throws IOException {
        System.out.println("CAMBIO DE LUGAR LOS JUGADORES");
        manejador.cambiarJugadores(barra_vida_actual,barra_vida_no_actual,nombre_jugador_actual,nombre_jugador_no_actual);
        manejador.ejecutarPasivos();
        setDatosAtacante();
        setDatosOponente();
    }

    private void setDatosAtacante() throws IOException {
        manejo_barra_vida_turno();
        setearVida(barra_vida_actual, manejador.getVidaPokemon(2)/manejador.getMaxVidaPokemon(2));
        nombre_jugador_actual.setText(manejador.getEntrenadorActualNombre());
        manejador.setearEstados(paralizadoAtacante, venenoAtacante, zzzAtacante, confusoAtacante, paralizadoContrario, venenoContrario, zzzContrario, confusoContrario);
        manejador.cambiarClima(Despejado, Huracan, Soleado, Niebla, Lluvia, TormentaDeArena, TormentaDeRayo, Granizo);
        Log.getLog().log(nombre_jugador_actual.getText() + ", ¿qué deseas hacer?");
        chequearPokemonesMuertos();
    }

    private void chequearPokemonesMuertos() throws IOException {
        String nombre_entrenador_muerto = manejador.analizarMuertos();
        if(nombre_entrenador_muerto != null){
            ejecutarEscenaGanador(nombre_entrenador_muerto);
        }
        if(manejador.pokemon_entrenador_actual_murio()){
            System.out.println("Pokemon Actual murio");
            activarEscenaCambiarPokemon();
        }
    }

    private void ejecutarEscenaGanador(String nombre) {

    }
    private void setDatosOponente(){
        setearVida(barra_vida_no_actual, manejador.getVidaPokemon(1)/manejador.getMaxVidaPokemon(1));
    }

    private void manejo_barra_vida_turno(){
        Double vida_actual=manejador.getVidaPokemonAtacante();
        Double vida_max=manejador.getMaxVidaPokemonAtacante();
        cant_vida.setText(String.format("%.0f", vida_actual)+"/"+String.format("%.0f", vida_max));
    }



    //Manejo de Botones:
    //boton cambiar poke
    @FXML
    public void clickCambiarPokemon() throws IOException {
        try {
            activarEscenaCambiarPokemon();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void activarEscenaCambiarPokemon() throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("escenaElegirPoke.fxml"));
        Parent root = fxmlloader.load();

        ElegirPokemonController elegirPokemones = fxmlloader.getController();
        elegirPokemones.setPrimaryStage(this.stage);
        elegirPokemones.setManejador(this.manejador);
        elegirPokemones.setScene(this.escenaDeBatalla);
        elegirPokemones.inicializarDataPokemones();

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("Cambiar Pokemon");
        this.stage.show();
    }
    public void setManejador(ManejadorDeDatosBatalla manejador){
        this.manejador=manejador;
    }

    //boton rendirse
    @FXML
    public void activarRendirse(){
        desactivarOpciones();
        mostrarRendirse();
    }

    public void desactivarOpciones(){
        opciones.setVisible(false);
    }

    public void mostrarRendirse(){
        labelRendirse.setVisible(true);
        siRendirse.setVisible(true);
        noRendirse.setVisible(true);
    }

    @FXML
    public void seRindio() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaDeVictoria.fxml"));
        Parent root  = fxmlLoader.load();

        PantallaDeVictoriaController victoria = fxmlLoader.getController();
        victoria.setPantallaVictoria(manejador.getEntrenadorContrarioNombre());

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("victoria");
        this.stage.show();

    }

    @FXML
    public void noSeRindio(){
        ocultarRendirse();
        mostrarOpciones();
    }

    public void mostrarOpciones(){
        opciones.setVisible(true);
    }

    public void ocultarRendirse(){
        labelRendirse.setVisible(false);
        siRendirse.setVisible(false);
        noRendirse.setVisible(false);
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

    @FXML
    public void animacionFadeIn(){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), main);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void activarEscenaMostrarMochila() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mochila.fxml"));
        Parent root  = fxmlLoader.load();

        MochilaController mochilaController = fxmlLoader.getController();
        mochilaController.setPrimaryStage(this.stage);
        mochilaController.setScene(this.escenaDeBatalla);
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


    public void setScene(Scene scene) {
        this.escenaDeBatalla = scene;
    }

    //boton atacar
    @FXML
    public void elegirHabilidad(ActionEvent actionEvent) {
        inhabilitarBotonesIniciales();
        manejador.cargarHabilidades(habilidad_uno_boton, habilidad_dos_boton, habilidad_tres_boton, habilidad_cuatro_boton);
        habilitarBotonesDeHabilidad();
        Log.getLog().log("Que habilidad queres usar?");
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

    private void deshabilitarBotonesDeHabilidad(){
        habilidad_uno_boton.setDisable(true);
        habilidad_dos_boton.setDisable(true);
        habilidad_tres_boton.setDisable(true);
        habilidad_cuatro_boton.setDisable(true);
        habilidad_uno_boton.setVisible(false);
        habilidad_dos_boton.setVisible(false);
        habilidad_tres_boton.setVisible(false);
        habilidad_cuatro_boton.setVisible(false);
    }

    public void habilitarBotonesIniciales(){
        cambiar_pokemon.setDisable(false);
        mochila_.setDisable(false);
        atacar.setDisable(false);
        rendirse.setDisable(false);
        cambiar_pokemon.setVisible(true);
        mochila_.setVisible(true);
        atacar.setVisible(true);
        rendirse.setVisible(true);
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

    public void activarHabilidadUno(ActionEvent actionEvent) throws InterruptedException, IOException {
        manejador.ejecutarHabilidadUno();
        animacionAtaque();
        deshabilitarBotonesDeHabilidad();
        habilitarBotonesIniciales();
        //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
        recargarDatos();
    }
    public void activarHabilidadDos(ActionEvent actionEvent) throws InterruptedException, IOException {
        manejador.ejecutarHabilidadDos();
        animacionAtaque();
        deshabilitarBotonesDeHabilidad();
        habilitarBotonesIniciales();
        //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
        recargarDatos();
    }
    public void activarHabilidadTres(ActionEvent actionEvent) throws InterruptedException, IOException {
        manejador.ejecutarHabilidadTres();
        animacionAtaque();
        deshabilitarBotonesDeHabilidad();
        habilitarBotonesIniciales();
        //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
        recargarDatos();
    }
    public void activarHabilidadCuatro(ActionEvent actionEvent) throws InterruptedException, IOException {
        manejador.ejecutarHabilidadCuatro();
        animacionAtaque();
        deshabilitarBotonesDeHabilidad();
        habilitarBotonesIniciales();
        //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
        recargarDatos();
    }

    private void setearVida(ProgressBar barra_vida, double vidaActualizada) {
        System.out.println("Progreso de Barra de vida: " + barra_vida.getProgress());
        System.out.println("Se va a setear a: " + vidaActualizada);
        // Create a timeline for smooth animation
        Timeline task = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(barra_vida.progressProperty(), barra_vida.getProgress())
                ),
                new KeyFrame(
                        Duration.seconds(3),
                        new KeyValue(barra_vida.progressProperty(), vidaActualizada)
                )
        );
        task.playFromStart();

    }

    public void animacionAtaque(){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), pkmnAtacante);

        // Mover 100 píxeles en la dirección X
        transition.setToX(100);

        // Manejar el evento de finalización para volver a la posición inicial
        transition.setOnFinished(event -> {
            pkmnAtacante.setTranslateX(0);  // Restaurar a la posición inicial
        });

        // Iniciar la transición
        transition.play();
    }
}
