package com.bingo.entity;

import java.util.Date;

public class Selection {
    private int sid;
    private int cid;
    private Date seltime;
    private int score;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getSeltime() {
        return seltime;
    }

    public void setSeltime(Date seltime) {
        this.seltime = seltime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
