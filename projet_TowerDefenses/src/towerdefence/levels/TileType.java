package towerdefence.levels;

import java.awt.Color;

/**
 * Enumération représentant les différents types de tuiles dans le jeu.
 */
public enum TileType {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Tuile de type "Spawn" : point de départ des ennemis.
     */
    SPAWN("Spawn", Color.RED),

    /**
     * Tuile de type "Base" : point à défendre des attaques ennemies.
     */
    BASE("Base", Color.ORANGE),

    /**
     * Tuile de type "Route" : chemin emprunté par les ennemis.
     */
    ROUTE("Road", new Color(194, 178, 128)),

    /**
     * Tuile de type "Constructible" : emplacement où les tours peuvent être
     * construites.
     */
    CONSTRUCTIBLE("Constructible", Color.LIGHT_GRAY),

    /**
     * Tuile de type "Non Constructible" : emplacement interdit à la construction.
     */
    NONCONSTUCTIBLE("Non constructible", new Color(11, 102, 35));

    private String nom; // Nom du type de tuile.
    private Color color; // Couleur associée à ce type de tuile.

    /**
     * Récupère le nom du type de tuile.
     *
     * @return Nom du type de tuile.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupère la couleur associée à ce type de tuile.
     *
     * @return Couleur de la tuile.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Constructeur pour initialiser un type de tuile avec son nom et sa couleur.
     *
     * @param nom   Nom du type de tuile.
     * @param color Couleur associée au type de tuile.
     */
    private TileType(String nom, Color color) {
        this.nom = nom;
        this.color = color;
    }
}
