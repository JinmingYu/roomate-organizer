package com.brainmurphy.roomhack.model;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.NotificationCompat;

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
    ArrayList<Chore> chore = new ArrayList<Chore>();
    ArrayList<Expense> expense = new ArrayList<Expense>();
    ArrayList<Roommate> roomate = new ArrayList<Roommate>();

    public boolean isUser;

    private NotificationCompat.Builder notiBuilder = new NotificationCompat().Builder(this);
    private NotificationManager notiManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

    public Roommate(String name, String ID, ArrayList<Chore> chores, ArrayList<Expense> expenses, ArrayList<Roommate> roomates) {
        this.name = name;
        this.ID = ID;
        this.chores = chores;
        this.expenses = expenses;
        this.roomates = roomates;
        isUser = false;

        notiBuilder.setSmallIcon(res.drawable.ic_drawar.png);
        notiBuilder.setContentTitle("ERR");
        notiBuilder.setContentText("ERR");
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
            if(e.getStatus() != "complete")
            {
                balance -= e.getCost();
            }
        }
        return balance;
    }

    private void notifyChore (Chore in)
    {
        if(isUser)
        {
            notiBuilder.setContentTitle (in.getName());
            if (in.getStatus() == "incomplete")
            {
                notiBuilder.setContentText ("Finish by " + in.getDeadline().toString())
            }
            else if (in.getStatus() == "overdue")
            {
                notiBuilder.setContentText ("OVERDUE!");
            }
        }
    }
    private void notifyExpense (Expense in)
    {
        if(isUser)
        {
            notiBuilder.setContentTitle (in.getName());
            if (in.getStatus() == "incomplete")
            {
                notiBuilder.setContentText ("Finish by " + in.getDeadline().toString())
            }
            else if (in.getStatus() == "overdue")
            {
                notiBuilder.setContentText ("OVERDUE!");
            }
        }

    }
}
