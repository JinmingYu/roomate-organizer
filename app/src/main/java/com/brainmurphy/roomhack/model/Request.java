package com.brainmurphy.roomhack.model;

import java.util.Date;

/**
 * Created by Jinming on 9/26/15.
 */
public class Request {
    private String conetent;
    private Date requestDate;
    private boolean isAccepted;

    public Request(String conetent, Date requestDate) {
        this.conetent = conetent;
        this.requestDate = requestDate;
        this.isAccepted = false;
    }

    public String getConetent() {
        return conetent;
    }

    public void setConetent(String conetent) {
        this.conetent = conetent;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }
}
