package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import org.example.examenpoo.Controladores.Ventanas;
import org.example.examenpoo.DataBase.GeneradorDataBase;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.examenpoo.mediator.Mediator;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class HelloController implements Initializable {

    private DatabaseController controller;
    private GeneradorDataBase generador;
    private Mediator mediator;

    @FXML private Label lbl_textoResultados;
    @FXML private Label lbl_DescripcionBusqueda;

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle){
        controller = DatabaseController.getInstance(); //00183223 asignar referencia a singleton de controller
        generador = GeneradorDataBase.getInstance(); //00183223 asignar referencia a singleton de generadotDataBase
        mediator = Mediator.getInstance(); //00183223 asignar referencia a singleton de mediator

        controller.setUser(generador.getUser()); //00183223 pasar el usuario guardado en generador a controller
        controller.setPassword(generador.getPassword()); //00183223 pasar el password guarddado en generador a controller

        mediator.setLabelResultados(lbl_textoResultados); //00183223 pasar referencia de labelResultados a mediator
        mediator.setLabelDetallesBusqueda(lbl_DescripcionBusqueda); //00183223 pasar referencia de labelDetallesBusqueda a mediator

    }


    @FXML public void comprasTiempo() throws Exception {
        ComprasAplication.getInstance().invocarPantalla();
    }

    @FXML public void comprasTiempo() throws Exception {

        Ventanas ctm = new Ventanas("ComprasRealizadas","DBExplorer");
        Stage stage = new Stage();
        ctm.start(stage);
    }
    @FXML public void tarjetasAsociados() throws Exception {

        Ventanas ctm = new Ventanas("TarjetasAsociadasPorID","Tarjetas Asociadas");
        Stage stage = new Stage();
        ctm.start(stage);
    }

    @FXML public void dineroPorMes () throws Exception {
        Ventanas ctm = new Ventanas("DineroGastadoPorMes","Explorer");
        Stage stage = new Stage();
        ctm.start(stage);
    }

    @FXML public void ClienteAsociadoFacilitador() throws Exception {
        Ventanas ctm = new Ventanas("ClienteAsociadoFacilitador","BD");
        Stage stage = new Stage();
        ctm.start(stage);
    }
    

}