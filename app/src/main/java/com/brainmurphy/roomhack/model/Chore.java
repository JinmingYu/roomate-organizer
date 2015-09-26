package com.brainmurphy.roomhack.model;


import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Matt on 9/26/2015.
 */
public class Chore {
    private String name;
    private Date deadline;
    private int period;
    public boolean isPeriodic;
    private ArrayList<Roommate> assignees;

    // either "incomplete,"
    private String status;

    public int getPeriod()
    {
        if (isPeriodic == false)
        {
            return 0;
        }
        else
        {
            return period;
        }
    }

    public Chore(String name, Date deadline, int period, boolean isPeriodic, ArrayList<Roommate> assignees) {
        this.name = name;
        this.deadline = deadline;
        this.period = period;
        this.isPeriodic = isPeriodic;
        this.assignees = assignees;
        status = "incomplete";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public boolean isPeriodic() {
        return isPeriodic;
    }

    public void setIsPeriodic(boolean isPeriodic) {
        this.isPeriodic = isPeriodic;
    }

    public void addAssignee (Roommate assignee)
    {
        assignees.add (assignee);
    }

    public ArrayList<Roommate> getAssignees ()
    {
        return assignees;
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

    public void complete()
    {
        if (isPeriodic)
        {
            deadline.setTime (deadline.getTime() +(period*(24*60*60*1000)));
            status = "incomplete";
        }
        else status = "complete";
    }
}










