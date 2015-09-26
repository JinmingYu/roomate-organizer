package com.brainmurphy.roomhack.model;

/**
 * Created by Matt on 9/26/2015.
 */
public class Expense extends Chore {
    /*Expense (String _name, dateTime _deadline, boolean _isPeriodic, int _period, double _cost)
    {
        super (_name, _deadline, _isPeriodic, _period);
        setCost (_cost);
    }*/
    public double getCost ()
    {
        return cost;
    }
    public void setCost (double _cost)
    {
        cost = _cost;
    }
    private double cost;
}
