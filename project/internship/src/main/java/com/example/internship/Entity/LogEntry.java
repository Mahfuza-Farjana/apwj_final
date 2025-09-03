package com.example.internship.Entity;

import java.time.LocalDateTime;

public class LogEntry {
    public int id;
    public int userid;
    public String method;
    public String action;
    public LocalDateTime timeStamp;

    public LogEntry(int id, int userid, String method, String action) {
        this.id = id;
        this.userid = userid;
        this.method = method;
        this.action = action;
        this.timeStamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

}
