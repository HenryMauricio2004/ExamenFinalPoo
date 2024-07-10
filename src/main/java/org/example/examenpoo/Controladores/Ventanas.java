package org.example.examenpoo.Controladores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.examenpoo.DataBDAplication;

import java.io.IOException;

public class Ventanas extends Application {

    private String ventana;
    private String nombre;

    public Ventanas (String ventana,String nombre)
    {
        this.ventana = ventana;
        this.nombre = nombre;
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(DataBDAplication.class.getResource(ventana+".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle(nombre);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}