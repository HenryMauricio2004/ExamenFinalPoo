package org.example.examenpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComprasAplication extends Application
{
    private static ComprasAplication instance = new ComprasAplication();

    private ComprasAplication(){}

    public static ComprasAplication getInstance(){
        return instance;
    }

    public void invocarPantalla() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ComprasRealizadas.fxml")); //00133723 creamos un loader para cargar la ventana
        Scene scene = new Scene(loader.load(),700,400); //00133723 Dimensiones para la ventana

        stage.setResizable(false); //00133723 para algo
        stage.setTitle("Busquedas DB"); //00133723 Nombre del titulo personalizado para la ventana
        stage.setScene(scene); //00133723 Para que pueda saber que ventana va mostrar
        stage.show(); //00133723 Nos muestra ya la ventana
    }
}
