package com.brainmurphy.roomhack.model;

import java.util.ArrayList;

/**
 * Created by Matt on 9/26/2015.
 */
public class Expense {
    private double cost;
    private String name;
    private ArrayList<Roommate> payee;

    public Expense(double cost, String name, ArrayList<Roommate> payee) {
        this.cost = cost;
        this.name = name;
        this.payee = payee;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Roommate> getPayee() {
        return payee;
    }

    public void setPayee(ArrayList<Roommate> payee) {
        this.payee = payee;
    }
}
