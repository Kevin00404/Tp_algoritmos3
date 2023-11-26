package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.items.Items;
import org.example.pokemon.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private Scene escenaBatalla;

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setManejador(ManejadorDeDatosBatalla manejador) {
        this.manejador = manejador;
    }

    public void inicializarDataPokemones( Integer item) {
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
     public void setDatosPkmnActual(){
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

    @FXML
    public void usarItem() throws IOException {
        Pokemon poke = encontrarPoke(pokemonQueUsaItem);
        manejador.getEntrenador_actual().getMochila().usarItem(poke, itemAUsar+1);

        this.stage.setScene(escenaBatalla);
        this.stage.setTitle("batalla");
        this.stage.show();
    }

    private Pokemon encontrarPoke(String pokemonQueUsaItem) {
        System.out.println(pokemonQueUsaItem);
        for (Pokemon poke: manejador.getEntrenador_actual().getPokemones().getPokemones()) {
            System.out.println(poke.getNombre());
            if (poke.getNombre().equals(pokemonQueUsaItem)){
                System.out.println("entro");
                return poke;
            }
            System.out.println("no entro");
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

    public void volverAMochila() throws IOException {
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

    public void setScene(Scene escenaBatalla) {
        this.escenaBatalla = escenaBatalla;
    }
}
