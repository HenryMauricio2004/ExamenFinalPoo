package com.mateouca.examen_finalpoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class BCNController implements Initializable {

    @FXML
    private TableView<ClientBCN> tblclient;
    @FXML
    private TableColumn colNombres;
    @FXML
    private TableColumn colFechas;
    @FXML
    private TableColumn colIDCliente;
    @FXML
    private TableColumn colTarjeta;
    @FXML
    private TableColumn colMonto;
    @FXML
    private Button btnCompras , btnDinero , btnTarjetas , btnFacilitador;
    @FXML
    private Label lblCompras , lblDinero , lblTarjetas , lblFacilitador;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onComprasRealizadas(ActionEvent event){

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