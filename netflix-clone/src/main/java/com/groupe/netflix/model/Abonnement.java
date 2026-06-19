package com.groupe.netflix.model;

import java.time.LocalDate;

/**
 * Représente l'abonnement souscrit par un client.
 */
public class Abonnement {

    private String id;
    private TypeAbonnement type;
    private LocalDate dateDebut;
    private boolean actif;

    public Abonnement(String id, TypeAbonnement type, LocalDate dateDebut) {
        this.id = id;
        this.type = type;
        this.dateDebut = dateDebut;
        this.actif = true;
    }

    public String getId() {
        return id;
    }

    public TypeAbonnement getType() {
        return type;
    }

    public void setType(TypeAbonnement type) {
        this.type = type;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public boolean isActif() {
        return actif;
    }

    public void resilier() {
        this.actif = false;
    }

    public double getPrixMensuel() {
        return type.getPrixMensuel();
    }

    @Override
    public String toString() {
        return "Abonnement{type=" + type + ", actif=" + actif + ", depuis=" + dateDebut + "}";
    }
}
