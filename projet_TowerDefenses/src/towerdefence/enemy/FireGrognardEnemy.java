package towerdefence.enemy;

import java.util.ArrayList;

import towerdefence.*;
import towerdefence.tower.*;

/**
 * Classe représentant un ennemi de type "Fire Grognard".
 */
public class FireGrognardEnemy extends Enemy {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser un ennemi Fire Grognard avec des
     * caractéristiques spécifiques.
     *
     * @param nom      Nom de l'ennemi.
     * @param position Position initiale de l'ennemi.
     */
    public FireGrognardEnemy(String nom, Position position) {
        super(1, 1, 7, 2, 3, position, Element.FIRE, 2, 1, nom);
    }

    /**
     * Méthode pour trouver les cibles de l'ennemi, en se basant sur la proximité et
     * la portée.
     *
     * @param towers Liste des tours disponibles.
     * @return Liste des tours ciblées.
     */
    @Override
    public ArrayList<Tower> findTarget(ArrayList<Tower> towers) {
        ArrayList<Tower> towersTarget = new ArrayList<>();
        Tower nearestTower = null;
        double distanceBWT = Double.MAX_VALUE;

        // Recherche de la tour la plus proche dans la portée de l'ennemi.
        for (Tower t : towers) {
            if (this.getPosition().distanceTo(t.getPosition()) < distanceBWT && isInRange(t)) {
                distanceBWT = this.getPosition().distanceTo(t.getPosition());
                nearestTower = t;
            }

            // Ajout des tours à une distance inférieure à 1.5.
            if (this.getPosition().distanceTo(t.getPosition()) < 1.5) {
                towersTarget.add(t);
            }
        }

        // Ajout de la tour la plus proche.
        towersTarget.add(nearestTower);
        return towersTarget;
    }
}
