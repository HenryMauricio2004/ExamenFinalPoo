package org.example.examenpoo;

import javafx.fxml.Initializable;
import org.example.examenpoo.DataBase.DatabaseController;
import org.example.examenpoo.DataBase.Errores_pruebas.CampoDePruebas;
import org.example.examenpoo.DataBase.Errores_pruebas.Errors;
import org.example.examenpoo.DataBase.GeneradorDataBase;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TreeMap;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CampoDePruebas CMP = new CampoDePruebas();

        boolean flag = false;

        while (!flag)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese usuario mySQL:");
            String user = scanner.nextLine();

            System.out.println("Ingrese password mySQL:");
            String password = scanner.nextLine();

            flag = CMP.accesoSQL(user,password);
        }
    }

    private void imprimirTreeMap(TreeMap<Integer, ArrayList<String>> treeMap){

        for (int id: treeMap.keySet()){
            System.out.print(id);
            for (String elemento: treeMap.get(id)){
                System.out.print(" : " +  elemento);
            }
            System.out.println();
        }

    }

}