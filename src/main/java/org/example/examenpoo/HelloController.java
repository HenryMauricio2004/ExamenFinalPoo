package org.example.examenpoo;

import javafx.fxml.Initializable;
import org.example.examenpoo.DataBase.GeneradorDataBase;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GeneradorDataBase generadorDB = GeneradorDataBase.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese usuario mySQL:");
        String user = scanner.nextLine();

        System.out.println("Ingrese password mySQL:");
        String password = scanner.nextLine();

        generadorDB.setUser(user);
        generadorDB.setPassword(password);

        generadorDB.createDataBase();
    }


}