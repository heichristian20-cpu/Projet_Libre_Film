package com.groupe.netflix.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    private Film film;

    @BeforeEach
    void setUp() {
        film = new Film("F1", "Inception", GenreFilm.SCIENCE_FICTION, 2010, 148);
    }

    @Test
    void testCreationFilm() {
        assertEquals("F1", film.getId());
        assertEquals("Inception", film.getTitre());
        assertEquals(GenreFilm.SCIENCE_FICTION, film.getGenre());
        assertEquals(2010, film.getAnneeSortie());
        assertEquals(148, film.getDureeMinutes());
        assertEquals(0, film.getNombreVues());
    }

    @Test
    void testIncrementerVues() {
        film.incrementerVues();
        film.incrementerVues();
        assertEquals(2, film.getNombreVues());
    }

    @Test
    void testSetNoteValide() {
        film.setNote(4.5);
        assertEquals(4.5, film.getNote());
    }

    @Test
    void testSetNoteInvalideLeveException() {
        assertThrows(IllegalArgumentException.class, () -> film.setNote(6));
        assertThrows(IllegalArgumentException.class, () -> film.setNote(-1));
    }

    @Test
    void testEqualsBaseSurId() {
        Film memeFilm = new Film("F1", "Autre titre", GenreFilm.DRAME, 2020, 90);
        Film filmDifferent = new Film("F2", "Inception", GenreFilm.SCIENCE_FICTION, 2010, 148);

        assertEquals(film, memeFilm);
        assertNotEquals(film, filmDifferent);
    }
}
