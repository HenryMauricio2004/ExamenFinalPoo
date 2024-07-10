package org.example.examenpoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TarjetasFacilitadorController implements Initializable {
    @FXML private ComboBox cmbFacilitadores;

    private final ObservableList <String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        list.addAll("mike","Si","Yeha");//Debe de ser por medio de consulta esta parte
        cmbFacilitadores.getItems().addAll(list);
    }

    @FXML public void cargarInfo()
    {
        try {

        }
        System.out.println(cmbFacilitadores.getSelectionModel().getSelectedItem());
    }
}
