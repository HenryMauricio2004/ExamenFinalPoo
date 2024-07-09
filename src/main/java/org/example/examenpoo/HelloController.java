package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.examenpoo.DataBase.GeneradorDataBase;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class HelloController implements Initializable {

    private DatabaseController controller;
    private GeneradorDataBase generador;

    @FXML private Label lbl_textoResultados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        controller = DatabaseController.getInstance();
        generador = GeneradorDataBase.getInstance();

        controller.setUser(generador.getUser());
        controller.setPassword(generador.getPassword());
    }

    @FXML void accionBtn_ComprasLapso(){
        try{

            TreeMap <Integer, ArrayList<String>> resultados;
            resultados = controller.getComprasPorCliente(1, Date.valueOf("2023-12-31"), Date.valueOf("2024-01-21"));

            imprimirTreeMap(resultados);
        } catch (Exception e){
            System.out.println(e);
        }

    }

    @FXML void accionBtn_ClientesAsociados(){
        try{

            TreeMap <Integer, ArrayList<String>> resultados;
            resultados = controller.getTarjetasAsociado(2);

            imprimirTreeMap(resultados);
        } catch (Exception e){
            System.out.println(e);
        }
    }



    private void imprimirTreeMap(TreeMap<Integer, ArrayList<String>> treeMap){

        lbl_textoResultados.setText("");

        for (int id: treeMap.keySet()){
            lbl_textoResultados.setText(lbl_textoResultados.getText() + id);

            for (String elemento: treeMap.get(id)){
                lbl_textoResultados.setText(lbl_textoResultados.getText() + ", " + elemento);
            }

            lbl_textoResultados.setText(lbl_textoResultados.getText() + "\n");
        }

    }

}