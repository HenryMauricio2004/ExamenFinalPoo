package com.mateouca.examen_finalpoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BCNController implements Initializable {

    @FXML
    private TableView<ClientBCN> tblclient;//00030123 Es la tabla donde esta ubicada cada columna que mostrara los datos del cliente del BCN a la hora de seleccionar cualquier opcion que desea que se relaice
    @FXML
    private TableColumn colNombres;//00030123 La columna donde se representan o se muestran los nombres del clientes del BCN
    @FXML
    private TableColumn colFechas;//00030123 La columna donde se mostrara las fechas de las compras realizadas
    @FXML
    private TableColumn colIDCliente;//00030123 La columna donde se mostrara el ID del cliente del BCN
    @FXML
    private TableColumn colTarjeta;//00030123 La columna donde se mostrara las tarjetas asociadas del cliente del BCN
    @FXML
    private TableColumn colMonto;//0030123 La columna donde se mostrara el monto gastado del cliente del BCN
    @FXML
    private TextArea txtDescrip;//00030123 En este TextArea se mostrara una pequeña informacion de lo que hace cada opcion de la vista del cliente del BCN

    private ObservableList<ClientBCN> clientBCN;//00030123 es una lista observable de los clientes del BCN
    //private DataBaseController dataBaseController //00030123 es el controlador de la base de datos

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientBCN = FXCollections.observableArrayList();//0030123 es crecar un ObservableList vacio para almacenar e ir guardando a los clientes del BCN
        TableView<ClientBCN> tblclient = new TableView<>();//00030123 crea la nueva tabla de los clientes del BCN
        this.tblclient.setItems(clientBCN);//00030123 es para refrescar la tabla de los clientes del BCN y que se vayan mostrado a la tabla

        this.colNombres.setCellFactory(new PropertyValueFactory("name"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colFechas.setCellFactory(new PropertyValueFactory("date"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colIDCliente.setCellFactory(new PropertyValueFactory("id"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colTarjeta.setCellFactory(new PropertyValueFactory("card"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colMonto.setCellFactory(new PropertyValueFactory("money"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna

        try {
            tblclient.getItems().addAll(ClientBCN.getComprasPorCliente());//00030123 es para refrescar la tabla de los clientes del BCN y que se vayan mostrado a la tabla
        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al conectar con la base de datos");
            alert.showAndWait();
        }
    }

    @FXML
    public void onComprasRealizadas(ActionEvent event){
        int id_tarjeta = Integer.parseInt(txtDescrip.getText());
        float montoTotal = (float) colMonto.getCellData(colMonto.getTableView().getSelectionModel().getSelectedIndex());
        LocalDate fecha = (LocalDate) colFechas.getCellData(colFechas.getTableView().getSelectionModel().getSelectedIndex());

        try {
            upDateCompra(id_tarjeta, montoTotal, fecha);
        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al conectar con la base de datos");
            alert.showAndWait();
        }
    }

    @FXML
    public void onDineroGastado(ActionEvent event){

    }

    @FXML
    public void onTarjetasAsociadas(ActionEvent event){

    }

    @FXML
    public void onClienteFacilitador(ActionEvent event){

    }
}