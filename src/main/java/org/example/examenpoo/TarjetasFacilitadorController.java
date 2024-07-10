package org.example.examenpoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.example.examenpoo.DataBase.models.Facilitador;
import org.example.examenpoo.DataBase.models.TarjetaCliente;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TarjetasFacilitadorController implements Initializable {

    @FXML private ComboBox cmbFacilitadores;
    private Facilitador facilitador;
    private final ObservableList <String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //ArrayList<Facilitador> facilitadores = null; 00030123 se inicia el arraylist de facilitadores
        /*try {
        * facilitadores =  DatabaseController.getInstance().getFacilitadores(); //00030123 se le asigna la lista de facilitadores a la variable facilitadores
        * }catch (SQLException e){
        * trow new RuntimeException(e);//00030123 si hay error se lanza una excepcion
        * {*/

        //cmbFacilitadores.getItems().addAll(facilitadores);//00030123 se le asigna la lista de facilitadores a la lista del comboBox
        list.addAll("mike","Si","Yeha");//Debe de ser por medio de consulta esta parte
        cmbFacilitadores.getItems().addAll(list);
    }

        
    @FXML public void cargarInfo() throws SQLException {

        //Facilitador facilitador = cmbFacilitadores.getValue();//00030123 se le asigna el facilitador seleccionado a la variable facilitador del comboBox y debe de ser por medio de consulta
        //TreeMap<Integer, ArrayList<String>> resultados = DatabaseController.getInstance().getTarjetasAsociadas(facilitador.getId());//00030123 se le asigna los resultados de la consulta a la variable resultados
        //String detalles = "Facilitador: " + facilitador.getNombre() + ............;//00030123 especificaciones de la busqueda a relaizar

        //Mediator.getInstance().procesarResultados(Enum_reportes.TARJETAS_ASOCIADAS, resultados, detalles);//00030123 se le pasa los resultados y las especificaciones, crear archivo txt


        int id = 0;//00030123 se inicia el valor del id en la nueva clase para poder crecar el nuevo facilitaor de la tarjeta
        String nombre = "";//00030123 se inicia el valor del nombre vacio para que se vayan guardando los nuevos nombres

        facilitador = new Facilitador(id , nombre);//00030123 se crea el nuevo facilitador de la tarjeta con las variables antes dadas que es el id de la tarjeta y el nombre del cliente

        try {
            List<TarjetaCliente> asociados = facilitador.getAllTarjetaCliente();//00030123 se le asigna a la lista de las tarjetas de lo clientes y se les agraga todos los facilitadores o el facilitador que tiene esa tarjeta 
            cmbFacilitadores.getItems().addAll(asociados);
        }catch (SQLException e){
            e.printStackTrace();
        }
        DatabaseController.getInstance().getFacilitadores();
        System.out.println(cmbFacilitadores.getSelectionModel().getSelectedItem());
    }
}