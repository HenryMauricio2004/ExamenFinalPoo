package org.example.examenpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DineroMesAplication extends Application {

    private static DineroMesAplication instance = new DineroMesAplication(); //00133723 Para que al momento de llamarla se crea su instancia

    private DineroMesAplication() {}

    public static DineroMesAplication getInstance() {return instance;} //00133723 Nos retornaria la representacion del objeto

    public void invocarPantalla() throws Exception {
        start(new Stage()); //Comienza el proceso para que se invoque la pantalla
    }

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
