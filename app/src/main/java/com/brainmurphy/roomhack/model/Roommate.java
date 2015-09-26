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
    private ArrayList<Roommate> roommates;
    private ArrayList<Request> requestsSent;
    private ArrayList<Request> requestsReceived;
    private double balance;

<<<<<<< HEAD
    public boolean isUser;

    private NotificationCompat.Builder notiBuilder = new NotificationCompat().Builder(this);
    private NotificationManager notiManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

    public Roommate(String name, String ID, ArrayList<Chore> chores, ArrayList<Expense> expenses, ArrayList<Roommate> roomates) {
=======

    public Roommate(String name, String ID, ArrayList<Chore> chores, ArrayList<Expense> expenses, ArrayList<Roommate> roommates, ArrayList<Request> requestsSent, ArrayList<Request> requestsReceived, double balance) {
>>>>>>> 855668b214b87b5f59ac2f717406505fcab4c853
        this.name = name;
        this.ID = ID;
        this.chores = chores;
        this.expenses = expenses;
<<<<<<< HEAD
        this.roomates = roomates;
        isUser = false;

        notiBuilder.setSmallIcon(res.drawable.ic_drawar.png);
        notiBuilder.setContentTitle("ERR");
        notiBuilder.setContentText("ERR");
=======
        this.roommates = roommates;
        this.requestsSent = requestsSent;
        this.requestsReceived = requestsReceived;
        this.balance = balance;
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
>>>>>>> 855668b214b87b5f59ac2f717406505fcab4c853
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
<<<<<<< HEAD
=======
    ArrayList<Chore> chore = new ArrayList<Chore>();
    ArrayList<Expense> expense = new ArrayList<Expense>();
    ArrayList<Roommate> roommate = new ArrayList<Roommate>();
    public Roommate user = new Roommate ("", "", chore, expense, roommate, new ArrayList<Request>(), new ArrayList<Request>(), 0);
>>>>>>> 855668b214b87b5f59ac2f717406505fcab4c853
}
