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
        lbMessError.setVisible(false); //00133723 Lo hacemos invisible para que emita el error luego
        btmCargar.setVisible(false); //00133723 Nuestro botón para la otra ventana debe de permanecer oculto

    }

    @FXML public void limpiar ()
    {
        textAUsurio.setText(""); //00133723 Para que el usuario no los borre por su cuenta
        txtAClave.setText(""); //00133723 Para que el usuario no los borre por su cuenta
    }

    @FXML public void Acceder ()
    {
        CampoDePruebas CMP = new CampoDePruebas(); //00133723 Creamos la instancia de la clase CampoDePruebas para ejecutar las validaciones necesarias

        if(!CMP.accesoSQL(textAUsurio.getText(), txtAClave.getText())) //00133723 La funcion nos ayuda a informar al usuario que los datos son erroneos
        {
            lbMessError.setVisible(true); //00133723 Para que el usuario vea su error
        }
        else
        {
            lbMessError.setText("Yai"); //00133723 Mensaje de que las cuentas son validad
            btmCargar.setVisible(true); //00133723 Para que el usuario pueda ir a la siguiente ventana
            txtAClave.setVisible(false); //00133723 Para que no escriba nada despues de esto
            textAUsurio.setVisible(false); //00133723 Para que no escriba nada despues de esto
        }
    }

    @FXML public void CargarDB ()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml")); //00133723 creamos un loader para cargar la ventana
            Scene scene = new Scene(loader.load(),700,400); //00133723 Dimensiones para la ventana
            Stage stage = new Stage(); //00133723 Para que se cree la visualizacion de nuestra ventana

            stage.setResizable(false); //00133723 para algo
            stage.setTitle("Buscador personalizado"); //00133723 Nombre del titulo personalizado para la ventana
            stage.setScene(scene); //00133723 Para que pueda saber que ventana va mostrar
            stage.show(); //00133723 Nos muestra ya la ventana

        } catch (IOException e)
        {
            System.out.println(e.getMessage()); //00133723 Error personalizado por si no se ejecuta bien la ventana
        }
    }


}
