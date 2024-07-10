package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.examenpoo.DataBase.Enum_reportes;
import org.example.examenpoo.mediator.Mediator;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class ComprasController implements Initializable
{

    @FXML private TextField txtACampoID;
    @FXML private TextField txtADia1;
    @FXML private TextField txtAMes1;
    @FXML private TextField txtAYear1;
    @FXML private TextField txtADia2;
    @FXML private TextField txtAMes2;
    @FXML private TextField txtAYear2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
            DatabaseController dtb = DatabaseController.getInstance();
    }


    @FXML public void GuardarData()
    {

        int id = Integer.parseInt(txtACampoID.getText());
        String fecha1 = txtAYear1.getText() + "-" + txtAMes1.getText() + "-" + txtADia1.getText();
        String fecha2 = txtAYear2.getText() + "-" + txtAMes2.getText() + "-" + txtADia2.getText();

        try{
            TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getComprasPorCliente(id, Date.valueOf(fecha1), Date.valueOf(fecha2));

            String detalles = "ID cliente: " + id + " | fecha inicial: " + fecha1 + " | fecha final: " + fecha2 +
                    "\nformato:  <ID_cliente>,  <Nombre_Cliente>,  <Apellido_Cliente>,  <Gastos>,  <Fecha_de_Compra>";

            Mediator.getInstance().procesarResultados(Enum_reportes.REPORTE_A, resultados, detalles);

        } catch (Exception e){

        }
    }

    @FXML public void BorrarDatos()
    {

        txtACampoID.setText("");
        txtADia1.setText("");
        txtAMes1.setText("");
        txtAYear1.setText("");
        txtADia2.setText("");
        txtAMes2.setText("");
        txtAYear2.setText("");

    }


}
