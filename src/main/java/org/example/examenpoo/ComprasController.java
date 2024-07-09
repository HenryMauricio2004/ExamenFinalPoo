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

    //Para la funcion

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
