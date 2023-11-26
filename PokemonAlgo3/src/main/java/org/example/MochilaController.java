package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.items.Items;

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
    public GridPane confirmarUso;

    @FXML
    public Button confirmarNo;

    @FXML
    public Button confirmarSi;

    public MultipleSelectionModel listViewOriginal;
    private Scene escenaBatalla;

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setManejador(ManejadorDeDatosBatalla manejador) {
        this.manejador = manejador;
    }

    public void inicializarDataMochila(Entrenador entrenadorActual) {
        List<String> nombresItem = new ArrayList<>();
        for (Items item : entrenadorActual.getMochila().getItems() ) {
            nombresItem.add(item.getNombre());
        }
        setListaItems(nombresItem, entrenadorActual.getMochila().getItems());
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
                String descripcion = encontrarItemEnMochila(mochila, (String) newValue);
                descripcionItem.setText(descripcion);
            } else {
                descripcionItem.setText("");
            }
        });
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
            itemSeleccionado = listaItems.getSelectionModel().getSelectedIndex();
            listaItems.getSelectionModel().clearSelection();
            listaItems.setSelectionModel(null);
            confirmarUso.setVisible(true);
        });
    }

    private Items obtenerItem(List<Items> mochila, String itemSeleccionado) {
        for (Items item : mochila ) {
            if (itemSeleccionado.contains(item.getNombre())){
                return item;
            }
        }
        return null;
    }

    @FXML
    public void ocultarConfirmacion(){
        confirmarUso.setVisible(false);
        listaItems.setSelectionModel(listViewOriginal);
        listaItems.getSelectionModel().select(itemSeleccionado);

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
}
