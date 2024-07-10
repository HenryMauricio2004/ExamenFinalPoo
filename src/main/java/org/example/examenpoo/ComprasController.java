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
    @FXML private Label lbCampoVacio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        lbCampoVacio.setVisible(false);
    }

    @FXML public void GuardarData()
    {
        if (!valoresVacios()) {

            int id = Integer.parseInt(txtACampoID.getText()); //00183223 obtener id de cliente
            String fecha1 = txtAYear1.getText() + "-" + txtAMes1.getText() + "-" + txtADia1.getText(); //00183223 unir y guardar fecha inicial
            String fecha2 = txtAYear2.getText() + "-" + txtAMes2.getText() + "-" + txtADia2.getText(); //00183223 unir y guardar fecha final

            try {
                TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getComprasPorCliente(id, Date.valueOf(fecha1), Date.valueOf(fecha2)); //00183223 obtener resultados de consulta

                String detalles = "ID cliente: " + id + " | fecha inicial: " + fecha1 + " | fecha final: " + fecha2 + //00183223 especificaciones de busqueda
                        "\nformato:  <ID_Compra>,  <Nombre_Cliente>,  <Apellido_Cliente>,  <Gastos>,  <Fecha_de_Compra>"; //00183223 orden de impresion de los resultados

                Mediator.getInstance().procesarResultados(Enum_reportes.REPORTE_A, resultados, detalles); //00183223 procesar resultados, imprimir resultados, crear archivo txt e imprimir detalles

            } catch (Exception e) {}
        }
    }

    @FXML public void BorrarDatos()
    {

        txtACampoID.setText(""); //00133723 Remplaza el contenido con ""
        txtADia1.setText(""); //00133723 Remplaza el contenido con ""
        txtAMes1.setText(""); //00133723 Remplaza el contenido con ""
        txtAYear1.setText(""); //00133723 Remplaza el contenido con ""
        txtADia2.setText(""); //00133723 Remplaza el contenido con ""
        txtAMes2.setText(""); //00133723 Remplaza el contenido con ""
        txtAYear2.setText(""); //00133723 Remplaza el contenido con ""

    }

    public boolean valoresVacios()
    {
        boolean vacio = false; //00133723 Establecemos que es verdad que el ID esta vacio

        if (txtACampoID.getText().isEmpty()) // 00133723 Buscamos ver si se valida
        {
            lbCampoVacio.setVisible(true); //00133723 Si encuentra se hace visible el label
            vacio = true; //00133723 La funcion dira que si hay valores vacios
        }

        return vacio; //00133723 Devuelve la decision
    }


}
