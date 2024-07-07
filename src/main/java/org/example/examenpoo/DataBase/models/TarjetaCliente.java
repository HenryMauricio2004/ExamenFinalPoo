package org.example.examenpoo.DataBase.models;
import java.util.Date;
public class TarjetaCliente {
    private int idTarjeta;
    private String tipoTarjeta;
    private String numTarjeta;
    private Date fechaExpiracion;

    public TarjetaCliente(int idTarjeta, String tipoTarjeta, String numTarjeta, Date fechaExpiracion) {
        this.idTarjeta = idTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
