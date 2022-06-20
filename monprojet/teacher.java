package com.example.monprojet;

import java.util.ArrayList;

public class teacher {
    private String etname,etfullname,etusername,etemail,pass,usertype,phone_number;
     public teacher(){}


    public teacher(String etname, String etfullname, String etusername, String pass, String etemail, String phone_number,String usertype) {
        this.etname = etname;
        this.etfullname = etfullname;
        this.etusername = etusername;
        this.etemail = etemail;
        this.pass = pass;
        this.phone_number = phone_number;
        this.usertype=usertype;


    }

    public String getEtname() {
        return etname;
    }

    public void setEtname(String etname) {
        this.etname = etname;
    }

    public String getEtfullname() {
        return etfullname;
    }

    public void setEtfullname(String etfullname) {
        this.etfullname = etfullname;
    }

    public String getEtusername() {
        return etusername;
    }

    public void setEtusername(String etusername) {
        this.etusername = etusername;
    }

    public String getEtemail() {
        return etemail;
    }

    public void setEtemail(String etemail) {
        this.etemail = etemail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }



}
