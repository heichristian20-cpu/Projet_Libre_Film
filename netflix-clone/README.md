# Netflix Clone — Projet N2

Projet réalisé dans le cadre du cours de programmation Java.

## Thème
"Films" (style Netflix)

## Membres du groupe
- [Nom 1]
- [Nom 2]
- [Nom 3]
- [Nom 4]

## Description

Application simulant une plateforme de streaming de films. Deux types d'utilisateurs :

- **Client** : recherche et regarde des films, peut souscrire un abonnement.
- **Administrateur** : consulte les films les plus populaires, gère les abonnements et suit les revenus générés.

## Structure du projet

```
src/main/java/com/groupe/netflix/
├── Main.java
├── model/           classes métier (Film, Client, Administrateur, Abonnement...)
├── service/         logique métier (catalogue, abonnements)
└── repository/      accès aux données (en mémoire pour l'instant)
```

## Diagramme de classe UML

Voir `docs/diagramme-uml.png`.

## Lancer le projet

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.groupe.netflix.Main"
```

## Lancer les tests

```bash
mvn test
```

## Formulaire de notation

https://forms.gle/3K1pWjYxgmXtGL
