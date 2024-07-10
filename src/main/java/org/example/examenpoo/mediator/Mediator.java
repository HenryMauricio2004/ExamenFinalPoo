package org.example.examenpoo.mediator;

import javafx.scene.control.Label;
import org.example.examenpoo.DataBase.Enum_reportes;
import org.example.examenpoo.textBackup.TextFilesGenerator;

import java.util.ArrayList;
import java.util.TreeMap;

public class Mediator { //00183223 clase mediator para comunicar informacion entre las pantallas de solicitud de datos y la pantalla principal de muestra de resultados

    private Label labelDetallesBusqueda; //00183223 referencia al label de la pantalla principal donde se contienen los detalles de filtracion de busqueda en SQL
    private Label labelResultados; //00183223 referencia al label en la ventana principal para manipular su texto

    private static Mediator instance = new Mediator(); //00183223 instancia singleton de mediator

    private Mediator(){} //00183223 constructor de Mediator

    public static Mediator getInstance(){ //00183223 funcion para obtener la instancia singleton de mediator
        return instance; //00183223 retornar la instancia singleton
    }


    public void imprimirTreeMap(TreeMap<Integer, ArrayList<String>> resultados){ //00183223 Funcion para imprimir los resultados de un TreeMap en un label

        labelResultados.setText(""); //00183223 reiniciar el texto del label a vacio

        for (int id: resultados.keySet()){ //00183223 explorar cada key del TreeMap
            labelResultados.setText(labelResultados.getText() + id); //00183223 anexar a la linea la key

            for (String elemento: resultados.get(id)){ //00183223 explorar cada elemento en el ArrayList correspondiente a la key
                labelResultados.setText(labelResultados.getText() + ",   " + elemento); //00183223 anexar el elemento a la linea junto a la key
            }

            labelResultados.setText(labelResultados.getText() + "\n"); //00183223 salto de linea para pasar a la siguiente key del TreeMap
        }

    }

    public void procesarResultados(Enum_reportes tipoReporte, TreeMap<Integer, ArrayList<String>> resultados, String detallesBusqueda){ //00183223 Funcion para utilizar los resultados de una consulta SQL  en la pantalla principal
        labelDetallesBusqueda.setText("Detalles de busqueda: " + detallesBusqueda); //00183223 cambiar el texto de detalles para mostrar las especificaciones del usuario
        imprimirTreeMap(resultados); //00183223 imprimir los resultados en el scroll pane de la pantalla principal
        TextFilesGenerator.getInstance().createBackup(tipoReporte, resultados); //00183223 generar el archivo txt del reporte
    }


    public Label getLabelResultados() { //00183223 funcion para obtener el label referenciado por mediator
        return labelResultados; //00183223 retornar el laber en mediator
    }

    public void setLabelResultados(Label labelResultados) { //00183223 asignar un label a referenciar en mediator
        this.labelResultados = labelResultados; //00183223 cambiar el label actual por el nuevo a referenciar
    }

    public Label getLabelDetallesBusqueda() { //00183223 retornar el label a referenciar en mediador para los detalles de busqueda
        return labelDetallesBusqueda; //00183223 retornar el label en mediator
    }

    public void setLabelDetallesBusqueda(Label labelDetallesBusqueda) { //00183223 asignar un label a referenciar en meddiator para los detalles de busqueda
        this.labelDetallesBusqueda = labelDetallesBusqueda; //00183223 cambiar el label actual por el nuevo referenciado
    }
}
