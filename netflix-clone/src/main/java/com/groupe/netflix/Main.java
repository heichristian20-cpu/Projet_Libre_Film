package com.groupe.netflix;

import com.groupe.netflix.model.*;
import com.groupe.netflix.repository.FilmRepository;
import com.groupe.netflix.service.AbonnementService;
import com.groupe.netflix.service.CatalogueService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // --- Mise en place du catalogue ---
        FilmRepository filmRepository = new FilmRepository();
        CatalogueService catalogueService = new CatalogueService(filmRepository);
        AbonnementService abonnementService = new AbonnementService();

        Film film1 = new Film("F1", "Inception", GenreFilm.SCIENCE_FICTION, 2010, 148);
        Film film2 = new Film("F2", "Intouchables", GenreFilm.COMEDIE, 2011, 112);
        Film film3 = new Film("F3", "Le Fabuleux Destin d'Amélie Poulain", GenreFilm.ROMANCE, 2001, 122);

        filmRepository.ajouter(film1);
        filmRepository.ajouter(film2);
        filmRepository.ajouter(film3);

        // --- Création d'un client et d'un abonnement ---
        Client client = new Client("C1", "Rina", "rina@example.com");
        Abonnement abonnement = new Abonnement("A1", TypeAbonnement.STANDARD, LocalDate.now());
        client.souscrireAbonnement(abonnement);

        client.regarderFilm(film1);
        client.regarderFilm(film1);
        client.regarderFilm(film2);

        // --- Création d'un administrateur ---
        Administrateur admin = new Administrateur("AD1", "Tojo", "tojo@example.com", "SUPER_ADMIN");

        // --- Démonstration côté client ---
        System.out.println("== Recherche \"incep\" ==");
        catalogueService.rechercherParTitre("incep").forEach(System.out::println);

        // --- Démonstration côté administrateur ---
        System.out.println("\n== Films les plus populaires ==");
        List<Film> populaires = catalogueService.filmsLesPlusPopulaires(2);
        populaires.forEach(System.out::println);

        System.out.println("\n== Revenu mensuel total ==");
        double revenu = abonnementService.calculerRevenuMensuelTotal(Arrays.asList(client));
        System.out.println(revenu + " $ (" + admin.getNom() + " consulte ce rapport)");
    }
}
