package org.example.examenpoo.DataBase.models; // Declaración del paquete donde se encuentra la clase

public class TarjetaCliente { // Declaración de la clase TarjetaCliente
    private int idTarjeta; // Variable de instancia para almacenar el ID de la tarjeta
    private String nombreTarjeta; // Variable de instancia para almacenar el nombre de la tarjeta

    public TarjetaCliente(int idTarjeta, String nombreTarjeta) { // Constructor de la clase que recibe ID y nombre de la tarjeta
        this.idTarjeta = idTarjeta; // Inicializar idTarjeta con el valor recibido
        this.nombreTarjeta = nombreTarjeta; // Inicializar nombreTarjeta con el valor recibido
    }

    public int getIdTarjeta() { // Método getter para obtener el ID de la tarjeta
        return idTarjeta; // Retornar el ID de la tarjeta
    }

    public void setIdTarjeta(int idTarjeta) { // Método setter para establecer el ID de la tarjeta
        this.idTarjeta = idTarjeta; // Asignar el valor recibido a idTarjeta
    }

    public String getNombreTarjeta() { // Método getter para obtener el nombre de la tarjeta
        return nombreTarjeta; // Retornar el nombre de la tarjeta
    }

    public void setNombreTarjeta(String nombreTarjeta) { // Método setter para establecer el nombre de la tarjeta
        this.nombreTarjeta = nombreTarjeta; // Asignar el valor recibido a nombreTarjeta
    }
}
