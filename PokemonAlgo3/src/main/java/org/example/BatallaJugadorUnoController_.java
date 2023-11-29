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
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.Log.Log;
import org.example.habilidad.Habilidad;

import java.io.File;
import java.io.IOException;
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
    @FXML
    public ImageView pkmnFrente;
    @FXML
    public ImageView pkmnEspalda;
    @FXML
    public ImageView imagenSonidoOn;
    @FXML
    public Button activarMusica;
    @FXML
    public ImageView imagenSonidoOff;
    @FXML
    public Button desactivarMusica;
    @FXML
    public Polygon marcadorAtacar;
    @FXML
    public Polygon marcadorPokemon;
    @FXML
    public Polygon marcadorMochila;
    @FXML
    public Polygon marcadorRendirse;
    @FXML
    public AnchorPane contenedorHabilidades;
    @FXML
    public Label tipoHabilidad;
    @FXML
    public Label labelDisponibles;
    @FXML
    public Label labelTextoDisponibles;
    @FXML
    public Label labelTextoTipo;
    @FXML
    public Line marcadorHabilidad1;
    @FXML
    public Line marcadorHabilidad2;
    @FXML
    public Line marcadorHabilidad3;
    @FXML
    public Line marcadorHabilidad4;
    @FXML
    public Polygon marcadorSi;
    @FXML
    public Polygon marcadorNo;


    public Stage escenaBatalla;
    public Scene escenaBatallaParametro;
    public ManejadorDeDatosBatalla manejador;

    public HashMap<String, ProgressBar> barras_vida_pokemones;
    private Scene escenaDeBatalla;
    private Integer contadorClicks1;
    private Integer contadorClicks2;
    private Integer contadorClicks3;
    private Integer contadorClicks4;


    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setJuego(Juego juego) {
        this.manejador = new ManejadorDeDatosBatalla(barra_vida_actual, barra_vida_no_actual);
        manejador.ordenarData(juego);
    }
    public void inicializarDatosdeBatallaSinCambiarTurno() throws IOException {
        animacionFadeIn();
        Log.getLog().setFuente(info_juego);
        setearDatosSinCambiarTurno();

        nombre_jugador_actual.setText(manejador.getEntrenadorActualNombre());
        nombre_jugador_no_actual.setText(manejador.getEntrenadorContrarioNombre());
    }

    public void setearDatosSinCambiarTurno() throws IOException {

        manejador.noCambiarJugadores(nombre_jugador_actual,nombre_jugador_no_actual);
        manejador.ejecutarPasivos();
        setDatos();
    }

    public void inicializarDatosdeBatalla() throws IOException {

        contadoresACero();
        animacionFadeIn();
        Log.getLog().setFuente(info_juego);
        recargarDatos();

        nombre_jugador_actual.setText(manejador.getEntrenadorActualNombre());
        nombre_jugador_no_actual.setText(manejador.getEntrenadorContrarioNombre());
    }
 
    public void recargarDatos() throws IOException {

        manejador.cambiarJugadores(nombre_jugador_actual,nombre_jugador_no_actual);
        manejador.ejecutarPasivos();
        setDatos();
    }

    private void setDatos() throws IOException {
        manejo_barra_vida_turno();
        setearVida(barra_vida_actual, manejador.getVidaPokemon(1)/manejador.getMaxVidaPokemon(1));
        setearVida(barra_vida_no_actual, manejador.getVidaPokemon(2)/manejador.getMaxVidaPokemon(2));
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
        } else if(manejador.pokemon_entrenador_actual_murio()){

            activarEscenaCambiarPokemon(true);
        }
    }

    private void ejecutarEscenaGanador(String nombre) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaDeVictoria.fxml"));
        Parent root  = fxmlLoader.load();

        PantallaDeVictoriaController victoria = fxmlLoader.getController();
        victoria.setPantallaVictoria(nombre);

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("victoria");
        this.stage.show();

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
        if (contadorClicks4 < 1){

            Soundtrack.getSonido().reproducirClick();
            ocultarMarcadoresPrincipales();
            marcadorPokemon.setVisible(true);
            contadoresACero();
            contadorClicks4++;

        } else {

            try {
                Soundtrack.getSonido().reproducirClick();
                activarEscenaCambiarPokemon();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    public void activarEscenaCambiarPokemon(Boolean fuePorPelea) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("escenaElegirPoke.fxml"));
        Parent root = fxmlloader.load();

        ElegirPokemonController elegirPokemones = fxmlloader.getController();
        elegirPokemones.setPrimaryStage(this.stage);
        elegirPokemones.setManejador(this.manejador);
        elegirPokemones.setScene(this.escenaDeBatalla);
        elegirPokemones.inicializarDataPokemones(fuePorPelea);

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("Cambiar Pokemon");
        this.stage.show();
    }

    public void activarEscenaCambiarPokemon() throws IOException{

        contadoresACero();

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
        if (contadorClicks3 < 1){

            Soundtrack.getSonido().reproducirClick();
            ocultarMarcadoresPrincipales();
            marcadorRendirse.setVisible(true);
            contadoresACero();
            contadorClicks3++;

        } else {

            Soundtrack.getSonido().reproducirClick();
            desactivarOpciones();
            mostrarRendirse();
            contadoresACero();

        }
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

        if (contadorClicks1 < 1){

            Soundtrack.getSonido().reproducirClick();
            marcadorNo.setVisible(false);
            marcadorSi.setVisible(true);
            contadoresACero();
            contadorClicks1++;

        } else {

            Soundtrack.getSonido().reproducirClick();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaDeVictoria.fxml"));
            Parent root  = fxmlLoader.load();

            PantallaDeVictoriaController victoria = fxmlLoader.getController();
            victoria.setJuego(manejador);
            victoria.setPantallaVictoria(manejador.getEntrenadorContrarioNombre());

            Scene scene = new Scene(root);

            this.stage.setScene(scene);
            this.stage.setTitle("victoria");
            this.stage.show();

        }

    }

    @FXML
    public void noSeRindio(){

        if (contadorClicks2 < 1){

            Soundtrack.getSonido().reproducirClick();
            marcadorSi.setVisible(false);
            marcadorNo.setVisible(true);
            contadoresACero();
            contadorClicks2++;

        } else {

            Soundtrack.getSonido().reproducirClick();
            ocultarRendirse();
            marcadorNo.setVisible(false);
            contadoresACero();
            mostrarOpciones();

        }


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
        if (contadorClicks2 < 1){

            ocultarMarcadoresPrincipales();
            marcadorMochila.setVisible(true);
            contadoresACero();
            contadorClicks2++;


        } else {

            try{
                Soundtrack.getSonido().reproducirClick();
                activarEscenaMostrarMochila();
            }catch (IOException ex) {
                throw new RuntimeException(ex);
            }

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

        contadoresACero();

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
        if (contadorClicks1 < 1){

            Soundtrack.getSonido().reproducirClick();
            ocultarMarcadoresPrincipales();
            marcadorAtacar.setVisible(true);
            contadoresACero();
            contadorClicks1++;

        } else {

            Soundtrack.getSonido().reproducirClick();
            inhabilitarBotonesIniciales();
            manejador.cargarHabilidades(habilidad_uno_boton, habilidad_dos_boton, habilidad_tres_boton, habilidad_cuatro_boton);
            habilitarBotonesDeHabilidad();
            contadoresACero();
            ocultarMarcadoresPrincipales();
        }
    }

    private void habilitarDescripcionHabilidad(){
        labelTextoDisponibles.setVisible(true);
        labelTextoTipo.setVisible(true);
        labelDisponibles.setVisible(true);
        tipoHabilidad.setVisible(true);
    }

    private void deshabilitarDescripcionHabilidad(){

        labelTextoDisponibles.setVisible(false);
        labelTextoTipo.setVisible(false);
        labelDisponibles.setVisible(false);
        tipoHabilidad.setVisible(false);

    }



    //manejo de marcadores

    public void ocultarMarcadoresPrincipales(){

        marcadorAtacar.setVisible(false);
        marcadorMochila.setVisible(false);
        marcadorPokemon.setVisible(false);
        marcadorRendirse.setVisible(false);

    }

    private void habilitarBotonesDeHabilidad() {

        habilidad_uno_boton.setDisable(false);
        habilidad_dos_boton.setDisable(false);
        habilidad_tres_boton.setDisable(false);
        habilidad_cuatro_boton.setDisable(false);
        /*habilidad_uno_boton.setVisible(true);
        habilidad_dos_boton.setVisible(true);
        habilidad_tres_boton.setVisible(true);
        habilidad_cuatro_boton.setVisible(true);*/
        contenedorHabilidades.setVisible(true);
    }

    private void deshabilitarBotonesDeHabilidad(){
        habilidad_uno_boton.setDisable(true);
        habilidad_dos_boton.setDisable(true);
        habilidad_tres_boton.setDisable(true);
        habilidad_cuatro_boton.setDisable(true);
        contenedorHabilidades.setVisible(false);
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
        if(contadorClicks1 < 1){

            Soundtrack.getSonido().reproducirClick();
            habilitarDescripcionHabilidad();
            setInfoHabilidad(manejador.getEntrenador_actual().getPokemonActual().getHabilidadUno());
            contadoresACero();
            contadorClicks1++;
            ocultarLineas();
            marcadorHabilidad1.setVisible(true);


        } else {

            Soundtrack.getSonido().reproducirClick();
            manejador.ejecutarHabilidadUno();
            deshabilitarBotonesDeHabilidad();
            deshabilitarDescripcionHabilidad();
            habilitarBotonesIniciales();
            //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
            //recargarDatos();
            animacionAtaque();
            contadoresACero();
            ocultarLineas();
        }

    }
    public void activarHabilidadDos(ActionEvent actionEvent) throws InterruptedException, IOException {
        if (contadorClicks2 < 1){

            Soundtrack.getSonido().reproducirClick();
            habilitarDescripcionHabilidad();
            setInfoHabilidad(manejador.getEntrenador_actual().getPokemonActual().getHabilidadDos());
            contadoresACero();
            contadorClicks2++;
            ocultarLineas();
            marcadorHabilidad2.setVisible(true);

        } else {

            Soundtrack.getSonido().reproducirClick();
            manejador.ejecutarHabilidadDos();
            deshabilitarBotonesDeHabilidad();
            deshabilitarDescripcionHabilidad();
            habilitarBotonesIniciales();
            //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
            //recargarDatos();
            animacionAtaque();
            contadoresACero();
            ocultarLineas();

        }
    }
    public void activarHabilidadTres(ActionEvent actionEvent) throws InterruptedException, IOException {
        if (contadorClicks3 < 1){

            Soundtrack.getSonido().reproducirClick();
            habilitarDescripcionHabilidad();
            setInfoHabilidad(manejador.getEntrenador_actual().getPokemonActual().getHabilidadTres());
            contadoresACero();
            contadorClicks3++;
            ocultarLineas();
            marcadorHabilidad3.setVisible(true);

        } else {


            Soundtrack.getSonido().reproducirClick();
            manejador.ejecutarHabilidadTres();
            deshabilitarBotonesDeHabilidad();
            deshabilitarDescripcionHabilidad();
            habilitarBotonesIniciales();
            //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
            //recargarDatos();
            animacionAtaque();
            contadoresACero();
            ocultarLineas();
        }
    }
    public void activarHabilidadCuatro(ActionEvent actionEvent) throws InterruptedException, IOException {

        if (contadorClicks4 < 1) {

            Soundtrack.getSonido().reproducirClick();
            habilitarDescripcionHabilidad();
            setInfoHabilidad(manejador.getEntrenador_actual().getPokemonActual().getHabilidadCuatro());
            contadoresACero();
            contadorClicks4++;
            ocultarLineas();
            marcadorHabilidad4.setVisible(true);

        } else {

            Soundtrack.getSonido().reproducirClick();
            manejador.ejecutarHabilidadCuatro();
            deshabilitarBotonesDeHabilidad();
            deshabilitarDescripcionHabilidad();
            habilitarBotonesIniciales();
            //manejador.cambiarJugadores(barra_vida_actual, barra_vida_no_actual, nombre_jugador_actual, nombre_jugador_no_actual);
            //recargarDatos();
            animacionAtaque();
            contadoresACero();
            ocultarLineas();

        }

    }

    private void contadoresACero(){

        contadorClicks1 = 0;
        contadorClicks2 = 0;
        contadorClicks3 = 0;
        contadorClicks4 = 0;
    }

    private void ocultarLineas(){

        marcadorHabilidad1.setVisible(false);
        marcadorHabilidad2.setVisible(false);
        marcadorHabilidad3.setVisible(false);
        marcadorHabilidad4.setVisible(false);

    }

    private void setInfoHabilidad(Habilidad habilidad){
        String cantidadMax = habilidad.getCatidadMax().toString();
        String cantidad = habilidad.getCantidadDisponible().toString();
        String tipo = habilidad.getTipoDeHabilidad();
        labelDisponibles.setText(cantidad + " / " + cantidadMax);
        tipoHabilidad.setText(tipo);

    }


    private void setearVida(ProgressBar barra_vida, double vidaActualizada) {

        if(barra_vida.getLayoutX() >= 303.0){

            vidaActualizada = manejador.getVidaPokemonAtacante() / manejador.getMaxVidaPokemonAtacante();
            setProgressBarColor(barra_vida, vidaActualizada);
            String rutaFrente = encontrarRutaEspaldaPkmn(manejador.getNombrePokemonAtacante());
            Image frente = new Image(new File(rutaFrente).toURI().toString());
            pkmnEspalda.setImage(frente);


        } else {
            vidaActualizada = manejador.getVidaPokemonContrario() / manejador.getMaxVidaPokemonContrario();
            setProgressBarColor(barra_vida, vidaActualizada);
            String rutaEspalda = encontrarRutaFrentePkmn(manejador.getNombrePokemonContrario());
            Image espalda = new Image(new File(rutaEspalda).toURI().toString());
            pkmnFrente.setImage(espalda);
        }
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


    // animacion de ataque

    public void animacionAtaque() throws IOException, InterruptedException {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), pkmnEspalda);

        transition.setToX(100);

        transition.setOnFinished(event -> {
            Soundtrack.getSonido().reproducirGolpe();
            pkmnEspalda.setTranslateX(0);
        });

        transition.play();


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {

            try {
                recargarDatos();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));

        timeline.play();
    }

    //audio

    @FXML
    public void volverAReproducirMusica(){

        Soundtrack.getSonido().resumirAudio();
        ocultarResumirMusica();
        mostrarPausarMusica();

    }

    private void mostrarPausarMusica(){

        desactivarMusica.setVisible(true);
        imagenSonidoOff.setVisible(true);

    }

    private void mostrarResumirMusica(){

        activarMusica.setVisible(true);
        imagenSonidoOn.setVisible(true);

    }

    private void ocultarResumirMusica(){
        activarMusica.setVisible(false);
        imagenSonidoOn.setVisible(false);

    }

    @FXML
    public void pausarMusica(){

        Soundtrack.getSonido().pausarAudio();
        ocultarPausarMusica();
        mostrarResumirMusica();

    }

    private void ocultarPausarMusica(){
        desactivarMusica.setVisible(false);
        imagenSonidoOff.setVisible(false);
    }


    //busqueda de rutas

    public String encontrarRutaFrentePkmn(String nombrePokemon){
        if (nombrePokemon.equals("Bulbasaur")){

            return "imagenes/frente/Bulbasaur_XY.gif";

        } else if (nombrePokemon.equals("Charmander")) {

            return "imagenes/frente/Charmander_XY.gif";

        } else if (nombrePokemon.equals("Squirtle")) {

            return "imagenes/frente/Squirtle_XY.gif";

        } else if (nombrePokemon.equals("Pikachu")) {

            return "imagenes/frente/Pikachu_XY.gif";

        } else if (nombrePokemon.equals("Jigglypuff")) {

            return "imagenes/frente/Jigglypuff_XY.gif";

        } else if (nombrePokemon.equals("Geodude")) {

            return "imagenes/frente/Geodude_XY.gif";

        } else if (nombrePokemon.equals("Eevee")) {

            return "imagenes/frente/Eevee_XY.gif";

        } else if (nombrePokemon.equals("Vulpix")) {

            return "imagenes/frente/Vulpix_XY.gif";

        } else if (nombrePokemon.equals("Spearow")) {

            return "imagenes/frente/Spearow_XY.gif";

        } else if (nombrePokemon.equals("Sandshrew")) {

            return "imagenes/frente/Sandshrew_XY.gif";

        } else if (nombrePokemon.equals("Oddish")) {

            return "imagenes/frente/Oddish_XY.gif";

        } else if (nombrePokemon.equals("Psyduck")) {

            return "imagenes/frente/Psyduck_XY.gif";

        } else if (nombrePokemon.equals("Mankey")) {

            return "imagenes/frente/Mankey_XY.gif";

        } else if (nombrePokemon.equals("Growlithe")) {

            return "imagenes/frente/Growlithe_XY.gif";

        } else if (nombrePokemon.equals("Poliwag")) {

            return "imagenes/frente/Poliwag_XY.gif";

        } else if (nombrePokemon.equals("Abra")) {

            return "imagenes/frente/Abra_XY.gif";

        } else if (nombrePokemon.equals("Machop")) {

            return "imagenes/frente/Machop_XY.gif";

        } else if (nombrePokemon.equals("Tentacool")) {

            return "imagenes/frente/Tentacool_XY.gif";

        } else if (nombrePokemon.equals("Doduo")) {

            return "imagenes/frente/Doduo_XY.gif";

        } else if (nombrePokemon.equals("Seel")) {

            return "imagenes/frente/Seel_XY.gif";

        } else if (nombrePokemon.equals("Flygon")) {

            return "imagenes/frente/Flygon_XY.gif";

        } else if (nombrePokemon.equals("Swellow")) {

            return "imagenes/frente/Swellow_XY.gif";

        } else if (nombrePokemon.equals("Hariyama")) {

            return "imagenes/frente/Hariyama_XY.gif";

        } else if (nombrePokemon.equals("Swampert")) {

            return "imagenes/frente/Swampert_XY.gif";

        } else if (nombrePokemon.equals("Claydol")) {

            return "imagenes/frente/Claydol_XY.gif";

        } else if (nombrePokemon.equals("Exploud")) {

            return "imagenes/frente/Exploud_XY.gif";

        } else if (nombrePokemon.equals("Ludicolo")) {

            return "imagenes/frente/Ludicolo_XY.gif";

        } else if (nombrePokemon.equals("Cacnea")) {

            return "imagenes/frente/Cacnea_XY.gif";

        } else {

            return "imagenes/frente/Grimer_XY.gif";

        }
    }

    public String encontrarRutaEspaldaPkmn(String nombrePokemon){
        if (nombrePokemon.equals("Bulbasaur")){

            return "imagenes/espalda/Bulbasaur_espalda_G6.gif";

        } else if (nombrePokemon.equals("Charmander")) {

            return "imagenes/espalda/Charmander_espalda_G6.gif";

        } else if (nombrePokemon.equals("Squirtle")) {

            return "imagenes/espalda/Squirtle_espalda_G6.gif";

        } else if (nombrePokemon.equals("Pikachu")) {

            return "imagenes/espalda/Pikachu_espalda_G6.gif";

        } else if (nombrePokemon.equals("Jigglypuff")) {

            return "imagenes/espalda/Jigglypuff_espalda_G6.gif";

        } else if (nombrePokemon.equals("Geodude")) {

            return "imagenes/espalda/Geodude_espalda_G6.gif";

        } else if (nombrePokemon.equals("Eevee")) {

            return "imagenes/espalda/Eevee_espalda_G6.gif";

        } else if (nombrePokemon.equals("Vulpix")) {

            return "imagenes/espalda/Vulpix_espalda_G6.gif";

        } else if (nombrePokemon.equals("Spearow")) {

            return "imagenes/espalda/Spearow_espalda_G6.gif";

        } else if (nombrePokemon.equals("Sandshrew")) {

            return "imagenes/espalda/Sandshrew_espalda_G6.gif";

        } else if (nombrePokemon.equals("Oddish")) {

            return "imagenes/espalda/Oddish_espalda_G6.gif";

        } else if (nombrePokemon.equals("Psyduck")) {

            return "imagenes/espalda/Psyduck_espalda_G6.gif";

        } else if (nombrePokemon.equals("Mankey")) {

            return "imagenes/espalda/Mankey_espalda_G6.gif";

        } else if (nombrePokemon.equals("Growlithe")) {

            return "imagenes/espalda/Growlithe_espalda_G6.gif";

        } else if (nombrePokemon.equals("Poliwag")) {

            return "imagenes/espalda/Poliwag_espalda_G6.gif";

        } else if (nombrePokemon.equals("Abra")) {

            return "imagenes/espalda/Abra_espalda_G6.gif";

        } else if (nombrePokemon.equals("Machop")) {

            return "imagenes/espalda/Machop_espalda_G6.gif";

        } else if (nombrePokemon.equals("Tentacool")) {

            return "imagenes/espalda/Tentacool_espalda_G6.gif";

        } else if (nombrePokemon.equals("Doduo")) {

            return "imagenes/espalda/Doduo_espalda_G6.gif";

        } else if (nombrePokemon.equals("Seel")) {

            return "imagenes/espalda/Seel_espalda_G6.gif";

        } else if (nombrePokemon.equals("Flygon")) {

            return "imagenes/espalda/Flygon_espalda_G6.gif";

        } else if (nombrePokemon.equals("Swellow")) {

            return "imagenes/espalda/Swellow_espalda_G6.gif";

        } else if (nombrePokemon.equals("Hariyama")) {

            return "imagenes/espalda/Hariyama_espalda_G6.gif";

        } else if (nombrePokemon.equals("Swampert")) {

            return "imagenes/espalda/Swampert_espalda_G6.gif";

        } else if (nombrePokemon.equals("Claydol")) {

            return "imagenes/espalda/Claydol_espalda_G6.gif";

        } else if (nombrePokemon.equals("Exploud")) {

            return "imagenes/espalda/Exploud_espalda_G6.gif";

        } else if (nombrePokemon.equals("Ludicolo")) {

            return "imagenes/espalda/Ludicolo_espalda_G6.gif";

        } else if (nombrePokemon.equals("Cacnea")) {

            return "imagenes/espalda/Cacnea_espalda_G6.gif";

        } else {

            return "imagenes/espalda/Grimer_espalda_G6.gif";

        }
    }

    //progress bar con colores
    private void setProgressBarColor(ProgressBar progressBar, Double progress) {
        if (progress >= 0.51) {
            progressBar.setStyle("-fx-accent: green;");
        } else if (progress >= 0.21) {
            progressBar.setStyle("-fx-accent: yellow;");
        } else {
            progressBar.setStyle("-fx-accent: red;");
        }
    }

}
