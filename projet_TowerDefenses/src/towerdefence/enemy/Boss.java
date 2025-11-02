package towerdefence.enemy;

import java.util.ArrayList;

import towerdefence.*;
import towerdefence.tower.*;

/**
 * Classe représentant un ennemi de type "Boss".
 */
public class Boss extends Enemy {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser un Boss avec des caractéristiques spécifiques.
     *
     * @param nom      Nom du boss.
     * @param position Position initiale du boss.
     */
    public Boss(String nom, Position position) {
        super(150, 150, 100, 10, 2.0, position, Element.FIRE, 0.5, 100, nom);
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

        // Recherche de la tour la plus proche dans la portée du boss.
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
