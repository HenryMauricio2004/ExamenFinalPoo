package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
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

    @FXML public void tarjetasAsociados() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TarjetasAsociadasPorID.fxml")); //00133723 creamos un loader para cargar la ventana
        Scene scene = new Scene(loader.load(),700,400); //00133723 Dimensiones para la ventana
        Stage stage = new Stage(); //00133723 Para que se cree la visualizacion de nuestra ventana

        stage.setResizable(false); //00133723 para algo
        stage.setTitle("Busquedas DB"); //00133723 Nombre del titulo personalizado para la ventana
        stage.setScene(scene); //00133723 Para que pueda saber que ventana va mostrar
        stage.show(); //00133723 Nos muestra ya la ventana
    }

    @FXML public void dineroPorMes () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DineroGastadoPorMes.fxml")); //00133723 creamos un loader para cargar la ventana
        Scene scene = new Scene(loader.load(),700,400); //00133723 Dimensiones para la ventana
        Stage stage = new Stage(); //00133723 Para que se cree la visualizacion de nuestra ventana

        stage.setResizable(false); //00133723 para algo
        stage.setTitle("Busquedas DB"); //00133723 Nombre del titulo personalizado para la ventana
        stage.setScene(scene); //00133723 Para que pueda saber que ventana va mostrar
        stage.show(); //00133723 Nos muestra ya la ventana
    }

    @FXML public void ClienteAsociadoFacilitador() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClienteAsociadoFacilitador.fxml")); //00133723 creamos un loader para cargar la ventana
        Scene scene = new Scene(loader.load(),700,400); //00133723 Dimensiones para la ventana
        Stage stage = new Stage(); //00133723 Para que se cree la visualizacion de nuestra ventana

        stage.setResizable(false); //00133723 para algo
        stage.setTitle("Busquedas DB"); //00133723 Nombre del titulo personalizado para la ventana
        stage.setScene(scene); //00133723 Para que pueda saber que ventana va mostrar
        stage.show(); //00133723 Nos muestra ya la ventana
    }
    

}