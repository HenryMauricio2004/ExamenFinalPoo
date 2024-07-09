package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

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
    }

    @FXML public void borrarInfo()
    {
        txtACampoID.setText("");
    }
}
