package com.example.monprojet;

public class pdf {
private String nom,matiere,description,url;
    public pdf(){}
    public pdf(String nom,String matiere,String description,String url) {
        this.nom = nom;
        this.matiere=matiere;
        this.description=description;
        this.url=url;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
