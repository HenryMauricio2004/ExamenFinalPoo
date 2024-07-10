package org.example.examenpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TarjetasClienteAplication extends Application
{

    private static TarjetasClienteAplication instance = new TarjetasClienteAplication(); //00133723 Crea el objeto desde el momento que lo invocamos

    private TarjetasClienteAplication(){}

    public static TarjetasClienteAplication getInstance(){
        return instance;
    } //00133723 Nos retorna la instancia

    public void invocarPantalla() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(TarjetasClienteAplication.class.getResource("TarjetasAsociadasPorID.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle("DB");
        stage.setScene(scene);
        stage.show();
    }
}
