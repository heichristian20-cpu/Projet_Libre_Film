package com.groupe.netflix.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;
    private Film film;

    @BeforeEach
    void setUp() {
        client = new Client("C1", "Rina", "rina@example.com");
        film = new Film("F1", "Inception", GenreFilm.SCIENCE_FICTION, 2010, 148);
    }

    @Test
    void testClientSansAbonnementNestPasActif() {
        assertFalse(client.possedeAbonnementActif());
    }

    @Test
    void testSouscrireAbonnementRendActif() {
        Abonnement abonnement = new Abonnement("A1", TypeAbonnement.STANDARD, LocalDate.now());
        client.souscrireAbonnement(abonnement);

        assertTrue(client.possedeAbonnementActif());
        assertEquals(TypeAbonnement.STANDARD, client.getAbonnement().getType());
    }

    @Test
    void testRegarderFilmSansAbonnementLeveException() {
        assertThrows(IllegalStateException.class, () -> client.regarderFilm(film));
    }

    @Test
    void testRegarderFilmAjouteAHistoriqueEtIncrementeVues() {
        Abonnement abonnement = new Abonnement("A1", TypeAbonnement.PREMIUM, LocalDate.now());
        client.souscrireAbonnement(abonnement);

        client.regarderFilm(film);

        assertEquals(1, client.getHistoriqueVisionnage().size());
        assertEquals(1, film.getNombreVues());
    }

    @Test
    void testAbonnementResilieNestPlusActif() {
        Abonnement abonnement = new Abonnement("A1", TypeAbonnement.BASIQUE, LocalDate.now());
        client.souscrireAbonnement(abonnement);
        abonnement.resilier();

        assertFalse(client.possedeAbonnementActif());
    }
}
