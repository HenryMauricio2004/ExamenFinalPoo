package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML public void comprasTiempo() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ComprasRealizadas.fxml")); //00133723 creamos un loader para cargar la ventana
        Scene scene = new Scene(loader.load(),700,400); //00133723 Dimensiones para la ventana
        Stage stage = new Stage(); //00133723 Para que se cree la visualizacion de nuestra ventana

        stage.setResizable(false); //00133723 para algo
        stage.setTitle("Busquedas DB"); //00133723 Nombre del titulo personalizado para la ventana
        stage.setScene(scene); //00133723 Para que pueda saber que ventana va mostrar
        stage.show(); //00133723 Nos muestra ya la ventana

    }

    private void imprimirTreeMap(TreeMap<Integer, ArrayList<String>> treeMap){

        for (int id: treeMap.keySet()){
            System.out.print(id);
            for (String elemento: treeMap.get(id)){
                System.out.print(" : " +  elemento);
            }
            System.out.println();
        }

    }

}