🏰 Tower Defense – Projet Java (L2, Université de Rennes)
🎯 Présentation

Ce projet a été réalisé dans le cadre de la Licence 3 Informatique – parcours MIAGE à l’Université de Rennes (UFR ISTIC).
L’objectif était de concevoir un jeu de type Tower Defense en Java orienté objet, illustrant la modélisation, la programmation événementielle et la gestion d’interfaces graphiques.

Le joueur doit protéger sa zone contre des vagues successives d’ennemis en plaçant des tours défensives sur une carte.
Chaque tour dispose de caractéristiques propres (portée, puissance, vitesse de tir), et les ennemis progressent selon un chemin prédéfini.

👨‍💻 Équipe de développement

Ibrahima Kalil BAH

Noé Capelle

🧱 Fonctionnalités principales

Interface graphique construite en Java Swing

Architecture orientée objet (POO) avec plusieurs classes métiers

Gestion des entités :

Tower, Archer, FireCasterTower, EarthCasterTower, WaterCasterTower, WindCasterTower

Enemy, Level, Wave

Système de carte et de zones de jeu

Base de code extensible pour ajouter de nouveaux types d’ennemis ou de tours

Intégration partielle d’une IA pour automatiser certaines interactions

🗂️ Structure du projet
projet_TowerDefenses/
├── src/towerdefence/
│   ├── enemy/               # Gestion des ennemis
│   ├── levels/              # Niveaux et vagues
│   ├── tower/               # Types de tours
│   ├── Element.java
│   ├── Entity.java
│   ├── GameZones.java       # Interface graphique principale
│   ├── HealthBar.java
│   ├── MapLoader.java
│   ├── MapZone.java
│   ├── Position.java
│   └── StdDraw.java
├── bin/                     # Fichiers compilés (ignorés par Git)
├── README.md
└── .gitignore

▶️ Lancement du jeu

Ouvre le projet dans ton IDE (VS Code, IntelliJ, Eclipse…).

Compile les classes Java :

javac src/towerdefence/**/*.java


Exécute la classe principale :

java src/towerdefence/GameZones.java


ou directement depuis ton IDE.

L’interface du jeu s’affiche (même si certaines fonctionnalités sont incomplètes).

🧠 Points d’apprentissage

Ce projet a permis de :

Appliquer les concepts d’héritage, de polymorphisme et d’encapsulation

Organiser un projet Java structuré en packages

Travailler en équipe avec Git / GitHub

Mettre en place un diagramme UML (classes, relations, dépendances)

Expérimenter la gestion d’une interface graphique et des événements utilisateurs

⚠️ Limitations actuelles

Certaines IA d’ennemis ne sont pas finalisées

Le diagramme de classes initial a été ajusté en cours de développement

Certaines fonctionnalités (détection des collisions, menu principal, audio) restent à implémenter

🚀 Améliorations futures

Système de score et de niveaux progressifs

Ajout de nouvelles tours et ennemis

Sauvegarde / chargement de partie

Meilleure gestion des animations et des collisions

📄 Licence

Projet académique – usage pédagogique uniquement.
© 2024-2025 Ibrahima Kalil BAH & Noé Capelle – Université de Rennes.