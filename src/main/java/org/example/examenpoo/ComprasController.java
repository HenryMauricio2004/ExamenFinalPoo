package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ComprasController implements Initializable
{

    @FXML private TextField txtACampoID;
    @FXML private TextField txtACampoFecha1;
    @FXML private TextField txtACampoFecha2;
    @FXML private Label lbCampoVacio;
    @FXML private Label lbCampoVacio2;
    @FXML private Label lbCampoVacio3;
    @FXML private Button btmRegresar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML public void GuardarData() throws SQLException {

        if(!(txtACampoID.getText().isBlank() && txtACampoFecha1.getText().isBlank()&&txtACampoFecha2.getText().isBlank()))
        {

            DatabaseController dtb = new DatabaseController();

            int value = Integer.parseInt(txtACampoID.getText());
            Date fecha = Date.valueOf(txtACampoFecha1.getText());
            Date fecha2 = Date.valueOf(txtACampoFecha2.getText());

            System.out.println("Funciona");

            //dtb.getComprasPorCliente(value,fecha,fecha2);

        }
        else
        {
            lbCampoVacio.setVisible(true);
            lbCampoVacio2.setVisible(true);
            lbCampoVacio3.setVisible(true);
        }
    }

    @FXML public void BorrarDatos()
    {
        txtACampoID.setText("");
        txtACampoFecha1.setText("");
        txtACampoFecha2.setText("");
    }


}
