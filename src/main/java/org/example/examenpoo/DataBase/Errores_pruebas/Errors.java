package org.example.examenpoo.DataBase.Errores_pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Errors
{

    public int empyName(String value1,String value2)
    {
        int decision = 1;

        if(value1.isEmpty() && value2.isEmpty())
        {
            System.out.println("fallo, es necesario definir el usuario y contraseña para mySQL");

            decision = 0; //Si hay nada devuelve el valor error 1
        }

        return decision;
    }
    public Connection PruebaConexion(String user,String pass)
    {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", user, pass);
        }
        catch (SQLException e)
        {
            System.out.println("Error,intente con otro usuario u otra clave de acceso");
        }
        return con;
    }

}
