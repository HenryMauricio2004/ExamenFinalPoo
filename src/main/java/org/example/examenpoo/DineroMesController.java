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

public class DineroMesController implements Initializable {

    @FXML private TextField txtACampoID;
    @FXML private TextField txtACampoMes;
    @FXML private TextField txtACampoAnual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML public void Guardar()
    {
        int fechaYear = Integer.valueOf(txtACampoAnual.getText()); //00183223 obtener año como entero
        int ID = Integer.parseInt(txtACampoID.getText()); //00183223 obtener id de cliente
        int fechaMes= Integer.valueOf(txtACampoMes.getText()); //00183223 obtener mes como entero

        try{
            TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getGastoPorMes(ID, fechaYear, fechaMes); //00183223 obtener resultados de consulta
            String detalles = "ID: " + ID + " | mes: " + fechaMes + " | año: " + fechaYear + //00183223 especificaciones de la busqueda
                    "\nformato:  --,  <Mes-Año> ,  <dineroGastado>"; //00183223 orden en que se imprimen los resultados

            Mediator.getInstance().procesarResultados(Enum_reportes.REPORTE_B, resultados, detalles); //00183223 procesar datos (imprimir resultados, hacer reporte.txt e imprimir detalles)

        } catch (Exception e)
        {
            System.out.println(e.getMessage()); //00133723 Nos devuelve el error durante la ejecucion
        }

    }

    @FXML public void borrar()
    {
        txtACampoID.setText(""); //00133723 Cambia el valor de los campos a ""
        txtACampoMes.setText(""); //00133723 Cambia el valor de los campos a ""
        txtACampoAnual.setText(""); //00133723 Cambia el valor de los campos a ""
    }


}
