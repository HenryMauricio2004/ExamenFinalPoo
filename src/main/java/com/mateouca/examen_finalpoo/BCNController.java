package com.mateouca.examen_finalpoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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
    private Button btnCompras , btnDinero , btnTarjetas , btnFacilitador;//00030123 seran los botenes de las opciones que se pueden realizar a la hora de consutar la base de datos
    @FXML
    private TextArea txtDescrip;//00030123 En este TextArea se mostrara una pequeña informacion de lo que hace cada opcion de la vista del cliente del BCN

    private ObservableList<ClientBCN> clientBCN;//00030123 es una lista observable de los clientes del BCN

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientBCN = FXCollections.observableArrayList();//0030123 es crecar un ObservableList vacio para almacenar e ir guardando a los clientes del BCN

        this.colNombres.setCellFactory(new PropertyValueFactory("name"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colFechas.setCellFactory(new PropertyValueFactory("date"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colIDCliente.setCellFactory(new PropertyValueFactory("id"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colTarjeta.setCellFactory(new PropertyValueFactory("card"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
        this.colMonto.setCellFactory(new PropertyValueFactory("money"));//00030123 para asociar las columnas al tema del modelo de la tabla de los clientes del BCN y que sepa que objeto tomar cada columna
    }

    @FXML
    public void onComprasRealizadas(ActionEvent event){
        String name = this.btnCompras.getText();

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