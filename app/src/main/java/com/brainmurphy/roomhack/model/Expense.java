package com.brainmurphy.roomhack.model;

import java.util.ArrayList;

/**
 * Created by Matt on 9/26/2015.
 */
public class Expense {
    private double cost;
    private String name;
    private ArrayList<Roommate> payees;

    public Expense(String name, double cost) {
        this.cost = cost;
        this.name = name;
    }

    public Expense(double cost, String name, ArrayList<Roommate> payees) {
        this.cost = cost;
        this.name = name;
        this.payees = payees;
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

    public ArrayList<Roommate> getPayees() {
        return payees;
    }

    public void setPayee(ArrayList<Roommate> payees) {
        this.payees = payees;
    }
}
