package com.groupe.netflix.service;

import com.groupe.netflix.model.Film;
import com.groupe.netflix.model.GenreFilm;
import com.groupe.netflix.repository.FilmRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Logique métier liée au catalogue de films :
 * recherche, films populaires, filtrage par genre.
 */
public class CatalogueService {

    private final FilmRepository filmRepository;

    public CatalogueService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    /**
     * Recherche des films dont le titre contient le texte donné (insensible à la casse).
     */
    public List<Film> rechercherParTitre(String texte) {
        String recherche = texte.toLowerCase();
        return filmRepository.trouverTous().stream()
                .filter(f -> f.getTitre().toLowerCase().contains(recherche))
                .collect(Collectors.toList());
    }

    public List<Film> filtrerParGenre(GenreFilm genre) {
        return filmRepository.trouverTous().stream()
                .filter(f -> f.getGenre() == genre)
                .collect(Collectors.toList());
    }

    /**
     * Retourne les N films les plus populaires (par nombre de vues),
     * utile pour la vue Administrateur.
     */
    public List<Film> filmsLesPlusPopulaires(int n) {
        return filmRepository.trouverTous().stream()
                .sorted(Comparator.comparingInt(Film::getNombreVues).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Film> filmsLesMieuxNotes(int n) {
        return filmRepository.trouverTous().stream()
                .sorted(Comparator.comparingDouble(Film::getNote).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}
