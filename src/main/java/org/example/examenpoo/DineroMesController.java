package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

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
       Date fechaYear = Date.valueOf(txtACampoAnual.getText());
        int ID = Integer.parseInt(txtACampoID.getText());
        Date fechaMes= Date.valueOf(txtACampoMes.getText());
    }

    @FXML public void borrar()
    {
        txtACampoID.setText("");
        txtACampoMes.setText("");
        txtACampoAnual.setText("");
    }


}
