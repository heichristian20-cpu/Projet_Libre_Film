package com.groupe.netflix.service;

import com.groupe.netflix.model.Film;
import com.groupe.netflix.model.GenreFilm;
import com.groupe.netflix.repository.FilmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueServiceTest {

    private FilmRepository filmRepository;
    private CatalogueService catalogueService;

    @BeforeEach
    void setUp() {
        filmRepository = new FilmRepository();
        catalogueService = new CatalogueService(filmRepository);

        filmRepository.ajouter(new Film("F1", "Inception", GenreFilm.SCIENCE_FICTION, 2010, 148));
        filmRepository.ajouter(new Film("F2", "Interstellar", GenreFilm.SCIENCE_FICTION, 2014, 169));
        filmRepository.ajouter(new Film("F3", "Intouchables", GenreFilm.COMEDIE, 2011, 112));
    }

    @Test
    void testRechercherParTitre() {
        List<Film> resultats = catalogueService.rechercherParTitre("inter");
        assertEquals(1, resultats.size());
        assertEquals("Interstellar", resultats.get(0).getTitre());
    }

    @Test
    void testRechercherParTitreInsensibleALaCasse() {
        List<Film> resultats = catalogueService.rechercherParTitre("INCEPTION");
        assertEquals(1, resultats.size());
    }

    @Test
    void testFiltrerParGenre() {
        List<Film> scifi = catalogueService.filtrerParGenre(GenreFilm.SCIENCE_FICTION);
        assertEquals(2, scifi.size());
    }

    @Test
    void testFilmsLesPlusPopulaires() {
        Film inception = filmRepository.trouverParId("F1").get();
        inception.incrementerVues();
        inception.incrementerVues();
        inception.incrementerVues();

        Film interstellar = filmRepository.trouverParId("F2").get();
        interstellar.incrementerVues();

        List<Film> populaires = catalogueService.filmsLesPlusPopulaires(2);

        assertEquals("Inception", populaires.get(0).getTitre());
        assertEquals("Interstellar", populaires.get(1).getTitre());
    }
}
