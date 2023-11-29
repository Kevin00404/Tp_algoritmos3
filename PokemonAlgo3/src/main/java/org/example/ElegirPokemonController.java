package org.example;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.pokemon.Pokemon;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ElegirPokemonController implements Initializable {
    private Stage stage;
    private ManejadorDeDatosBatalla manejador;

    private List<Button> botonesDeshabilitados = new ArrayList<>();

    @FXML
    public Button volver;
    private String pokemonSeleccionadoNombre;
    @FXML
    public Label pkmnActualNombre;
    @FXML
    public Label lvlpkmnActual;
    @FXML
    public Label vidaPkmnActual;
    @FXML
    public ProgressBar barraPkmnActual;
    @FXML
    public Label pkmn2Nombre;
    @FXML
    public Label vidaPkmn2;
    @FXML
    public Label lvlPkmn2;
    @FXML
    public ProgressBar barraPkmn2;
    @FXML
    public Label pkmn3Nombre;
    @FXML
    public Label vidaPkmn3;
    @FXML
    public Label lvlPkmn3;
    @FXML
    public ProgressBar barraPkmn3;
    @FXML
    public Label pkmn4Nombre;
    @FXML
    public Label vidaPkmn4;
    @FXML
    public Label lvlPkmn4;
    @FXML
    public ProgressBar barraPkmn4;
    @FXML
    public Label pkmn5Nombre;
    @FXML
    public Label vidaPkmn5;
    @FXML
    public Label lvlPkmn5;
    @FXML
    public ProgressBar barraPkmn5;
    @FXML
    public Label pkmn6Nombre;
    @FXML
    public Label vidaPkmn6;
    @FXML
    public Label lvlPkmn6;
    @FXML
    public ProgressBar barraPkmn6;
    @FXML
    public Button usarItem;
    @FXML
    public Button noUsarItem;
    @FXML
    public AnchorPane confirmacion;

    @FXML
    public Button seleccionarPkmn2;
    @FXML
    public Button seleccionarPkmn3;
    @FXML
    public Button seleccionarPkmn4;
    @FXML
    public Button seleccionarPkmn5;
    @FXML
    public Button seleccionarPkmn6;
    @FXML
    public AnchorPane main;
    @FXML
    public ImageView iconoPkmnActual;
    @FXML
    public ImageView iconoPkmn2;
    @FXML
    public ImageView iconoPkmn3;
    @FXML
    public ImageView iconoPkmn4;
    @FXML
    public ImageView iconoPkmn5;
    @FXML
    public ImageView iconoPkmn6;


    private Scene escenaBatalla;
    private Boolean derrotadoEnPelea;

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setManejador(ManejadorDeDatosBatalla manejador) {
        this.manejador = manejador;
    }



    public void setScene(Scene escenaBatalla) {
        this.escenaBatalla = escenaBatalla;
    }

    public void inicializarDataPokemones() {
        setDatosPkmnActual();
        Integer i= 2;
        for (Pokemon pokemon: manejador.getEntrenador_actual().getPokemones().getPokemones() ) {
            if ( !pokemon.getNombre().equals(manejador.getEntrenador_actual().getPokemonActual().getNombre())){
                switch (i){
                    case 2:
                        setDatosPkmn2(pokemon);
                        i++;
                        break;
                    case 3:
                        setDatosPkmn3(pokemon);
                        i++;
                        break;
                    case 4:
                        setDatosPkmn4(pokemon);
                        i++;
                        break;
                    case 5:
                        setDatosPkmn5(pokemon);
                        i++;
                        break;
                    case 6:
                        setDatosPkmn6(pokemon);
                        i++;
                        break;
                }
            }
        }

        seleccionarPkmn2.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn2Nombre.getText();
            derrotadoEnPelea = false;
            disableOtherButtons(seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn3.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn3Nombre.getText();
            derrotadoEnPelea = false;
            disableOtherButtons(seleccionarPkmn2,seleccionarPkmn4,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn4.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn4Nombre.getText();
            derrotadoEnPelea = false;
            disableOtherButtons( seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn5.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn5Nombre.getText();
            derrotadoEnPelea = false;
            disableOtherButtons( seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn6);
        });
        seleccionarPkmn6.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn6Nombre.getText();
            derrotadoEnPelea = false;
            disableOtherButtons( seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn5);
        });
    }

    public void inicializarDataPokemones(Boolean fuePorPelea) {
        setDatosPkmnActual();
        Integer i= 2;
        for (Pokemon pokemon: manejador.getEntrenador_actual().getPokemones().getPokemones() ) {
            if ( !pokemon.getNombre().equals(manejador.getEntrenador_actual().getPokemonActual().getNombre())){
                switch (i){
                    case 2:
                        setDatosPkmn2(pokemon);
                        i++;
                        break;
                    case 3:
                        setDatosPkmn3(pokemon);
                        i++;
                        break;
                    case 4:
                        setDatosPkmn4(pokemon);
                        i++;
                        break;
                    case 5:
                        setDatosPkmn5(pokemon);
                        i++;
                        break;
                    case 6:
                        setDatosPkmn6(pokemon);
                        i++;
                        break;
                }
            }
        }

        seleccionarPkmn2.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn2Nombre.getText();
            derrotadoEnPelea = fuePorPelea;
            disableOtherButtons(seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn3.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn3Nombre.getText();
            derrotadoEnPelea = fuePorPelea;
            disableOtherButtons(seleccionarPkmn2,seleccionarPkmn4,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn4.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn4Nombre.getText();
            derrotadoEnPelea = fuePorPelea;
            disableOtherButtons( seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn5.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn5Nombre.getText();
            derrotadoEnPelea = fuePorPelea;
            disableOtherButtons( seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn6);
        });
        seleccionarPkmn6.setOnAction(event ->{
            pokemonSeleccionadoNombre = pkmn6Nombre.getText();
            derrotadoEnPelea = fuePorPelea;
            disableOtherButtons( seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn5);
        });
    }


    public void setDatosPkmnActual(){
        String rutaIcono = encontrarRutaIconoPkmn(manejador.getEntrenador_actual().getPokemonActual().getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmnActual.setImage(icono);
        pkmnActualNombre.setText(manejador.getEntrenador_actual().getPokemonActual().getNombre());
        lvlpkmnActual.setText("Nv" + manejador.getEntrenador_actual().getPokemonActual().getEstadisticas().getNivel());
        Double vidaActual = manejador.getEstadisticasPokemonActual().getVida();
        Double vidaMax = manejador.getEstadisticasPokemonActual().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmnActual.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmnActual.setProgress(vidaActual/vidaMax);
    }
    public void setDatosPkmn2(Pokemon pkmn){
        String rutaIcono = encontrarRutaIconoPkmn(pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn2.setImage(icono);
        pkmn2Nombre.setText(pkmn.getNombre());
        lvlPkmn2.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn2.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn2.setProgress(vidaActual/vidaMax);

    }
    public void setDatosPkmn3(Pokemon pkmn){
        String rutaIcono = encontrarRutaIconoPkmn(pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn3.setImage(icono);
        pkmn3Nombre.setText(pkmn.getNombre());
        lvlPkmn3.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn3.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn3.setProgress(vidaActual/vidaMax);

    }
    public void setDatosPkmn4(Pokemon pkmn){
        String rutaIcono = encontrarRutaIconoPkmn(pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn4.setImage(icono);
        pkmn4Nombre.setText(pkmn.getNombre());
        lvlPkmn4.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn4.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn4.setProgress(vidaActual/vidaMax);

    }
    public void setDatosPkmn5(Pokemon pkmn){
        String rutaIcono = encontrarRutaIconoPkmn(pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn5.setImage(icono);
        pkmn5Nombre.setText(pkmn.getNombre());
        lvlPkmn5.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn5.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn5.setProgress(vidaActual/vidaMax);

    }
    public void setDatosPkmn6(Pokemon pkmn){
        String rutaIcono = encontrarRutaIconoPkmn(pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn6.setImage(icono);
        pkmn6Nombre.setText(pkmn.getNombre());
        lvlPkmn6.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn6.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn6.setProgress(vidaActual/vidaMax);
    }

    @FXML
    public void mostrarConfirmacion(){
        volver.setVisible(false);
        confirmacion.setVisible(true);
    }


    private void disableOtherButtons(Button enabledButton, Button... otherButtons) {
        // Desactivar el botón clickeado
        enabledButton.setDisable(true);
        botonesDeshabilitados.add(enabledButton);

        // Desactivar otros botones
        for (Button button : otherButtons) {
            button.setDisable(true);
            botonesDeshabilitados.add(button);
        }
    }

    private void enableButtons() {
        // Habilitar los botones
        for (Button button : botonesDeshabilitados) {
            button.setDisable(false);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void noSeleccionar(){
        enableButtons();
        confirmacion.setVisible(false);
        volver.setVisible(true);
    }





    public void clickSi(MouseEvent mouseEvent) throws IOException {
        this.manejador.cmabiarPOkemonDeJugadorActual(pokemonSeleccionadoNombre);

        clickSalir_volverABatalla();
    }

    @FXML
    public void volverSinCambiar(){

        animacionFadeIn(escenaBatalla);

        this.stage.setScene(escenaBatalla);
        this.stage.setTitle("batalla");
        this.stage.show();

    }

    @FXML
    public void clickSalir_volverABatalla() throws IOException {
        if (derrotadoEnPelea){

            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("batalla_uno.fxml"));
            Parent root = fxmlloader.load();
            BatallaJugadorUnoController_ batallaUno = fxmlloader.getController();
            batallaUno.setPrimaryStage(this.stage);
            batallaUno.setManejador(manejador);
            batallaUno.inicializarDatosdeBatallaSinCambiarTurno();

            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            batallaUno.setScene(scene);

            batallaUno.guardarEscenaBatalla(this.stage,scene);

            this.stage.setTitle("Batalla");
            this.stage.show();

        } else {

            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("batalla_uno.fxml"));
            Parent root = fxmlloader.load();
            BatallaJugadorUnoController_ batallaUno = fxmlloader.getController();
            batallaUno.setPrimaryStage(this.stage);
            batallaUno.setManejador(manejador);
            batallaUno.inicializarDatosdeBatalla();

            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            batallaUno.setScene(scene);

            batallaUno.guardarEscenaBatalla(this.stage,scene);

            this.stage.setTitle("Batalla");
            this.stage.show();
        }
    }

    //animacion

    public void animacionFadeIn(Scene batalla){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), batalla.getRoot());
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    //encontrar ruta
    public String encontrarRutaIconoPkmn(String nombrePokemon){
        if (nombrePokemon.equals("Bulbasaur")){

            return "imagenes/iconos/Bulbasaur_icon.gif";

        } else if (nombrePokemon.equals("Charmander")) {

            return "imagenes/iconos/Charmander_icon.gif";

        } else if (nombrePokemon.equals("Squirtle")) {

            return "imagenes/iconos/Squirtle_icon.gif";

        } else if (nombrePokemon.equals("Pikachu")) {

            return "imagenes/iconos/Pikachu_icon.gif";

        } else if (nombrePokemon.equals("Jigglypuff")) {

            return "imagenes/iconos/Jigglypuff_icon.gif";

        } else if (nombrePokemon.equals("Geodude")) {

            return "imagenes/iconos/Geodude_icon.gif";

        } else if (nombrePokemon.equals("Eevee")) {

            return "imagenes/iconos/Eevee_icon.gif";

        } else if (nombrePokemon.equals("Vulpix")) {

            return "imagenes/iconos/Vulpix_icon.gif";

        } else if (nombrePokemon.equals("Spearow")) {

            return "imagenes/iconos/Spearow_icon.gif";

        } else if (nombrePokemon.equals("Sandshrew")) {

            return "imagenes/iconos/Sandshrew_icon.gif";

        } else if (nombrePokemon.equals("Oddish")) {

            return "imagenes/iconos/Oddish_icon.gif";

        } else if (nombrePokemon.equals("Psyduck")) {

            return "imagenes/iconos/Psyduck_icon.gif";

        } else if (nombrePokemon.equals("Mankey")) {

            return "imagenes/iconos/Mankey_icon.gif";

        } else if (nombrePokemon.equals("Growlithe")) {

            return "imagenes/iconos/Growlithe_icon.gif";

        } else if (nombrePokemon.equals("Poliwag")) {

            return "imagenes/iconos/Poliwag_icon.gif";

        } else if (nombrePokemon.equals("Abra")) {

            return "imagenes/iconos/Abra_icon.gif";

        } else if (nombrePokemon.equals("Machop")) {

            return "imagenes/iconos/Machop_icon.gif";

        } else if (nombrePokemon.equals("Tentacool")) {

            return "imagenes/iconos/Tentacool_icon.gif";

        } else if (nombrePokemon.equals("Doduo")) {

            return "imagenes/iconos/Doduo_icon.gif";

        } else if (nombrePokemon.equals("Seel")) {

            return "imagenes/iconos/Seel_icon.gif";

        } else if (nombrePokemon.equals("Flygon")) {

            return "imagenes/iconos/Flygon_icon.gif";

        } else if (nombrePokemon.equals("Swellow")) {

            return "imagenes/iconos/Swellow_icon.gif";

        } else if (nombrePokemon.equals("Hariyama")) {

            return "imagenes/iconos/Hariyama_icon.gif";

        } else if (nombrePokemon.equals("Swampert")) {

            return "imagenes/iconos/Swampert_icon.gif";

        } else if (nombrePokemon.equals("Claydol")) {

            return "imagenes/iconos/Claydol_icon.gif";

        } else if (nombrePokemon.equals("Exploud")) {

            return "imagenes/iconos/Exploud_icon.gif";

        } else if (nombrePokemon.equals("Ludicolo")) {

            return "imagenes/iconos/Ludicolo_icon.gif";

        } else if (nombrePokemon.equals("Cacnea")) {

            return "imagenes/iconos/Cacnea_icon.gif";

        } else {

            return "imagenes/iconos/Grimer_icon.gif";

        }
    }

}

