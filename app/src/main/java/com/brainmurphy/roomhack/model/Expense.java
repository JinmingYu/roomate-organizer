package com.brainmurphy.roomhack.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Matt on 9/26/2015.
 */
public class Expense {
    private double cost;
    private String name;
    private ArrayList<Roommate> payees;
<<<<<<< HEAD
    private String status;
    private Date deadline;
    public boolean isPeriodic;
    private int period;

    public Expense(double cost, String name, ArrayList<Roommate> payees, Date deadline) {
        this.cost = cost;
        this.name = name;
        this.payees = payees;
        status = "incomplete";
        this.deadline = deadline;
=======

    public Expense(double cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    public Expense(double cost, String name, ArrayList<Roommate> payees) {
        this.cost = cost;
        this.name = name;
        this.payees = payees;
>>>>>>> 855668b214b87b5f59ac2f717406505fcab4c853
    }

    public double getCost() {
        return cost;
    }

    public double getCostPerRoommate ()
    {
        return (cost/(payees.size()));
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
<<<<<<< HEAD
    }

    public void setPayee(ArrayList<Roommate> payees) {
        this.payees = payees;
    }

    public void setStatus (String status)
    {
        if ((status!="incomplete") || (status != "complete") || (status != "overdue"))
        {
            // do nothing, or return an error
        }
        else
        {
            this.status = status;
        }
    }

    public String getStatus()
    {
        return status;
    }

    public int getPeriod()
    {
        if (isPeriodic) return period;
        else return 0;
    }

    public void setPeriod(int period)
    {
        this.period = period;
    }

    public Date getDeadline()
    {
        return deadline;
    }

    public void setDeadline (Date deadline)
    {
        this.deadline = deadline;
=======
    }

    public void setPayee(ArrayList<Roommate> payees) {
        this.payees = payees;
>>>>>>> 855668b214b87b5f59ac2f717406505fcab4c853
    }
}
