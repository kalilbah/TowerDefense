package towerdefence.tower;

import java.util.ArrayList;
import towerdefence.*;
import towerdefence.enemy.Enemy;

/**
 * Classe représentant une tour de type "Fire Caster".
 */
public class FireCasterTower extends Tower {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser une tour Fire Caster avec des caractéristiques
     * spécifiques.
     *
     * @param position Position initiale de la tour sur la carte.
     */
    public FireCasterTower(Position position) {
        super(30, 30, 10, 0.5, 2.5, position, Element.FIRE, 100);
    }

    /**
     * Méthode pour trouver les cibles de la tour.
     * La tour cible les ennemis proches (distance < 0.75) et l'ennemi le plus
     * proche dans sa portée.
     *
     * @param enemies Liste des ennemis présents sur la carte.
     * @return Liste des ennemis ciblés.
     */
    @Override
    public ArrayList<Enemy> findTarget(ArrayList<Enemy> enemies) {
        Enemy nearestEnemy = null; // Ennemi le plus proche.
        double distanceBTW = Double.MAX_VALUE; // Distance minimale trouvée.
        ArrayList<Enemy> enemiesTarget = new ArrayList<>(); // Liste des cibles.

        // Parcourt les ennemis pour identifier les cibles.
        for (Enemy e : enemies) {
            // Trouve l'ennemi le plus proche dans la portée de la tour.
            if (this.getPosition().distanceTo(e.getPosition()) < distanceBTW && isInRange(e)) {
                distanceBTW = this.getPosition().distanceTo(e.getPosition());
                nearestEnemy = e;
            }

            // Ajoute les ennemis très proches (distance < 0.75).
            if (this.getPosition().distanceTo(e.getPosition()) < 0.75) {
                enemiesTarget.add(e);
            }
        }

        // Ajoute l'ennemi le plus proche à la liste des cibles s'il existe.
        if (nearestEnemy != null) {
            enemiesTarget.add(nearestEnemy);
        }

        return enemiesTarget;
    }
}
