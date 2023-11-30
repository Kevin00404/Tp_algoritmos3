package org.example;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.pokemon.Pokemon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SeleccionarPokemonParaItemController {
    private Stage stage;
    private ManejadorDeDatosBatalla manejador;
    private List<Button> botonesDeshabilitados = new ArrayList<>();
    private String pokemonQueUsaItem;

    private Integer itemAUsar;
    @FXML
    public Button volver;
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
    public Button seleccionarPkmnActual;
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
    @FXML
    public Label mensajeUsuario;
    private Scene escenaBatalla;

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setManejador(ManejadorDeDatosBatalla manejador) {
        this.manejador = manejador;
    }

    public void inicializarDataPokemones( Integer item) {
        animacionFadeIn();
        itemAUsar = item;
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

        seleccionarPkmnActual.setOnAction(event -> {
            pokemonQueUsaItem = pkmnActualNombre.getText();
            disableOtherButtons(seleccionarPkmn2, seleccionarPkmn3, seleccionarPkmn4, seleccionarPkmn5, seleccionarPkmn6);
        });
        seleccionarPkmn2.setOnAction(event ->{
            pokemonQueUsaItem = pkmn2Nombre.getText();
            disableOtherButtons(seleccionarPkmnActual, seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn3.setOnAction(event ->{
            pokemonQueUsaItem = pkmn3Nombre.getText();
            disableOtherButtons(seleccionarPkmnActual, seleccionarPkmn2,seleccionarPkmn4,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn4.setOnAction(event ->{
            pokemonQueUsaItem = pkmn4Nombre.getText();
            disableOtherButtons(seleccionarPkmnActual, seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn5,seleccionarPkmn6);
        });
        seleccionarPkmn5.setOnAction(event ->{
            pokemonQueUsaItem = pkmn5Nombre.getText();
            disableOtherButtons(seleccionarPkmnActual, seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn6);
        });
        seleccionarPkmn6.setOnAction(event ->{
            pokemonQueUsaItem = pkmn6Nombre.getText();
            disableOtherButtons(seleccionarPkmnActual, seleccionarPkmn2,seleccionarPkmn3,seleccionarPkmn4,seleccionarPkmn5);
        });
    }

    @FXML
    public void animacionFadeIn(){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), main);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
     public void setDatosPkmnActual(){

         pkmnActualNombre.setText(manejador.getEntrenador_actual().getPokemonActual().getNombre());
         lvlpkmnActual.setText("Nv" + manejador.getEntrenador_actual().getPokemonActual().getEstadisticas().getNivel());
         Double vidaActual = manejador.getEstadisticasPokemonActual().getVida();
         Double vidaMax = manejador.getEstadisticasPokemonActual().getMaxVida();
         String vidaFormateada = String.format("%.2f", vidaActual);
         String vidaMaxFormateada = String.format("%.2f", vidaMax);
         vidaPkmnActual.setText( vidaFormateada+ "/" + vidaMaxFormateada);
         barraPkmnActual.setProgress(vidaActual/vidaMax);
         setProgressBarColor(barraPkmnActual, vidaActual/vidaMax);
         String rutaIcono = mostrarIconoDependiendoDeVida(vidaActual, manejador.getEntrenador_actual().getPokemonActual().getNombre());
         Image icono = new Image(new File(rutaIcono).toURI().toString());
         iconoPkmnActual.setImage(icono);
     }
    public void setDatosPkmn2(Pokemon pkmn){

        pkmn2Nombre.setText(pkmn.getNombre());
        lvlPkmn2.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn2.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn2.setProgress(vidaActual/vidaMax);
        setProgressBarColor(barraPkmn2, vidaActual/vidaMax);
        String rutaIcono = mostrarIconoDependiendoDeVida(vidaActual, pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn2.setImage(icono);

    }
    public void setDatosPkmn3(Pokemon pkmn){

        pkmn3Nombre.setText(pkmn.getNombre());
        lvlPkmn3.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn3.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn3.setProgress(vidaActual/vidaMax);
        setProgressBarColor(barraPkmn3, vidaActual/vidaMax);
        String rutaIcono = mostrarIconoDependiendoDeVida(vidaActual, pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn3.setImage(icono);

    }
    public void setDatosPkmn4(Pokemon pkmn){

        pkmn4Nombre.setText(pkmn.getNombre());
        lvlPkmn4.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn4.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn4.setProgress(vidaActual/vidaMax);
        setProgressBarColor(barraPkmn4, vidaActual/vidaMax);
        String rutaIcono = mostrarIconoDependiendoDeVida(vidaActual, pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn4.setImage(icono);

    }
    public void setDatosPkmn5(Pokemon pkmn){

        pkmn5Nombre.setText(pkmn.getNombre());
        lvlPkmn5.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn5.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn5.setProgress(vidaActual/vidaMax);
        setProgressBarColor(barraPkmn5, vidaActual/vidaMax);
        String rutaIcono = mostrarIconoDependiendoDeVida(vidaActual, pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn5.setImage(icono);

    }
    public void setDatosPkmn6(Pokemon pkmn){

        pkmn6Nombre.setText(pkmn.getNombre());
        lvlPkmn6.setText("Nv" + pkmn.getEstadisticas().getNivel());
        Double vidaActual = pkmn.getEstadisticas().getVida();
        Double vidaMax = pkmn.getEstadisticas().getMaxVida();
        String vidaFormateada = String.format("%.2f", vidaActual);
        String vidaMaxFormateada = String.format("%.2f", vidaMax);
        vidaPkmn6.setText( vidaFormateada+ "/" + vidaMaxFormateada);
        barraPkmn6.setProgress(vidaActual/vidaMax);
        setProgressBarColor(barraPkmn6, vidaActual/vidaMax);
        String rutaIcono = mostrarIconoDependiendoDeVida(vidaActual, pkmn.getNombre());
        Image icono = new Image(new File(rutaIcono).toURI().toString());
        iconoPkmn6.setImage(icono);
    }

    @FXML
    public void mostrarConfirmacion(){
        volver.setVisible(false);
        confirmacion.setVisible(true);
    }

    @FXML
    public void usarItem() throws IOException, InterruptedException {
        Boolean seUsoItem=false;
        Pokemon poke = encontrarPoke(pokemonQueUsaItem);

        String nombreItem= manejador.getEntrenador_actual().getMochila().getItem(itemAUsar).getNombre();
        //Controlador de Restricciones:
        if (nombreItem.equals("Max revivir") || nombreItem.equals("Revivir")) {
            if (poke.getEstadisticas().getVida() > 0) {
                mensajeUsuario.setText("Item sólo para pokemon muerto.");
            } else {
                seUsoItem = manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar + 1);
            }
        }

        if (nombreItem.equals("Ataque X") || nombreItem.equals("Defensa X")) {
            if (poke.getNombre()!= manejador.getEntrenador_actual().getPokemon().getNombre()) {
                mensajeUsuario.setText("Item sólo para pokemon en batalla.");
            } else {
                seUsoItem = manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar + 1);
            }
        }

        if (nombreItem.equals("Cura Total")) {
            if (poke.getEstadisticas().getVida() <= 0) {
                mensajeUsuario.setText("Item sólo para pokemon vivo.");
            } else {
                seUsoItem = manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar + 1);
            }
        }

        if (nombreItem.equals("Hiper pocion")|| nombreItem.equals("Pocion") || nombreItem.equals("Super pocion")){
            if (poke.getEstadisticas().getVida() > 0 && poke.getEstadisticas().getVida() < 100)  {
                seUsoItem = manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar + 1);
            } else {
                mensajeUsuario.setText("Sólo en pokemon vivo y sin 100% vida.");
            }
        }

        if (nombreItem.equals("Antidoto")){
            if (poke.getEstadisticas().getVida() > 0 && poke.getEstado().getNombre()=="Envenenado")  {
                seUsoItem = manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar + 1);
            } else {
                mensajeUsuario.setText("Item sólo para pokemon envenenado.");
            }
        }

        if (nombreItem.equals("AntiParalizar")){
            if (poke.getEstadisticas().getVida() > 0 && poke.getEstado().getNombre()=="Paralizado")  {
                seUsoItem = manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar + 1);
            } else {
                mensajeUsuario.setText("Item sólo para pokemon paralizado.");
            }
        }
        if (nombreItem.equals("Despertar")){
            if (poke.getEstadisticas().getVida() > 0 && poke.getEstado().getNombre()=="Dormido")  {
                seUsoItem = manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar + 1);
            } else {
                mensajeUsuario.setText("Item sólo para pokemon dormido.");
            }
        }






        if (seUsoItem){
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

        } else {
            noSeleccionar();
        }

    }


    private Pokemon encontrarPoke(String pokemonQueUsaItem) {

        for (Pokemon poke: manejador.getEntrenador_actual().getPokemones().getPokemones()) {

            if (poke.getNombre().equals(pokemonQueUsaItem)){

                return poke;
            }

        }
        return null;
    }

    @FXML
    public void noSeleccionar(){
        enableButtons();
        confirmacion.setVisible(false);
        volver.setVisible(true);
    }

    private void disableOtherButtons(Button enabledButton, Button... otherButtons) {
        enabledButton.setDisable(true);
        botonesDeshabilitados.add(enabledButton);


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

    public void volverAMochila() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mochila.fxml"));
        Parent root  = fxmlLoader.load();

        MochilaController mochilaController = fxmlLoader.getController();
        mochilaController.setPrimaryStage(this.stage);
        mochilaController.setManejador(this.manejador);
        mochilaController.inicializarDataMochila(manejador.getEntrenador_actual());
        mochilaController.setScene(escenaBatalla);

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("mochila");
        this.stage.show();
    }

    public void setScene(Scene escenaBatalla) {
        this.escenaBatalla = escenaBatalla;
    }

    public String mostrarIconoDependiendoDeVida(Double vida, String nombrePkmn){

        String rutaIcono = "";

        if (vida > 0.0){

            rutaIcono = encontrarRutaIconoPkmn(nombrePkmn);
        } else {

            rutaIcono = encontrarRutaIconoPkmnEstatico(nombrePkmn);

        }

        return rutaIcono;
    }

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

    public String encontrarRutaIconoPkmnEstatico(String nombrePokemon){
        if (nombrePokemon.equals("Bulbasaur")){

            return "imagenes/iconos estaticos/Bulbasaur_icon.png";

        } else if (nombrePokemon.equals("Charmander")) {

            return "imagenes/iconos estaticos/Charmander_icon.png";

        } else if (nombrePokemon.equals("Squirtle")) {

            return "imagenes/iconos estaticos/Squirtle_icon.png";

        } else if (nombrePokemon.equals("Pikachu")) {

            return "imagenes/iconos estaticos/Pikachu_icon.png";

        } else if (nombrePokemon.equals("Jigglypuff")) {

            return "imagenes/iconos estaticos/Jigglypuff_icon.png";

        } else if (nombrePokemon.equals("Geodude")) {

            return "imagenes/iconos estaticos/Geodude_icon.png";

        } else if (nombrePokemon.equals("Eevee")) {

            return "imagenes/iconos estaticos/Eevee_icon.png";

        } else if (nombrePokemon.equals("Vulpix")) {

            return "imagenes/iconos estaticos/Vulpix_icon.png";

        } else if (nombrePokemon.equals("Spearow")) {

            return "imagenes/iconos estaticos/Spearow_icon.png";

        } else if (nombrePokemon.equals("Sandshrew")) {

            return "imagenes/iconos estaticos/Sandshrew_icon.png";

        } else if (nombrePokemon.equals("Oddish")) {

            return "imagenes/iconos estaticos/Oddish_icon.png";

        } else if (nombrePokemon.equals("Psyduck")) {

            return "imagenes/iconos estaticos/Psyduck_icon.png";

        } else if (nombrePokemon.equals("Mankey")) {

            return "imagenes/iconos estaticos/Mankey_icon.png";

        } else if (nombrePokemon.equals("Growlithe")) {

            return "imagenes/iconos estaticos/Growlithe_icon.png";

        } else if (nombrePokemon.equals("Poliwag")) {

            return "imagenes/iconos estaticos/Poliwag_icon.png";

        } else if (nombrePokemon.equals("Abra")) {

            return "imagenes/iconos estaticos/Abra_icon.png";

        } else if (nombrePokemon.equals("Machop")) {

            return "imagenes/iconos estaticos/Machop_icon.png";

        } else if (nombrePokemon.equals("Tentacool")) {

            return "imagenes/iconos estaticos/Tentacool_icon.png";

        } else if (nombrePokemon.equals("Doduo")) {

            return "imagenes/iconos estaticos/Doduo_icon.png";

        } else if (nombrePokemon.equals("Seel")) {

            return "imagenes/iconos estaticos/Seel_icon.png";

        } else if (nombrePokemon.equals("Flygon")) {

            return "imagenes/iconos estaticos/Flygon_icon.png";

        } else if (nombrePokemon.equals("Swellow")) {

            return "imagenes/iconos estaticos/Swellow_icon.png";

        } else if (nombrePokemon.equals("Hariyama")) {

            return "imagenes/iconos estaticos/Hariyama_icon.png";

        } else if (nombrePokemon.equals("Swampert")) {

            return "imagenes/iconos estaticos/Swampert_icon.png";

        } else if (nombrePokemon.equals("Claydol")) {

            return "imagenes/iconos estaticos/Claydol_icon.png";

        } else if (nombrePokemon.equals("Exploud")) {

            return "imagenes/iconos estaticos/Exploud_icon.png";

        } else if (nombrePokemon.equals("Ludicolo")) {

            return "imagenes/iconos estaticos/Ludicolo_icon.png";

        } else if (nombrePokemon.equals("Cacnea")) {

            return "imagenes/iconos estaticos/Cacnea_icon.png";

        } else {

            return "imagenes/iconos estaticos/Grimer_icon.png";

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
