package org.example.examenpoo.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class DatabaseController {

    String user; //00183223 guardar usuario mySQL para facilitar su acceso
    String password; //00183223 guardar contraseña mySQL para facilitar su acceso

    public DatabaseController(){ //00183223 constructor de DatabaseController
        user = GeneradorDataBase.getInstance().getUser(); //00183223 obtener user almacenado en GeneradorDataBase
        password = GeneradorDataBase.getInstance().getPassword(); //00183223 obtener contraseña almacenada en GeneradorDataBase
    }


    public TreeMap<Integer, ArrayList<String>> getComprasPorCliente(int id_cliente, Date fechaInicio, Date fechaFinal) throws SQLException { //00183223 funcion para obtener los registros de compra de un cliente en un lapso de tiempo en la DB

        TreeMap<Integer, ArrayList<String>> resultadosBusqueda = new TreeMap<Integer, ArrayList<String>>(); //00183223 TreeMap donde se almacenaran los resultados de busqueda (key -> id_compra)

        Connection connection = null;
        try{ //00183223 intentar procedimiento SQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrosBCN", user, password); //00183223 obtener conexion con DB
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

            ResultSet resultados = statement.executeQuery(); //00183223 ejecutar busqueda

            while (resultados.next()){ //00183223 evaluar cada instancia de los resultados
                ArrayList<String> detalles = new ArrayList<>(); //00183223 declarar array para contener los elementos de los resultados

                detalles.add(resultados.getString("nombre")); //00183223 agregar el nombre del cliente al array
                detalles.add(resultados.getString("apellido")); //00183223 agregar el apellido del cliente al array
                detalles.add(resultados.getFloat("monto") + ""); //00183223 agregar el dinero gastado en la compra al array
                detalles.add(resultados.getDate("fecha").toString()); //00183223 transformar la fecha a String y agregarlo al array

                resultadosBusqueda.put(resultados.getInt("id"), detalles); //00183223 agregar al diccionario el array de detalles y usar el id de la compra como key
            }


        } catch (SQLException e){ //00183223 atrapar error en SQL
            System.out.println(e); //00183223 informar error en consola
        } finally {

            if (!connection.isClosed()){ //00183223 verificar si la conexion aún no ha sido cerrada
                connection.close(); //00183223 cerrar conexion
            }

            return resultadosBusqueda; //00183223 retornar el treeMap generado
        }

    }

    public TreeMap<Integer, ArrayList<String>> getTarjetasAsociado(int id_asociado) throws SQLException { //00183223 funcion para obtener registros sobre los clientes con compras hechas por una tarjeta de Asociado específico

        TreeMap<Integer, ArrayList<String>> resultadosBusqueda = new TreeMap<Integer, ArrayList<String>>(); //00183223 TreeMap donde se almacenaran los resultados de busqueda (key -> id_compra)

        Connection connection = null; //00183223 declarar conexion

        try{ //00183223 intentar procedimiento SQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrosBCN", user, password); //00183223 inicializar conexióñ a DB

            PreparedStatement statement = connection.prepareStatement("select cliente.id_cliente as id_cliente, cliente.nombre as nombre, cliente.apellido as apellido, count(compra.id_compra) as cantCompras, sum(compra.montoTotal) as montoTotal " + //00183223 Seleccionar id, nombre y apellido de cliente, cantidad de compras y suma de monto gastado en todas las compras hechas por el cliente
                    "from compra inner join tarjeta on compra.id_tarjeta = tarjeta.id_tarjeta " + //00183223 obtener datos de intersección entre tabla compra y tarjeta
                    "inner join cliente on tarjeta.id_cliente = cliente.id_cliente " + //00183223 intersectar el inner join anterior con la tabla cliente
                    "where tarjeta.id_asociado = ? " + //00183223 filtrar datos a unicamente donde el id del asociado de la tarjeta sea equivalente a un valor específico
                    "group by cliente.id_cliente;"); //00183223 agrupar datos por id de cliente (obligatorio por usar funciones sum() y count())

            statement.setInt(1, id_asociado); //00183223 reemplazar primer ? por el id_asociado ingresado por el usuario

            ResultSet resultados = statement.executeQuery(); //00183223 ejecutar busqueda

            while (resultados.next()){ //00183223 evaluar cada instancia de los resultados

                ArrayList<String> detalles = new ArrayList<>(); //00183223 declarar array para contener los elementos de los resultados

                detalles.add(resultados.getString("nombre")); //00183223 agregar el nombre del cliente al array
                detalles.add(resultados.getString("apellido")); //00183223 agregar el apellido del cliente al array
                detalles.add(resultados.getInt("cantCompras") + ""); //00183223 agregar el nombre del cliente al array
                detalles.add(resultados.getFloat("montoTotal") + ""); //00183223 agregar el nombre del cliente al array

                resultadosBusqueda.put(resultados.getInt("id_cliente"), detalles); //00183223 agregar al diccionario el array de detalles y usar el id del cliente como key
            }

        } catch (SQLException e){ //00183223 atrapar error SQL
            System.out.println(e); //00183223 informar error por consola
        }finally{

            if(!connection.isClosed()){ //00183223 verificar si la conexión aún no ha sido cerrada
                connection.close(); //00183223 cerrar la conexión SQL
            }

            return resultadosBusqueda; //00183223 retornar los resultados de la busqueda
        }

    }


}
