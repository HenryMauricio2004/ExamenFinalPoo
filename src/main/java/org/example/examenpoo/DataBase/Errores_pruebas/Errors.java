package org.example.examenpoo.DataBase.Errores_pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Errors
{

    public int empyName(String value1,String value2)
    {
        int decision = 1; //00133723 validador para indicar si el nombre esta vacio o no

        if(value1.isEmpty() && value2.isEmpty()) // 00133723 verifica si ambas se encuentran vacias
        {
            decision = 0; //00133723 devuelve este valor si ambas casillas se encuentran vacias
        }

        return decision; //00133723 retorna la decision final
    }
    public Connection PruebaConexion(String user,String pass)
    {
        Connection con = null; //00133723 por defecto la conexion es nula

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", user, pass); //00133723 Se manda a llamar el archivo
        }
        catch (SQLException e)
        {
            System.out.println("Error,intente con otro usuario u otra clave de acceso"); //00133723 Error via consola por si ocurrio algo
        }
        return con; //00133723 retorna la conexion establecida o no
    }

}
