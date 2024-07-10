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

    public List<TarjetaCliente> getAllTarjetaCliente() throws SQLException{
        List<TarjetaCliente> asociados = new ArrayList<>();

        try(Connection connection = GeneradorDataBase.getInstance();
            Statement statement = connection.createStatement();) {

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
        }
        return asociados;
    }
}
