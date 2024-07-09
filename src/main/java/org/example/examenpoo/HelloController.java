package org.example.examenpoo;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

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