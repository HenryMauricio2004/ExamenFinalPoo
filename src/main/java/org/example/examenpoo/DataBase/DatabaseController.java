package org.example.examenpoo.DataBase;

import org.example.examenpoo.DataBase.models.TarjetaCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class DatabaseController {

    String user; //00183223 guardar usuario mySQL para facilitar su acceso
    String password; //00183223 guardar contraseña mySQL para facilitar su acceso
    String connectionString = "jdbc:mysql://localhost:3306/RegistrosBCN"; //00082023 Cadena de conexión para la base de datos MySQL ubicada en localhost, utilizando la base de datos "RegistrosBCN"

    public DatabaseController(){ //00183223 constructor de DatabaseController
        user = GeneradorDataBase.getInstance().getUser(); //00183223 obtener user almacenado en GeneradorDataBase
        password = GeneradorDataBase.getInstance().getPassword(); //00183223 obtener contraseña almacenada en GeneradorDataBase
    }


    public TreeMap<Integer, ArrayList<String>> getComprasPorCliente(int id_cliente, Date fechaInicio, Date fechaFinal){ //00183223 funcion para obtener los registros de compra de un cliente en un lapso de tiempo en la DB

        TreeMap<Integer, ArrayList<String>> resultadosBusqueda = new TreeMap<Integer, ArrayList<String>>(); //00183223 TreeMap donde se almacenaran los resultados de busqueda (key -> id_compra)

        ResultSet resultados = null; //00183223 ResultSet que se retornará (fuera del try para asegurar que siempre exista)
        try{ //00183223 intentar procedimiento SQL
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrosBCN", user, password); //00183223 obtener conexion con DB
            PreparedStatement statement = connection.prepareStatement( //00183223 preparar instruccion SQL
                    "SELECT cliente.id_cliente as id_cliente, cliente.nombre as nombre, cliente.apellido as apellido, " + //00183223 seleccionar id, nombre y apellido de cliente
                            "compra.id_compra as id, compra.montoTotal as monto, compra.fecha " + //00183223 seleccionar id, monto y fecha de compra
                            "FROM compra INNER JOIN tarjeta ON compra.id_tarjeta = tarjeta.id_tarjeta " + //00183223 intersectar tablas de compra y tarjeta para acceder al id del cliente en la tabla tarjeta
                            "INNER JOIN cliente ON tarjeta.id_cliente = cliente.id_cliente WHERE cliente.id_cliente = ? " + //00183223 ahora con la intersección con la tabla cliente, y filtrar a solo las que comparten mismo id de cliente
                            "AND compra.fecha between ? and ? ;" //00183223 unicamente las compras de la tarjeta que se hayan hecho entre las 2 fechas especificadas

            );

            statement.setInt(1, id_cliente); //00183223 reemplazar primer ? por el id de cliente dado por el usuario
            statement.setDate(2, fechaInicio); //00183223 reemplazar segundo ? por la fecha de inicio de lapso
            statement.setDate(3, fechaFinal);//00183223 reemplazar tercer ? por la fecha de final de lapso

            resultados = statement.executeQuery(); //00183223 ejecutar busqueda

            while (resultados.next()){ //00183223 evaluar cada instancia de los resultados
                ArrayList<String> detalles = new ArrayList<>(); //00183223 declarar array para contener los elementos de los resultados

                detalles.add(resultados.getString("nombre")); //00183223 agregar el nombre del cliente al array
                detalles.add(resultados.getString("apellido")); //00183223 agregar el apellido del cliente al array
                detalles.add(resultados.getFloat("monto") + ""); //00183223 agregar el dinero gastado en la compra al array
                detalles.add(resultados.getDate("fecha").toString()); //00183223 transformar la fecha a String y agregarlo al array

                resultadosBusqueda.put(resultados.getInt("id"), detalles); //00183223 agregar al diccionario el array de detalles y usar el id de la compra como key
            }

            connection.close(); //00183223 cerrar conexion
        } catch (SQLException e){ //00183223 atrapar error en SQL
            System.out.println(e); //00183223 informar error en consola
        } finally {
            return resultadosBusqueda; //00183223 retornar el treeMap generado
        }
    }
    public double obtenerGastoPorMes(int idCliente, int year, int month) { //00082023 Método para obtener el gasto por año y mes del cliente
        double montoTotal = 0.0;
        try { //00082023 Prepara la consulta SQL
            Connection connection = DriverManager.getConnection(connectionString, user, password); //00082023 Conexión a la base de datos
            PreparedStatement statement = connection.prepareStatement( //00082023 Preparación de la consulta SQL
                    "SELECT SUM(montoTotal) as dineroGastado" +
                            "FROM compra c" +
                            "INNER JOIN tarjeta t ON c.id_Tarjeta = t.id_Tarjeta" +
                            "INNER JOIN cliente cl ON cl.id_Cliente = t.id_Cliente" +
                            "WHERE cl.id_Cliente = ? AND MONTH(c.fecha) = ? AND YEAR(c.fecha) = ?"
            ); //00082023 Fin de la preparación de la consulta

            statement.setInt(1, idCliente);
            statement.setInt(2, month);
            statement.setInt(3, year);
            ResultSet resultados = statement.executeQuery(); //00082023 Ejecución de la consulta y obtención de resultados

            while (resultados.next()) { //00082023 Iteración sobre los resultados
                montoTotal = resultados.getFloat ("dineroGastado");

            }

            System.out.println(montoTotal); //00082023 Imprimir el monto total
        } catch (SQLException e){ //00082023 Captura de excepciones SQL
            System.out.println(e); //00082023 Imprimir la excepción
        }
        return montoTotal; //00082023 Retornar el monto total
    }

    public ArrayList<TarjetaCliente> obtenerTarjetasPorCliente(int idCliente) { //00082023 Método para obtener tarjetas por cliente
        ArrayList<TarjetaCliente> tarjetas = new ArrayList<>(); //00082023 Establece la conexión a la base de datos

        try { //00082023 Prepara la consulta SQL
            Connection connection = DriverManager.getConnection(connectionString, user, password); //00082023 Conexión a la base de datos
            PreparedStatement statement = connection.prepareStatement( //00082023 Preparación de la consulta SQL
                    "SELECT id_Tarjeta, tipoTarjeta, numTarjeta, fechaExpiracion " + //00082023 Selección de columnas
                            "FROM tarjeta " + //00082023 Tabla de la que se seleccionan los dato
                            "WHERE id_Cliente = ?" //00082023 Condición para el cliente específico
            ); //00082023 Fin de la preparación de la consulta

            statement.setInt(1, idCliente); //00082023 Establecer el id del cliente en la consulta
            ResultSet resultados = statement.executeQuery(); //00082023 Ejecución de la consulta y obtención de resultados

            while (resultados.next()) { //00082023 Iteración sobre los resultados
                int idTarjeta = resultados.getInt("id_Tarjeta"); //00082023 Obtener id de la tarjeta
                String tipoTarjeta = resultados.getString("tipoTarjeta"); //00082023 Obtener tipo de tarjeta
                String numTarjeta = resultados.getString("numTarjeta"); //00082023 Obtener número de tarjeta
                Date fechaExpiracion = resultados.getDate("fechaExpiracion"); //00082023 Obtener fecha de expiración

                TarjetaCliente tarjeta = new TarjetaCliente(idTarjeta, tipoTarjeta, censurarNumTarjeta(numTarjeta), fechaExpiracion); //00082023 Crear objeto TarjetaCliente
                tarjetas.add(tarjeta); //00082023 Agregar la tarjeta a la lista
            }

            System.out.println(tarjetas); //00082023 Imprimir la lista de tarjetas
        } catch (SQLException e){ //00082023 Captura de excepciones SQL
            System.out.println(e); //00082023 Imprimir la excepción
        }
        return tarjetas; //00082023 Retornar la lista de tarjetas
    }
    private String censurarNumTarjeta(String numeroTarjeta) { //00082023 Método para censurar el número de la tarjeta
        int length = numeroTarjeta.length(); //00082023 Obtener la longitud del número de tarjeta
        String ultimosCuatro = numeroTarjeta.substring(length - 4); //00082023 Obtener los últimos cuatro dígitos
        return "XXXX XXXX XXXX " + ultimosCuatro; //00082023 Retornar el número censurado mediante las "X"
    }
}
