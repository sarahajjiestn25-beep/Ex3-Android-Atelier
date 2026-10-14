package com.example.ex3;

public class Personne {
    private String prenom;
    private String nom;
    private String eMail;

    public Personne() {
        this.prenom = "";
        this.nom = "";
        this.eMail = "";
    }

    public Personne(String prenom, String nom, String eMail) {
        this.prenom = prenom;
        this.nom = nom;
        this.eMail = eMail;
    }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEMail() { return eMail; }
    public void setEMail(String eMail) { this.eMail = eMail; }

    @Override
    public String toString() {
        return "Prénom: " + prenom + ", Nom: " + nom + ", eMail: " + eMail;
    }
}