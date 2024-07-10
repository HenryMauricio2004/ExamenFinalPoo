package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.example.examenpoo.DataBase.Enum_reportes;
import org.example.examenpoo.mediator.Mediator;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class TarjetasClienteController implements Initializable
{

    @FXML private TextField txtACampoID;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML public void guardarInfo()
    {
        int ID = Integer.parseInt(txtACampoID.getText()); //00183223 obtener id de cliente

        try{
            TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getTarjetasPorCliente(ID); //00183223 obtener resultados de consulta

            String detalles = "ID: " + ID + //00183223 detalles de especificaciones de busqueda
                    "\nformato:  <ID_tarjeta>,  <Tipo_tarjeta>,  <Numero_tarjeta>,  <Fecha_de_expiracion>"; //00183223 orden de impresion de resultados

            Mediator.getInstance().procesarResultados(Enum_reportes.REPORTE_C, resultados, detalles); //00183223 procesar resultados, imprimirlos, crear archivos txt e imprimir detalles

        } catch (Exception e){

        }

    }

    @FXML public void borrarInfo()
    {
        txtACampoID.setText("");
    } //00133723 Borra la informacion dentro de los bloques
}
