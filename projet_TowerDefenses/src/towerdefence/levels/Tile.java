package towerdefence.levels;

import towerdefence.Position;
import towerdefence.tower.Tower;
import java.awt.Color;

/**
 * Classe représentant une tuile dans la carte du jeu.
 */
public class Tile {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    private TileType type; // Type de la tuile (SPAWN, ROUTE, BASE, etc.).
    private Tower tower; // Tour placée sur cette tuile (peut être null).
    private Position position; // Position de la tuile sur la carte.
    private Color color; // Couleur associée au type de tuile.

    /**
     * Constructeur pour initialiser une tuile.
     *
     * @param type     Type de la tuile.
     * @param tower    Tour associée à la tuile (null si aucune).
     * @param position Position de la tuile.
     */
    public Tile(TileType type, Tower tower, Position position) {
        this.type = type;
        this.tower = tower;
        this.position = position;
        this.color = (type != null) ? type.getColor() : null; // Définit la couleur si le type est valide.
    }

    /**
     * Vérifie si la tuile est constructible (de type CONSTRUCTIBLE et sans tour).
     *
     * @return True si la tuile est constructible, False sinon.
     */
    public boolean isConstructible() {
        return type == TileType.CONSTRUCTIBLE && tower == null;
    }

    /**
     * Vérifie si la tuile est de type ROUTE.
     *
     * @return True si la tuile est une route, False sinon.
     */
    public boolean isRoute() {
        return type == TileType.ROUTE;
    }

    /**
     * Supprime la tour placée sur cette tuile.
     */
    public void removeTower() {
        this.tower = null;
    }

    /**
     * Place une tour sur cette tuile si elle est constructible.
     *
     * @param tower La tour à placer.
     */
    public void setTower(Tower tower) {
        if (isConstructible()) {
            this.tower = tower;
        } else {
            System.out.println("Cette tuile n'est pas constructible ou contient déjà une tour.");
        }
    }

    /**
     * Récupère le type de la tuile.
     *
     * @return Le type de la tuile.
     */
    public TileType getType() {
        return type;
    }

    /**
     * Récupère la position de la tuile.
     *
     * @return La position de la tuile.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Récupère la couleur associée au type de la tuile.
     *
     * @return La couleur de la tuile.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Méthode de rendu (à adapter pour un affichage graphique).
     */
    public void render() {
        System.out.println("Tuile : " + type + " à la position " + position + " avec couleur " + color);
    }
}
