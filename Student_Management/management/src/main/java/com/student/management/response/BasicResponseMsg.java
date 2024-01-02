package com.student.management.response;

public class BasicResponseMsg {

    private int status;
    private String msge;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsge() {
        return msge;
    }

    public void setMsge(String msge) {
        this.msge = msge;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

}
