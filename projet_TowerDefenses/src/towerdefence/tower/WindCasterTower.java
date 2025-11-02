package towerdefence.tower;

import java.util.ArrayList;
import towerdefence.*;
import towerdefence.enemy.Enemy;

/**
 * Classe représentant une tour de type "Wind Caster".
 */
public class WindCasterTower extends Tower {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser une tour Wind Caster avec des caractéristiques
     * spécifiques.
     *
     * @param position Position initiale de la tour sur la carte.
     */
    public WindCasterTower(Position position) {
        super(30, 30, 5, 1.5, 6, position, Element.WIND, 50);
    }

    /**
     * Méthode pour trouver les cibles de la tour.
     * La tour cible l'ennemi le plus proche dans sa portée.
     *
     * @param enemies Liste des ennemis présents sur la carte.
     * @return Liste contenant uniquement l'ennemi le plus proche.
     */
    @Override
    public ArrayList<Enemy> findTarget(ArrayList<Enemy> enemies) {
        Enemy nearestEnemy = null; // Ennemi le plus proche.
        double distanceBTW = Double.MAX_VALUE; // Distance minimale trouvée.

        // Parcourt les ennemis pour identifier celui qui est le plus proche.
        for (Enemy e : enemies) {
            if (this.getPosition().distanceTo(e.getPosition()) < distanceBTW && isInRange(e)) {
                distanceBTW = this.getPosition().distanceTo(e.getPosition());
                nearestEnemy = e;
            }
        }

        // Retourne une liste contenant uniquement l'ennemi le plus proche, s'il existe.
        ArrayList<Enemy> enemy = new ArrayList<>();
        if (nearestEnemy != null) {
            enemy.add(nearestEnemy);
        }
        return enemy;
    }
}
