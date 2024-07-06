package org.example.examenpoo.DataBase.models;

public class TarjetaCliente {
    private int idTarjeta;
    private String nombreTarjeta;

    public TarjetaCliente(int idTarjeta, String nombreTarjeta) {
        this.idTarjeta = idTarjeta;
        this.nombreTarjeta = nombreTarjeta;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }
}
