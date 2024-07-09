package org.example.examenpoo.DataBase.Errores_pruebas;

import org.example.examenpoo.DatabaseController;
import org.example.examenpoo.DataBase.GeneradorDataBase;

public class CampoDePruebas
{

    public boolean accesoSQL(String user,String pass)
    {
        GeneradorDataBase generadorDB = GeneradorDataBase.getInstance(); //00133723 Mandamos a llamar la instancia BD
        Errors errors = new Errors(); //00133723 Creamos a los Errors para validar errores
        boolean flag = false; //00133723 por defecto le decimos que no se ha cumplido nada

        if (errors.empyName(user,pass) == 1) //00133723 Evaluacion gracias a la clase Errors
        {
            if (errors.PruebaConexion(user,pass)!=null) //00133723 Le preguntamos si fue posible crear la conexion
            {
                generadorDB.setUser(user); //00133723 mandamos el usuario ya para uso
                generadorDB.setPassword(pass); //00133723 mandamos la contraseña para uso

                DatabaseController controller = DatabaseController.getInstance(); //00133723 Iniciamos ya con la creacion de la base de datos


                generadorDB.createDataBase(); //00133723 Se crea la base de datos

                generadorDB.setDefaultRegistrations(); //00133723 Se pobla la DB

                flag = true; //00133723 Si todo salio bien, entonces nos devolvera un true
            }
        }

        return flag; //00133723 retorno para la ultima evaluacion
    }

}
