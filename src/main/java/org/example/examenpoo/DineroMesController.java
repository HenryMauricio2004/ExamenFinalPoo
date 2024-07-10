package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    @FXML private Label lbCampo0;
    @FXML private Label lbCampo1;
    @FXML private Label lbCampo02;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        lbCampo0.setVisible(false); //00133723 Para que el usuario no vea el mensaje
        lbCampo1.setVisible(false);//00133723 Para que el usuario no vea el mensaje
        lbCampo02.setVisible(false);//00133723 Para que el usuario no vea el mensaje
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

        } catch (Exception e){

        }
    }

    @FXML public void borrar()
    {
        txtACampoID.setText(""); //00133723 Remplaza los valores a ""
        txtACampoMes.setText(""); //00133723 Remplaza los valores a ""
        txtACampoAnual.setText(""); //00133723 Remplaza los valores a ""
    }

}
