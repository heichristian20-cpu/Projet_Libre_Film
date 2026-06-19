package com.groupe.netflix.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un client de la plateforme : regarde des films,
 * en cherche, et peut souscrire un abonnement.
 */
public class Client extends Utilisateur {

    private Abonnement abonnement;
    private List<Film> historiqueVisionnage;
    private List<Film> listeAVoir;

    public Client(String id, String nom, String email) {
        super(id, nom, email);
        this.historiqueVisionnage = new ArrayList<>();
        this.listeAVoir = new ArrayList<>();
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void souscrireAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public boolean possedeAbonnementActif() {
        return abonnement != null && abonnement.isActif();
    }

    /**
     * Le client regarde un film : on l'ajoute à son historique
     * et on incrémente le compteur de vues du film.
     */
    public void regarderFilm(Film film) {
        if (!possedeAbonnementActif()) {
            throw new IllegalStateException("Le client n'a pas d'abonnement actif");
        }
        historiqueVisionnage.add(film);
        film.incrementerVues();
    }

    public void ajouterAListeAVoir(Film film) {
        listeAVoir.add(film);
    }

    public List<Film> getHistoriqueVisionnage() {
        return historiqueVisionnage;
    }

    public List<Film> getListeAVoir() {
        return listeAVoir;
    }

    @Override
    public String toString() {
        return "Client{" + super.toString() + ", abonnement=" + abonnement
                + ", filmsVus=" + historiqueVisionnage.size() + "}";
    }
}
