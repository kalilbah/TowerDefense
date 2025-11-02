package towerdefence.enemy;

import java.util.ArrayList;

import towerdefence.*;
import towerdefence.tower.*;

/**
 * Classe représentant un ennemi de type "Wind Grognard".
 */
public class WindGrognardEnemy extends Enemy {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser un ennemi Wind Grognard avec des
     * caractéristiques spécifiques.
     *
     * @param nom      Nom de l'ennemi.
     * @param position Position initiale de l'ennemi.
     */
    public WindGrognardEnemy(String nom, Position position) {
        super(1, 1, 7, 2, 5, position, Element.WIND, 2, 1, nom);
    }

    /**
     * Méthode pour trouver la cible du Wind Grognard.
     * L'ennemi cible la tour ayant le moins de points de vie dans sa portée.
     *
     * @param towers Liste des tours disponibles.
     * @return Liste contenant uniquement la tour avec le moins de points de vie.
     */
    @Override
    public ArrayList<Tower> findTarget(ArrayList<Tower> towers) {
        Tower minPVTower = null; // Tour ayant le moins de points de vie.
        double minPV = Double.MAX_VALUE;

        // Recherche de la tour avec le moins de points de vie dans la portée.
        for (Tower t : towers) {
            if (isInRange(t) && t.getHealth() < minPV) {
                minPV = t.getHealth();
                minPVTower = t;
            }
        }

        // Retourne la tour trouvée.
        ArrayList<Tower> tower = new ArrayList<>();
        tower.add(minPVTower);
        return tower;
    }
}
