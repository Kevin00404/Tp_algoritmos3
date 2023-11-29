package org.example;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.items.Items;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MochilaController {

    private Stage stage;

    private ManejadorDeDatosBatalla manejador;

    private Integer itemSeleccionado;

    @FXML
    public ListView listaItems;

    @FXML
    public ImageView imagenItem;

    @FXML
    public Label descripcionItem;

    @FXML
    public Button confirmarNo;

    @FXML
    public Button confirmarSi;

    @FXML
    public AnchorPane main;
    @FXML
    public Label confirmarUsoLabel;
    @FXML
    public Button salir;
    @FXML
    public ImageView fondoConfirmacion;
    @FXML
    public Polygon marcadorSi;
    @FXML
    public Polygon marcadorNo;

    public MultipleSelectionModel listViewOriginal;
    private Scene escenaBatalla;

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setManejador(ManejadorDeDatosBatalla manejador) {
        this.manejador = manejador;
    }

    public void inicializarDataMochila(Entrenador entrenadorActual) {
        animacionFadeIn();
        List<String> nombresItem = new ArrayList<>();
        for (Items item : entrenadorActual.getMochila().getItems() ) {
            nombresItem.add(item.getNombre());
        }
        setListaItems(nombresItem, entrenadorActual.getMochila().getItems());
    }

    @FXML
    public void animacionFadeIn(){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), main);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void animacionFadeIn(Scene batalla){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), batalla.getRoot());
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    private void setListaItems(List<String> items, List<Items> mochila) {
        for (String item: items ) {
            listaItems.getItems().add(item + " x " + obtenerCantidadDelItem(item, mochila));
            setDescripcion(mochila);
        }
        listaItems.getSelectionModel().select(0);
        listViewOriginal = listaItems.getSelectionModel();
    }

    private Integer obtenerCantidadDelItem(String item, List<Items> mochila) {
        for (Items itemEnMochila : mochila ) {
            if (itemEnMochila.getNombre().equals(item)){
                return itemEnMochila.getDisponibles();
            }
        }
        return null;
    }

    private void setDescripcion(List<Items> mochila) {
        listaItems.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                Soundtrack.getSonido().reproducirClick();
                String descripcion = encontrarItemEnMochila(mochila, newValue.toString());
                Image imagenDescripcion = new Image(new File(encontrarImagen(newValue.toString())).toURI().toString());
                imagenItem.setImage(imagenDescripcion);
                descripcionItem.setText(descripcion);
            } else {
                descripcionItem.setText("");
            }
        });
    }

    @FXML
    public void volverABatalla(){

        Soundtrack.getSonido().reproducirClick();

        animacionFadeIn(escenaBatalla);

        this.stage.setScene(escenaBatalla);
        this.stage.setTitle("batalla");
        this.stage.show();
    }

    private String encontrarItemEnMochila(List<Items> mochila, String itemSeleccionado) {
        for (Items item: mochila) {
            if (itemSeleccionado.contains(item.getNombre())) {
                return item.getNombre();
            }
        }
        return null;
    }

    @FXML
    public void confirmarUso(){
        listaItems.setOnMouseClicked(event -> {
            Soundtrack.getSonido().reproducirClick();
            ocultarSalir();
            itemSeleccionado = listaItems.getSelectionModel().getSelectedIndex();
            listaItems.getSelectionModel().clearSelection();
            listaItems.setSelectionModel(null);
            mostrarElementosDeConfirmacion();
        });
    }

    public void mostrarElementosDeConfirmacion(){
        fondoConfirmacion.setVisible(true);
        confirmarUsoLabel.setVisible(true);
        confirmarNo.setVisible(true);
        confirmarSi.setVisible(true);
        marcadorSi.setVisible(true);
    }
    public void ocultarSalir(){
        salir.setVisible(false);
    }

    public void mostrarSalir(){
        salir.setVisible(true);
    }

    @FXML
    public void ocultarConfirmacion(){
        ocultarElementosConfirmacion();
        listaItems.setSelectionModel(listViewOriginal);
        listaItems.getSelectionModel().select(itemSeleccionado);
        mostrarSalir();
    }

    public void ocultarElementosConfirmacion(){
        fondoConfirmacion.setVisible(false);
        confirmarUsoLabel.setVisible(false);
        confirmarSi.setVisible(false);
        confirmarNo.setVisible(false);
        marcadorSi.setVisible(false);
    }

    @FXML
    public void elegirPokemonItem() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seleccionarPokemonParaItem.fxml"));
        Parent root  = fxmlLoader.load();

        SeleccionarPokemonParaItemController itemParaPkmn = fxmlLoader.getController();
        itemParaPkmn.setPrimaryStage(this.stage);
        itemParaPkmn.setManejador(this.manejador);
        itemParaPkmn.setScene(this.escenaBatalla);
        itemParaPkmn.inicializarDataPokemones(itemSeleccionado);

        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.setTitle("usar item");
        this.stage.show();
    }

    public void setScene(Scene escenaBatalla) {
        this.escenaBatalla = escenaBatalla;
    }

    // encontrar imagen de descripcion

    private String encontrarImagen(String item){

        if (item.contains("Hiper pocion")){

            return "imagenes/items/Hiperpocion.png";

        } else if (item.contains("Defensa X")) {

            return "imagenes/items/Defensa_X.png";

        } else if (item.contains("Cura Total")) {

            return "imagenes/items/Cura_total.png";

        } else if (item.contains("Revivir")) {

            return "imagenes/items/Revivir.png";

        } else if (item.contains("Ataque X")) {

            return "imagenes/items/Ataque_X.png";

        } else if (item.contains("Despertar")) {

            return "imagenes/items/Despertar.png";

        } else if (item.contains("Pocion")) {

            return "imagenes/items/Pocion.png";

        } else if (item.contains("AntiParalizar")) {

            return "imagenes/items/Antiparalizador.png";

        } else if (item.contains("Antidoto")) {

            return "imagenes/items/Antidoto.png";

        } else if (item.contains("Super pocion")) {

            return "imagenes/items/Superpocion.png";

        } else {

            return "imagenes/items/Revivir_max.png";

        }

    }

}
