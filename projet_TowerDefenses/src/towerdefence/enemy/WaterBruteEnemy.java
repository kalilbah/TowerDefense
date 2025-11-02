package towerdefence.enemy;

import java.util.ArrayList;

import towerdefence.*;
import towerdefence.tower.*;

/**
 * Classe représentant un ennemi de type "Water Brute".
 */
public class WaterBruteEnemy extends Enemy {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser un ennemi Water Brute avec des caractéristiques
     * spécifiques.
     *
     * @param nom      Nom de l'ennemi.
     * @param position Position initiale de l'ennemi.
     */
    public WaterBruteEnemy(String nom, Position position) {
        super(30, 30, 5, 1, 3, position, Element.WATER, 1, 3, nom);
    }

    /**
     * Méthode pour trouver les cibles du Water Brute.
     * L'ennemi cible la tour ayant le moins de points de vie et ajoute aussi les
     * tours proches.
     *
     * @param towers Liste des tours disponibles.
     * @return Liste des tours ciblées.
     */
    @Override
    public ArrayList<Tower> findTarget(ArrayList<Tower> towers) {
        ArrayList<Tower> towersTarget = new ArrayList<>();
        Tower minPVTower = null; // Tour ayant le moins de points de vie.
        double minPV = Double.MIN_VALUE;

        // Recherche de la tour avec le moins de points de vie et des tours proches.
        for (Tower t : towers) {
            if (t.getHealth() < minPV && isInRange(t)) {
                minPV = t.getHealth();
                minPVTower = t;
            }

            // Ajout des tours à une distance inférieure à 1.5.
            if (this.getPosition().distanceTo(t.getPosition()) < 1.5) {
                towersTarget.add(t);
            }
        }

        // Ajout de la tour avec le moins de points de vie.
        towersTarget.add(minPVTower);
        return towersTarget;
    }
}
