package com.example.monprojet;

public class student {
    private String etname;
    private String etfullname;
    private String etusername;
    private String etemail;
    private String pass;
    private String usertype;
    private String phone_number;
    private String notes;

    public student(){}
    public student(String etname, String etfullname, String etusername, String pass, String etemail,String phone_number,String usertype,String notes) {
        this.etname = etname;
        this.etfullname = etfullname;
        this.etusername = etusername;
        this.etemail = etemail;
        this.pass = pass;
        this.phone_number=phone_number;
        this.usertype=usertype;
        this.notes=notes;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
