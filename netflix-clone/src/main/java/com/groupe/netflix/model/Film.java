package com.groupe.netflix.model;

import java.util.Objects;

/**
 * Représente un film disponible sur la plateforme.
 */
public class Film {

    private String id;
    private String titre;
    private GenreFilm genre;
    private int anneeSortie;
    private int dureeMinutes;
    private double note; // note moyenne sur 5
    private int nombreVues;

    public Film(String id, String titre, GenreFilm genre, int anneeSortie, int dureeMinutes) {
        this.id = id;
        this.titre = titre;
        this.genre = genre;
        this.anneeSortie = anneeSortie;
        this.dureeMinutes = dureeMinutes;
        this.note = 0.0;
        this.nombreVues = 0;
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public GenreFilm getGenre() {
        return genre;
    }

    public void setGenre(GenreFilm genre) {
        this.genre = genre;
    }

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        if (note < 0 || note > 5) {
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 5");
        }
        this.note = note;
    }

    public int getNombreVues() {
        return nombreVues;
    }

    /**
     * Incrémente le compteur de vues (appelé quand un client regarde le film).
     */
    public void incrementerVues() {
        this.nombreVues++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Film{titre='" + titre + "', genre=" + genre + ", annee=" + anneeSortie
                + ", vues=" + nombreVues + ", note=" + note + "}";
    }
}
