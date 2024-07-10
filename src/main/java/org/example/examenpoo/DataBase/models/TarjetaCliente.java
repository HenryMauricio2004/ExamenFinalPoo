package org.example.examenpoo.DataBase.models;
import java.util.Date;

public class TarjetaCliente { //00082023 Definición de la clase TarjetaCliente
    private int idTarjeta; //00082023 Identificador único de la tarjeta
    private String tipoTarjeta; //00082023 Tipo de tarjeta (crédito/débito)
    private String numTarjeta; //00082023 Número de la tarjeta
    private Date fechaExpiracion; //00082023 Fecha de expiración de la tarjeta
    private String facilitador;// 00030123 El tipo de facilitador que ocupa la tarjeta

    public TarjetaCliente(int idTarjeta, String tipoTarjeta, String numTarjeta, Date fechaExpiracion, String facilitador) { //00082023 Constructor de la clase
        this.idTarjeta = idTarjeta; //00082023 Asigna el identificador de la tarjeta
        this.tipoTarjeta = tipoTarjeta; //00082023 Asigna el tipo de tarjetaq
        this.numTarjeta = numTarjeta; //00082023 Asigna el número de la tarjeta
        this.fechaExpiracion = fechaExpiracion; //00082023 Asigna la fecha de expiración
        this.facilitador = facilitador;
    } //00082023 Fin del constructor

    public int getIdTarjeta() { return idTarjeta; } //00082023 Obtiene el identificador de la tarjeta

    public void setIdTarjeta(int idTarjeta) { this.idTarjeta = idTarjeta; } //00082023 Establece el identificador de la tarjeta

    public String getTipoTarjeta() { return tipoTarjeta; } //00082023 Obtiene el tipo de tarjeta

    public void setTipoTarjeta(String tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; } //00082023 Establece el tipo de tarjeta

    public String getNumTarjeta() { return numTarjeta; } //00082023 Obtiene el número de la tarjeta

    public void setNumTarjeta(String numTarjeta) { this.numTarjeta = numTarjeta;} //00082023 Establece el número de la tarjeta

    public Date getFechaExpiracion() { return fechaExpiracion; } //00082023 Obtiene la fecha de expiración

    public void setFechaExpiracion(Date fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; } //00082023 Establece la fecha de expiración

    public String getFacilitador() {
        return facilitador;//00030123 obtiene el facilitador de la tarjeta
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;//0003123 Establece el tipo de facilitador que es la TARJETA
    }
} //00082023 Fin de la clase TarjetaCliente
