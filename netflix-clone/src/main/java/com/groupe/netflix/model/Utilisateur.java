package com.groupe.netflix.model;

/**
 * Classe abstraite représentant un utilisateur de la plateforme.
 * Classe parente de Client et Administrateur.
 */
public abstract class Utilisateur {

    private String id;
    private String nom;
    private String email;

    public Utilisateur(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utilisateur{id='" + id + "', nom='" + nom + "', email='" + email + "'}";
    }
}
