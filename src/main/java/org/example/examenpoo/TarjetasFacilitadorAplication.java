package org.example.examenpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TarjetasFacilitadorAplication extends Application
{
    private static TarjetasFacilitadorAplication instance = new TarjetasFacilitadorAplication();

    private TarjetasFacilitadorAplication(){}

    public static TarjetasFacilitadorAplication getInstance(){
        return instance;
    }

    public void invocarPantalla() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(TarjetasFacilitadorAplication.class.getResource("TarjetasAsociadasPorID.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle("DB");
        stage.setScene(scene);
        stage.show();
    }
}
