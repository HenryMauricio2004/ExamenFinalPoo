package org.example.examenpoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.example.examenpoo.DataBase.models.Facilitador;
import org.example.examenpoo.DataBase.models.TarjetaCliente;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TarjetasFacilitadorController implements Initializable {
    @FXML private ComboBox cmbFacilitadores;
    private Facilitador facilitador;
    private final ObservableList <String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        list.addAll("mike","Si","Yeha");//Debe de ser por medio de consulta esta parte
        cmbFacilitadores.getItems().addAll(list);
    }

        
    @FXML public void cargarInfo() throws SQLException {

        int id = 0;
        String nombre = "";

        facilitador = new Facilitador(id , nombre);

        try {
            List<TarjetaCliente> asociados = facilitador.getAllTarjetaCliente();
            cmbFacilitadores.getItems().addAll(asociados);
        }catch (SQLException e){
            e.printStackTrace();
        }
        DatabaseController.getInstance().getFacilitadores();
        System.out.println(cmbFacilitadores.getSelectionModel().getSelectedItem());
    }
}
