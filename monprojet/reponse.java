package com.example.monprojet;

public class reponse {
    private String envoi;
    private String rep;
    public reponse(){}
    public reponse(String sender, String reponse ) {
        this.envoi = sender;
        this.rep=reponse;
    }
    public String getenvoi() {
        return envoi;
    }
    public String getrep() {
        return rep;
    }


}
