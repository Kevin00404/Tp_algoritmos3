package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.items.Items;

import java.util.ArrayList;
import java.util.List;

public class MochilaController {

    private Stage stage;

    private ManejadorDeDatosBatalla manejador;

    @FXML
    public ListView listaItems;

    @FXML
    public ImageView imagenItem;

    @FXML
    public Label descripcionItem;

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
        setListaItems(nombresItem);
    }

    private void setListaItems(List<String> items) {
        for (String item: items ) {
            listaItems.getItems().add(item);
            setDescripcion();
        }
        listaItems.getSelectionModel().select(0);
    }

    private void setDescripcion() {
        listaItems.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                descripcionItem.setText(newValue.toString());
            } else {
                descripcionItem.setText("");
            }
        });
    }

}
