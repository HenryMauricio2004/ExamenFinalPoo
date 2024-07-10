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
        int fechaYear = Integer.valueOf(txtACampoAnual.getText());
        int ID = Integer.parseInt(txtACampoID.getText());
        int fechaMes= Integer.valueOf(txtACampoMes.getText());

        try{
            TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getGastoPorMes(ID, fechaYear, fechaMes);
            String detalles = "ID: " + ID + " | mes: " + fechaMes + " | año: " + fechaYear +
                    "\nformato:  --,  <Mes-Año> ,  <dineroGastado>";;

            Mediator.getInstance().procesarResultados(Enum_reportes.REPORTE_B, resultados, detalles);

        } catch (Exception e){

        }

    }

    @FXML public void borrar()
    {
        txtACampoID.setText("");
        txtACampoMes.setText("");
        txtACampoAnual.setText("");
    }


}
