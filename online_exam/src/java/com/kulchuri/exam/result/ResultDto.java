package com.kulchuri.exam.result;

public class ResultDto {

    private int rid, sid, stid, tright, tworng, tattempt, tquestions;
    private String doe;

    public ResultDto() {
    }

    public ResultDto(int tquestions, int stid, int sid, int tright, int tworng, int tattempt) {
        this.tquestions = tquestions;
        this.stid = stid;
        this.sid = sid;
        this.tright = tright;
        this.tworng = tworng;
        this.tattempt = tattempt;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public int getTright() {
        return tright;
    }

    public void setTright(int tright) {
        this.tright = tright;
    }

    public int getTworng() {
        return tworng;
    }

    public void setTworng(int tworng) {
        this.tworng = tworng;
    }

    public int getTattempt() {
        return tattempt;
    }

    public void setTattempt(int tattempt) {
        this.tattempt = tattempt;
    }

    public String getDoe() {
        return doe;
    }

    public void setDoe(String doe) {
        this.doe = doe;
    }

    public int getTquestions() {
        return tquestions;
    }

    public void setTquestions(int tquestions) {
        this.tquestions = tquestions;
    }

}
