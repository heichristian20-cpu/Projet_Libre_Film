package com.groupe.netflix.model;

/**
 * Représente un administrateur de la plateforme : consulte les
 * statistiques (films populaires, abonnements, revenus).
 */
public class Administrateur extends Utilisateur {

    private String niveauAcces;

    public Administrateur(String id, String nom, String email, String niveauAcces) {
        super(id, nom, email);
        this.niveauAcces = niveauAcces;
    }

    public String getNiveauAcces() {
        return niveauAcces;
    }

    public void setNiveauAcces(String niveauAcces) {
        this.niveauAcces = niveauAcces;
    }

    @Override
    public String toString() {
        return "Administrateur{" + super.toString() + ", niveauAcces='" + niveauAcces + "'}";
    }
}
