package com.example.monprojet;

public class message {
    private String send;
    private String msg;
    public message(){}
    public message(String send, String message ) {
        this.send = send;
        this.msg=message;
    }
    public String getsend() {
        return send;
    }
    public String getmsg() {
        return msg;
    }

}
