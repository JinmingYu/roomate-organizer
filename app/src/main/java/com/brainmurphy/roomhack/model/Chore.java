package com.brainmurphy.roomhack.model;


import java.util.Date;

/**
 * Created by Matt on 9/26/2015.
 */
public class Chore {
    private String name;
    private String description;
    private Roommate doer;
    private Date deadline;
    private int period;
    public boolean isPeriodic;

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

    public Chore() {

    }

    public Chore(String name, Roommate doer, Date deadline, int period, boolean isPeriodic) {
        this.name = name;
        this.doer = doer;
        this.deadline = deadline;
        this.period = period;
        this.isPeriodic = isPeriodic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roommate getDoer() {
        return doer;
    }

    public void setDoer(Roommate doer) {
        this.doer = doer;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}










