package org.example.examenpoo.DataBase.Errores_pruebas;

import org.example.examenpoo.DataBase.DatabaseController;
import org.example.examenpoo.DataBase.GeneradorDataBase;

public class CampoDePruebas
{


    public boolean accesoSQL(String user,String pass)
    {
        GeneradorDataBase generadorDB = GeneradorDataBase.getInstance();
        Errors errors = new Errors();
        boolean flag = false;

        if (errors.empyName(user,pass) == 1)
        {
            if (errors.PruebaConexion(user,pass)!=null)
            {
                generadorDB.setUser(user);
                generadorDB.setPassword(pass);

                DatabaseController controller = new DatabaseController();

                generadorDB.createDataBase();

                generadorDB.setDefaultRegistrations();

                controller.obtenerTarjetasPorCliente(1);

                flag = true;
            }
        }

        return flag;
    }

}
