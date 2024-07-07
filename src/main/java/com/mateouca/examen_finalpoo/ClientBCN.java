package com.mateouca.examen_finalpoo;

import java.util.Date;
import java.util.Objects;

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

    //00030123 se mete un equals para que cuando se meta una nueva persona a la base de datos no la meta por que ya esta registrada
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ClientBCN clientBCN = (ClientBCN) o;
        return Double.compare(id, clientBCN.id) == 0 && card == clientBCN.card && Double.compare(money, clientBCN.money) == 0 && Objects.equals(name, clientBCN.name) && Objects.equals(lastname, clientBCN.lastname) && Objects.equals(date, clientBCN.date);
    }
}
