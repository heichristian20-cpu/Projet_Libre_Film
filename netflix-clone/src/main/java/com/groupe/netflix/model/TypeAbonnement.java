package com.groupe.netflix.model;

public enum TypeAbonnement {
    BASIQUE(5.99),
    STANDARD(12.99),
    PREMIUM(17.99);

    private final double prixMensuel;

    TypeAbonnement(double prixMensuel) {
        this.prixMensuel = prixMensuel;
    }

    public double getPrixMensuel() {
        return prixMensuel;
    }
}
