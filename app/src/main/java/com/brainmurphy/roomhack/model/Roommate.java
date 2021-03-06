package com.brainmurphy.roomhack.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * General Roommate Class
 */
public class Roommate {
    @SerializedName("name")
    protected String name;
    @SerializedName("ID")
    protected String ID;
    @SerializedName("chores")
    private ArrayList<Chore> chores;
    private ArrayList<Expense> expenses;
    private ArrayList<Roommate> roommates;
    private ArrayList<Request> requestsSent;
    private ArrayList<Request> requestsReceived;
    public boolean isUser;


    public Roommate(String name, String ID, ArrayList<Chore> chores, ArrayList<Expense> expenses, ArrayList<Roommate> roommates, ArrayList<Request> requestsSent, ArrayList<Request> requestsReceived) {
        this.name = name;
        this.ID = ID;
        this.chores = chores;
        this.expenses = expenses;
    }
    public Roommate() {

    }

    public ArrayList<Request> getRequestsSent() {
        return requestsSent;
    }

    public void setRequestsSent(ArrayList<Request> requestsSent) {
        this.requestsSent = requestsSent;
    }

    public ArrayList<Request> getRequestsReceived() {
        return requestsReceived;
    }

    public void setRequestsReceived(ArrayList<Request> requestsReceived) {
        this.requestsReceived = requestsReceived;
    }

    public ArrayList<Chore> getChores()
    {
        return chores;
    }
    public ArrayList<Expense> getExpenses()
    {
        return expenses;
    }
    public String getName()
    {
        return name;
    }
    public void setName (String _name)
    {
        name = _name;
    }
    public String getID ()
    {
        return ID;
    }
    public void setID (String _ID)
    {
        ID = _ID;
    }
    public void setChores(ArrayList<Chore> chores) {
        this.chores = chores;
    }
    public void addChore(Chore input)
    {
        chores.add(input);
    }
    public void deleteChore(Chore input)
    {
        chores.remove(input);
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
    public void addExpense(Expense input)
    {
        expenses.add (input);
    }
    public void deleteExpense(Expense input)
    {
        expenses.remove(input);
    }
    public double getBalance()
    {
        double balance = 0;
        for (Expense e : expenses)
        {
            balance -= e.getCost();
        }
        return balance;
    }
}
