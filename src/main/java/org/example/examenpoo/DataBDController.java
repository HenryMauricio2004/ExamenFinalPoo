package org.example.examenpoo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.examenpoo.DataBase.Errores_pruebas.CampoDePruebas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataBDController implements Initializable
{

    @FXML private Label lbMessError;
    @FXML private TextField textAUsurio;
    @FXML private TextField txtAClave;
    @FXML private Button btmCargar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        lbMessError.setVisible(false);
        btmCargar.setVisible(false);


    }

    @FXML public void limpiar ()
    {
        textAUsurio.setText("");
        txtAClave.setText("");
    }

    @FXML public void Acceder ()
    {
        CampoDePruebas CMP = new CampoDePruebas();

        if(!CMP.accesoSQL(textAUsurio.getText(), txtAClave.getText()))
        {
            lbMessError.setVisible(true);
        }
        else
        {
            lbMessError.setText("Yai");
            btmCargar.setVisible(true);
            txtAClave.setVisible(false);
            textAUsurio.setVisible(false);
        }
    }

    @FXML public void CargarDB ()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(loader.load(),700,400);
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Busquedas DB");
            stage.setScene(scene);
            stage.show();
            stage.show();

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
