package com.groupe.netflix.repository;

import com.groupe.netflix.model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Gère le stockage des films (en mémoire pour l'instant).
 */
public class FilmRepository {

    private List<Film> films;

    public FilmRepository() {
        this.films = new ArrayList<>();
    }

    public void ajouter(Film film) {
        films.add(film);
    }

    public boolean supprimer(String idFilm) {
        return films.removeIf(f -> f.getId().equals(idFilm));
    }

    public Optional<Film> trouverParId(String idFilm) {
        return films.stream()
                .filter(f -> f.getId().equals(idFilm))
                .findFirst();
    }

    public List<Film> trouverTous() {
        return new ArrayList<>(films);
    }
}
