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
    private ArrayList<Roommate> roomates;
    ArrayList<Chore> chore = new ArrayList<Chore>;
    ArrayList<Chore> expense = new ArrayList<Expense>;
    ArrayList<Chore> roomate = new ArrayList<Roommate>;

    public Roommate(String name, String ID, ArrayList<Chore> chores, ArrayList<Expense> expenses, ArrayList<Roommate> roomates) {
        this.name = name;
        this.ID = ID;
        this.chores = chores;
        this.expenses = expenses;
        this.roomates = roomates;
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
    public Roommate user = new Roommate ("", "", chore, expense, roomate);
}
