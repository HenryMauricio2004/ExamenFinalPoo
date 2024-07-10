package org.example.examenpoo.DataBase.models;

import org.example.examenpoo.DataBDAplication;
import org.example.examenpoo.DataBase.GeneradorDataBase;
import org.example.examenpoo.DatabaseController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facilitador {

    private int id;//00030123  el identificador de la tarjeta del cliente
    private String nombre;//00030123 el nombre del cliente

    public Facilitador(int id, String nombre){
        this.id = id;//00030123 se le asigna el identificador a la tarjeta
        this.nombre = nombre;//0003023 se le asigna el nombre a la tarjeta
    }

    public int getId() {
        return id;//00030123 Obtienen el identificador de la tarjeta
    }

    public void setId(int id) {
        this.id = id;//00030123 Asigna el identificador de la tarjeta
    }

    public String getNombre() {
        return nombre;//00030123 Obtiene el nombre del clienete asociada a la tarjeta
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;//0003123 Asigna el nombre del cliente asociadao a la tarjeta
    }

    public List<TarjetaCliente> getAllTarjetaCliente() throws SQLException{
        List<TarjetaCliente> asociados = new ArrayList<>();

        try {
            Connection connection = (Connection) DatabaseController.getInstance().getFacilitadores();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Tarjetas");

            while (resultSet.next()){
                int idTarjeta = resultSet.getInt("Tarjeta ID");
                String tipoTarjeta = resultSet.getString("Tipo de Tarjeta");
                String numTarjeta = resultSet.getString("Numero de la Tarjeta");
                Date fechaExpiracion = resultSet.getDate("Fecha de expiracion");
                String facilitador = resultSet.getString("Facilitador de tarjeta");

                TarjetaCliente tarjetaCliente = new TarjetaCliente(idTarjeta , tipoTarjeta , numTarjeta , fechaExpiracion , facilitador);
                asociados.add(tarjetaCliente);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return asociados;
    }
}
