package org.example.examenpoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.example.examenpoo.DataBase.Enum_reportes;
import org.example.examenpoo.DataBase.models.Facilitador;
import org.example.examenpoo.DataBase.models.TarjetaCliente;
import org.example.examenpoo.mediator.Mediator;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class TarjetasFacilitadorController implements Initializable {
    @FXML private ComboBox<Facilitador> cmbFacilitadores;
    private Facilitador facilitador;
    private final ObservableList <String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ArrayList<Facilitador> facilitadores = null;

        try {
            facilitadores = DatabaseController.getInstance().getFacilitadores();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //Debe de ser por medio de consulta esta parte

        cmbFacilitadores.getItems().addAll(facilitadores);
    }

        
    @FXML public void cargarInfo() throws SQLException {

        Facilitador facilitador = cmbFacilitadores.getValue();

        TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getTarjetasAsociado(facilitador.getId());

        String detalles = "Facilitador: " + facilitador.getNombre() + //00183223 especificaciones de busqueda
                "\nformato:  <ID_Cliente>,  <Nombre_Cliente>,  <Apellido_Cliente>,  <Cant_Compras>,  <Dinero_Total_Gastado>"; //00183223 orden de impresion de los resultados

        Mediator.getInstance().procesarResultados(Enum_reportes.REPORTE_D, resultados, detalles); //00183223 procesar resultados, imprimir resultados, crear archivo txt e imprimir detalles



    }
}
