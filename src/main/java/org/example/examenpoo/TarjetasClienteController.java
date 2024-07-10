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
        int ID = Integer.parseInt(txtACampoID.getText());
        //FUNCION AQUI PARA SQL
        try{
            TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getTarjetasPorCliente(ID);

            String detalles = "ID: " + ID +
                    "\nformato:  <ID_tarjeta>,  <Tipo_tarjeta>,  <Numero_tarjeta>,  <Fecha_de_expiracion>";;

            Mediator.getInstance().procesarResultados(Enum_reportes.REPORTE_C, resultados, detalles);

        } catch (Exception e){

        }

    }

    @FXML public void borrarInfo()
    {
        txtACampoID.setText("");
    }
}
