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

    private int id;
    private String nombre;

    public Facilitador(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
