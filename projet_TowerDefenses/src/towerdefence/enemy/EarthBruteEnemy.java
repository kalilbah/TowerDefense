package towerdefence.enemy;

import java.util.ArrayList;

import towerdefence.*;
import towerdefence.tower.*;

/**
 * Classe représentant un ennemi de type "Earth Brute".
 */
public class EarthBruteEnemy extends Enemy {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser un ennemi Earth Brute avec des caractéristiques
     * spécifiques.
     *
     * @param nom      Nom de l'ennemi.
     * @param position Position initiale de l'ennemi.
     */
    public EarthBruteEnemy(String nom, Position position) {
        super(30, 30, 5, 1, 3, position, Element.EARTH, 1, 3, nom);
    }

    /**
     * Méthode pour trouver la cible la plus proche parmi une liste de tours.
     *
     * @param towers Liste des tours disponibles.
     * @return Liste contenant uniquement la tour la plus proche.
     */
    @Override
    public ArrayList<Tower> findTarget(ArrayList<Tower> towers) {
        ArrayList<Tower> towerTarget = new ArrayList<>();
        Tower nearestTower = null;
        double minDistance = Double.MAX_VALUE;

        // Recherche de la tour la plus proche dans la portée de l'ennemi.
        for (Tower t : towers) {
            if (isInRange(t) && this.getPosition().distanceTo(t.getPosition()) < minDistance) {
                minDistance = this.getPosition().distanceTo(t.getPosition());
                nearestTower = t;
            }
        }

        towerTarget.add(nearestTower);
        return towerTarget;
    }
}
