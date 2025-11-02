package towerdefence.tower;

import java.util.ArrayList;
import towerdefence.*;
import towerdefence.enemy.Enemy;

/**
 * Classe représentant une tour de type "Water Caster".
 */
public class WaterCasterTower extends Tower {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser une tour Water Caster avec des caractéristiques
     * spécifiques.
     *
     * @param position Position initiale de la tour sur la carte.
     */
    public WaterCasterTower(Position position) {
        super(30, 30, 3, 1, 4, position, Element.WATER, 50);
    }

    /**
     * Méthode pour trouver les cibles de la tour.
     * La tour cible l'ennemi le plus avancé dans sa portée.
     *
     * @param enemies Liste des ennemis présents sur la carte.
     * @return Liste contenant uniquement l'ennemi le plus avancé.
     */
    @Override
    public ArrayList<Enemy> findTarget(ArrayList<Enemy> enemies) {
        Enemy mostAdvancedEnemy = null; // Ennemi ayant parcouru la plus grande distance.
        double maxDistance = Double.MIN_VALUE; // Distance maximale parcourue.

        // Parcourt les ennemis pour identifier celui qui est le plus avancé.
        for (Enemy e : enemies) {
            if (isInRange(e) && e.getDistanceTraveled() > maxDistance) {
                maxDistance = e.getDistanceTraveled();
                mostAdvancedEnemy = e;
            }
        }

        // Retourne une liste contenant uniquement l'ennemi le plus avancé, s'il existe.
        ArrayList<Enemy> enemy = new ArrayList<>();
        if (mostAdvancedEnemy != null) {
            enemy.add(mostAdvancedEnemy);
        }
        return enemy;
    }
}
