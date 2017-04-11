package com.thougthworks.vozdamulher.model;

import java.io.Serializable;

/**
 * Created by hortoni on 08/04/17.
 */

public class Bus implements Serializable{
    private String name;
    private int number;
    private int amount;

    public Bus(String name, int number, int amount) {
        this.name = name;
        this.number = number;
        this.amount = amount;
    }

    public Bus(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Bus() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

