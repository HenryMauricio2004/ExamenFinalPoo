package org.example.examenpoo.DataBase;

import java.sql.*;

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

        if (user != null && password != null){ //00183223 verificar que los valores de usuario y contraseña de mySQL no son nulos para usar mySQL
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
                        "   tipoTarjeta varchar(15), " + //00183223 declarar parametro del tipo de tarjeta (credito o debito)
                        "   index(id_Asociado)," + //00183223 declarar id_asociado como indice para prepararlo como clave foranea
                        "   index(id_Cliente)," + //00183223 declarar id_cliente como indice para prepararlo como clave foranea
                        "   foreign key(id_Asociado) references Asociado(id_Asociado)," + //00183223 definir id_asociado como clave foranea de la tabla asociado
                        "   foreign key(id_Cliente) references Cliente(id_Cliente));" //00183223 definir id_cliente como clave foranea de la tabla cliente y cerrar declaracion
                );
                statement.executeUpdate(); //00183223 ejecutar creacion de tabla Tarjeta

                statement = connection.prepareStatement("CREATE TABLE Compra(" + //00183223 nueva instruccion para crear tabla de registro de compras
                        "   id_Compra int NOT NULL PRIMARY KEY AUTO_INCREMENT," + //00183223 declarar clave primaria id_compra
                        "   id_Tarjeta int NOT NULL," + //00183223 declarar parametro del id de la tarjeta usada en la compra
                        "   montoTotal decimal(6,2) NOT NULL," + //00183223 declarar parametro de monto de dinero gastado en la compra
                        "   fecha date," + //00183223 declarar parametro de fecha cuando se hizo la compra
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

    public void setDefaultRegistrations(){ //00183223 funcion para crear valores default en la DB (solo son para facilitar probar las funciones SQL :P)

        String[] tarjeta = {"Credito", "Debito"}; //00183223 arreglo para facilitar especificar entre tarjetas de credito y debito

        //8 clientes
        updateCliente("Jonathan", "Escobar"); //00183223 nuevo cliente para pruebas del programa y SQL
        updateCliente("Mario","Bermez"); //00183223 nuevo cliente para pruebas del programa y SQL
        updateCliente("Carlos","Guevara"); //00183223 nuevo cliente para pruebas del programa y SQL //00183223 nuevo cliente para pruebas del programa y SQL
        updateCliente("Matteo","Gutierrez"); //00183223 nuevo cliente para pruebas del programa y SQL
        updateCliente("Ariana","Grande"); //00183223 nuevo cliente para pruebas del programa y SQL
        updateCliente("Maria","Grande"); //00183223 nuevo cliente para pruebas del programa y SQL
        updateCliente("Ursula","Martinez"); //00183223 nuevo cliente para pruebas del programa y SQL
        updateCliente("Yenifer","Guevara"); //00183223 nuevo cliente para pruebas del programa y SQL

        //5 asociados
        updateAsociado("Banco Agricola"); //00183223 nuevo asociado para pruebas del programa y SQL
        updateAsociado("Banco Hipotecário"); //00183223 nuevo asociado para pruebas del programa y SQL
        updateAsociado("Daviviena"); //00183223 nuevo asociado para pruebas del programa y SQL
        updateAsociado("Mi Banco"); //00183223 nuevo asociado para pruebas del programa y SQL
        updateAsociado("Comedica"); //00183223 nuevo asociado para pruebas del programa y SQL


        //9 tarjetas
        updateTarjeta(1,1,tarjeta[0]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(1,2,tarjeta[1]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(2,1,tarjeta[1]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(3,3,tarjeta[0]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(4,3,tarjeta[1]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(5,4,tarjeta[1]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(6,5,tarjeta[0]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(7,4,tarjeta[1]); //00183223 nueva tarjeta para pruebas del programa y SQL
        updateTarjeta(8,2,tarjeta[0]); //00183223 nueva tarjeta para pruebas del programa y SQL

        //10 Compras
        updateCompra(1,34.87f, Date.valueOf("2023-12-30")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(1,10.99f, Date.valueOf("2024-01-11")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(1,9.00f, Date.valueOf("2024-01-12")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(2,45.60f, Date.valueOf("2024-03-27")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(2,12.50f, Date.valueOf("2024-05-21")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(3,1.25f, Date.valueOf("2023-12-25")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(3,36.88f, Date.valueOf("2024-05-22")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(4,4.76f, Date.valueOf("2024-11-22")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(4,48.87f, Date.valueOf("2024-12-13")); //00183223 nueva Compra para pruebas del programa y SQL
        updateCompra(5,99.00f, Date.valueOf("2024-09-30")); //00183223 nueva Compra para pruebas del programa y SQL



    }

    public void updateCliente(String nombre, String apellido){//00183223 funcion para crear un nuevo cliente en la DB
        try{ //00183223 intentar procedimiento SQL

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrosbcn", user, password); //00183223 crear conexion a DB

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Cliente (nombre, apellido) VALUES (?,?)");  //00183223 preparar instruccion para ingresar nombre y apellido a tabla cliente
            statement.setString(1, nombre); //00183223 reemplazar primer ? por el nombre del cliente a ingresar
            statement.setString(2, apellido); //00183223 reemplazar segundo ? por el apellido del cliente a ingresar

            statement.executeUpdate(); //00183223 ejecutar creacion de nuevo cliente en tabla Cliente

            connection.close(); //00183223 cerrar conexion
        } catch (SQLException e){ //00183223 atrapar error en SQL
            System.out.println(e); //00183223 informar error en consola
        }
    }

    public void updateAsociado(String nombre){ //00183223 funcion para crear un nuevo banco asociado en la DB
        try{ //00183223 intentar procedimiento SQL

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrosbcn", user, password); //00183223 obtener conexion con DB

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Asociado(nombre) VALUES (?)"); //00183223 preparar instruccion para insertar nombre de nuevo asociado
            statement.setString(1, nombre); //00183223 reemplazar ? por el nombre dado por el usuario

            statement.executeUpdate(); //00183223 ejecutar creacion de nuevo asociado

            connection.close(); //00183223 cerrar conexion
        } catch (SQLException e){ //00183223 atrapar error en SQL
            System.out.println(e); //00183223 informar error en consola
        }
    }

    public void updateTarjeta(int id_cliente,int id_asociado, String tipoTarjeta){ //00183223 funcion para crear nueva tarjeta en DB
        try{ //00183223 intentar procedimiento SQL

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrosbcn", user, password); //00183223 obtener conexion con DB

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Tarjeta(id_Asociado, id_Cliente, tipoTarjeta) VALUES (?, ?, ?)"); //00183223 preparar instruccion para crear nueva tarjeta
            statement.setInt(1, id_asociado); //00183223 reemplazar primer ? por id de banco asociado dado por el usuario
            statement.setInt(2, id_cliente); //00183223 reemplazar segundo ? por id de cliente dueño de la tarjeta dado por el usuario
            statement.setString(3, tipoTarjeta); //00183223 reemplazar tercer ? por el tipo de tarjeta (credito o debito) dado por el usuario

            statement.executeUpdate(); //00183223 ejecutar creacion de tarjeta en DB

            connection.close(); //00183223 cerrar conexion
        } catch (SQLException e){ //00183223 atrapar error en SQL
            System.out.println(e); //00183223 informar error en consola
        }
    }

    public void updateCompra(int id_tarjeta, float montoTotal, Date fecha){ //00183223 funcion para crear una Compra en DB
        try{ //00183223 intentar procedimiento SQL

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrosbcn", user, password); //00183223 obtener conexion con DB

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Compra(id_tarjeta, montoTotal, fecha) VALUES (?, ?, ?)"); //00183223 preparar instruccion para crear nueva compra
            statement.setInt(1, id_tarjeta); //00183223 insertar id de tarjeta dada por el usuario
            statement.setFloat(2,  montoTotal); //00183223 insertar monto de dinero gastado dado por el usuario
            statement.setDate(3, fecha); //00183223 insertar fecha de compra dada por el usuario

            statement.executeUpdate(); //00183223 ejecutar creacion de compra

            connection.close(); //00183223 cerrar conexion
        } catch (SQLException e){ //00183223 atrapar error en SQL
            System.out.println(e); //00183223 informar error en consola
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
