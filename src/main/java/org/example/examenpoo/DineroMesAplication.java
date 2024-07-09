package org.example.examenpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DineroMesAplication extends Application {
    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(DineroMesAplication.class.getResource("DineroGastadoPorMes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
}