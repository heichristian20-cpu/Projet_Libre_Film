package com.groupe.netflix.service;

import com.groupe.netflix.model.Client;

import java.util.List;

/**
 * Logique métier liée aux abonnements :
 * calcul des revenus générés par les clients, utile pour la vue Administrateur.
 */
public class AbonnementService {

    /**
     * Calcule le revenu mensuel total généré par tous les clients
     * ayant un abonnement actif.
     */
    public double calculerRevenuMensuelTotal(List<Client> clients) {
        return clients.stream()
                .filter(Client::possedeAbonnementActif)
                .mapToDouble(c -> c.getAbonnement().getPrixMensuel())
                .sum();
    }

    /**
     * Compte le nombre de clients ayant un abonnement actif.
     */
    public long compterAbonnesActifs(List<Client> clients) {
        return clients.stream()
                .filter(Client::possedeAbonnementActif)
                .count();
    }
}
