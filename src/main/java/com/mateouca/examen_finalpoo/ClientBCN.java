package com.mateouca.examen_finalpoo;

import java.util.Date;

public class ClientBCN {
    //00030123 Atributos del cliente del BCN
    private String name , lastname;
    private Date date;
    private double id;
    private long card;
    private double money;

    //00030123 Constructores del cliente del BCN
    public ClientBCN() {}

    public ClientBCN(String name, String lastname, Date date, double id, long card, double money) {
        this.name = name;
        this.lastname = lastname;
        this.date = date;
        this.id = id;
        this.card = card;
        this.money = money;
    }

    //00030123 Getters and Setters de los atributos del cliente del BCN
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
