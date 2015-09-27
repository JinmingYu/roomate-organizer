package com.brainmurphy.roomhack.model;

import java.util.ArrayList;

/**
 * General Roommate Class
 */
public class Roommate {
    protected String name;
    protected String ID;
    private ArrayList<Chore> chores;
    private ArrayList<Expense> expenses;
    private ArrayList<Roommate> roommates;
    private ArrayList<Request> requestsSent;
    private ArrayList<Request> requestsReceived;
    private double balance;


    public Roommate(String name, String ID, ArrayList<Chore> chores, ArrayList<Expense> expenses, ArrayList<Roommate> roommates, ArrayList<Request> requestsSent, ArrayList<Request> requestsReceived, double balance) {
        this.name = name;
        this.ID = ID;
        this.chores = chores;
        this.expenses = expenses;
        this.roommates = roommates;
        this.requestsSent = requestsSent;
        this.requestsReceived = requestsReceived;
        this.balance = balance;
    }
    public Roommate() {

    }

    public void setBalance(double balance) {
        this.balance = balance;
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
    public void addChore(Chore input)
    {
        chores.add(input);
    }
    public void deleteChore(Chore input)
    {
        chores.remove(input);
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

    private void notifyChore (Chore in)
    {
        // fuck.
    }
    private void notifyExpense (Expense in)
    {
        // fuck.
    }
    ArrayList<Chore> chore = new ArrayList<Chore>();
    ArrayList<Expense> expense = new ArrayList<Expense>();
    ArrayList<Roommate> roommate = new ArrayList<Roommate>();
}
