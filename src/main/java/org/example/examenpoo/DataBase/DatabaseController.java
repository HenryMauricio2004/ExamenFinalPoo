package org.example.examenpoo.DataBase;

public class DatabaseController {

    String user;
    String password;

    public DatabaseController(){
        user = GeneradorDataBase.getInstance().getUser();
        password = GeneradorDataBase.getInstance().getPassword();
    }



}
