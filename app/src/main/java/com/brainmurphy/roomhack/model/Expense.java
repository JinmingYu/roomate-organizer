package com.brainmurphy.roomhack.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Matt on 9/26/2015.
 */
public class Expense {
    @SerializedName("cost")
    private double cost;
    @SerializedName("name")
    private String name;
    @SerializedName("payees")
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

    public void setPayees(ArrayList<Roommate> payees) {
        this.payees = payees;
    }
}
