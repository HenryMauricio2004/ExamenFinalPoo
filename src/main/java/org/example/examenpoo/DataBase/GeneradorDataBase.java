package org.example.examenpoo.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GeneradorDataBase { //00183223 Clase para crear la base de datos dentro de la computadora del usuario y guardar informacion para manipular la DB

    private String user = null; //00183223 para crear la base de datos se necesita la cuenta mySQL del usuario
    private String password = null; //00183223 por mismos motivos que user, se necesita la contraseña

    static private GeneradorDataBase instance = null;  //00183223 parte de estructura Singleton, solo puede haber 1 generador al contener la informacion de la cuenta mySQL

    private GeneradorDataBase(){ //00183223 parte de estructura Singleton, creador de la Clase GeneradorDataBase
    }

    static public GeneradorDataBase getInstance(){ //00183223 parte de estructura Singleton, unica forma de acceder a la unica instancia de la clase
        if (instance == null){ //00183223 verificar si instance es nula o si ya existe la instancia
            instance = new GeneradorDataBase(); //00183223 en caso de no tener instancia, se le asigna una
        }
        return instance; //00183223 devolver la instancia privada al usuario
    }



    public void createDataBase(){ //00183223 funcion para crear una nueva base de datos en localhost

        if (user != null && password != null){ //00183223 verificar que los valores de usuario y contraseña de mySQL no son nulos
            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", user, password); //00183223 declarar conexion con la DB
                PreparedStatement statement = connection.prepareStatement("CREATE DATABASE RegistrosBCN;"); //00183223 preparar instruccion para crear la base de datos
                statement.executeUpdate(); //00183223 ejecutar la instruccion anterior;

                statement = connection.prepareStatement("USE RegistrosBCN");//00183223 instruccion para cambiar a la base de datos creada
                statement.executeQuery();//00183223 ejecutar cambio de base de datos en mySQL



                statement = connection.prepareStatement( //00183223 ingresar una nueva instruccion para crear una tabla dentro de la DB
                        "CREATE TABLE Cliente(" + //00183223 crear la tabla Cliente
                                "   id_Cliente int NOT NULL PRIMARY KEY AUTO_INCREMENT," + //00183223 declarar clave primaria id_cliente
                                "   nombre varchar(25)," + //00183223 declarar parametro nombre de cliente
                                "   apellido varchar(25));"//00183223 declarar parametro apellido de cliente y cerrar declaracion
                );
                statement.executeUpdate();//00183223 ejecutar creacion de tabla Cliente

                statement = connection.prepareStatement( //00183223 nueva instruccion para crear tabla de los Bancos Asociados
                        "CREATE TABLE Asociado(" + //00183223 crear tabla Asociado
                                "   id_Asociado int NOT NULL PRIMARY KEY AUTO_INCREMENT," + //00183223 declarar clave primaria id_asociado
                                "   nombre varchar(25));" //00183223 declarar parametro de nombre del Asociado y cerrar declaracion
                );
                statement.executeUpdate(); //00183223 ejecutar creacion de tabla Asociado

                statement = connection.prepareStatement( "CREATE TABLE Tarjeta(" + //00183223 nueva instruccion para crear tabla de Tarjetas
                        "   id_tarjeta int NOT NULL PRIMARY KEY AUTO_INCREMENT," + //00183223 declarar clave primaria id_tarjeta
                        "   id_Asociado int NOT NULL," + //00183223 declarar parametro del id del asociado que creo la tarjeta
                        "   id_Cliente int NOT NULL," + //00183223 declarar parametro del id del cliente que utiliza la tarjeta
                        "   index(id_Asociado)," + //00183223 declarar id_asociado como indice para prepararlo como clave foranea
                        "   index(id_Cliente)," + //00183223 declarar id_cliente como indice para prepararlo como clave foranea
                        "   foreign key(id_Asociado) references Asociado(id_Asociado)," + //00183223 definir id_asociado como clave foranea de la tabla asociado
                        "   foreign key(id_Cliente) references Cliente(id_Cliente));" //00183223 definir id_cliente como clave foranea de la tabla cliente y cerrar declaracion
                );
                statement.executeUpdate(); //00183223 ejecutar creacion de tabla Tarjeta

                statement = connection.prepareStatement("CREATE TABLE CompraConTarjeta(" + //00183223 nueva instruccion para crear tabla de registro de compras
                        "   id_Compra int NOT NULL PRIMARY KEY AUTO_INCREMENT," + //00183223 declarar clave primaria id_compra
                        "   id_Tarjeta int NOT NULL," + //00183223 declarar parametro del id de la tarjeta usada en la compra
                        "   montoTotal decimal(6,2) NOT NULL," + //00183223 declarar parametro de monto de dinero gastado en la compra
                        "   index(id_Tarjeta)," + //00183223 definir id_tarjeta como indice para prepararlo como clave foranea
                        "   foreign key(id_Tarjeta) references Tarjeta(id_Tarjeta));"//00183223 definir id_Tarjeta como clave foranea de la tabla tarjeta
                );
                statement.executeUpdate(); //00183223 ejecutar creacion de tabla CompraConTarjeta

                connection.close(); //00183223 cerrar conexion

            } catch (SQLException e){ //00183223 Atrapar error en el procedimiento SQL
                deleteDataBase(); //00183223 eliminar base de datos si ya existe
                createDataBase(); //00183223 crear otra vez la base de datos
            }

        } else{
            System.out.println("fallo, es necesario definir el usuario y contraseña para mySQL"); //00183223 informar error
        }


    }

    private void deleteDataBase(){ //00183223 funcion para borrar la base de datos

        try{ //00183223 probar procedimiento SQL
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", user, password); //00183223 declarar conexion con mySQL
            PreparedStatement statement = connection.prepareStatement("DROP DATABASE RegistrosBCN"); //00183223 preparar instruccion de eliminar base de datos
            statement.executeUpdate(); //00183223 ejecutar eliminacion de base de datos

            connection.close(); //00183223 cerrar conexion
        } catch (SQLException e){ //00183223 atrapar error en el procedimiento SQL
            System.out.println(e); //00183223 Informar error en la consola
        }

    }



    public String getUser() { //00183223 funcion getter para obtener el usuario, necesitamos manipular mySQL varias veces por lo que es necesario
        return user; //00183223 devolver el usuario almacenado
    }

    public void setUser(String user) { //00183223 funcion setter para cambiar el usuario, en el caso del programa solo se usará al iniciar
        this.user = user; //00183223 cambia el valor de user
    }

    public String getPassword() { //00183223 funcion getter para obtener la password de mySQL, necesaria para usar la cuenta
        return password; //00183223 devolver la password de mySQL almacenada
    }

    public void setPassword(String password) { //00183223 funcion setter para cambiar la password, al igual que setUser, solo se planea usar al iniciar el programa
        this.password = password;//00183223 cambia el valor de password
    }
}
