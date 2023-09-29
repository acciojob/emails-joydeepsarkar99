package com.driver;

import java.util.Date;

public class Container {
    private Date date;
    private String senderName;
    private String message;

    public Container(Date date, String senderName,String message) {
        this.date = date;
        this.senderName = senderName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
