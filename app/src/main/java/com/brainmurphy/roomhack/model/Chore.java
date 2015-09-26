package com.brainmurphy.roomhack.model;


import java.util.Date;

/**
 * Created by Matt on 9/26/2015.
 */
public class Chore {
    /*Chore (String _name, dateTime _deadline, boolean _isPeriodic, int _period)
    {
        setName (_name);
        setDeadline(_deadline);
        isPeriodic = _isPeriodic;
        setPeriod(_period);
    }*/

    public String getName ()
    {
        return name;
    }
    public void setName (String _name)
    {
        name = _name;
    }
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
    public void setPeriod (int _period)
    {
        period = _period;
    }
    public Date getDeadline ()
    {
        return deadline;
    }
    public void setDeadline (Date _deadline)
    {
        deadline = _deadline;
    }

    public boolean isPeriodic;
    private int period;
    private String name;
    private Date deadline;
}










