package towerdefence.tower;

import java.util.ArrayList;
import towerdefence.*;
import towerdefence.enemy.Enemy;

/**
 * Classe représentant une tour de type "Earth Caster".
 */
public class EarthCasterTower extends Tower {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser une tour Earth Caster avec des caractéristiques
     * spécifiques.
     *
     * @param position Position initiale de la tour sur la carte.
     */
    public EarthCasterTower(Position position) {
        super(50, 50, 7, 0.5, 2.5, position, Element.EARTH, 100);
    }

    /**
     * Méthode pour trouver les cibles de la tour.
     * La tour cible les ennemis proches (distance < 1) et celui ayant le plus de
     * points de vie dans sa portée.
     *
     * @param enemies Liste des ennemis présents sur la carte.
     * @return Liste des ennemis ciblés.
     */
    @Override
    public ArrayList<Enemy> findTarget(ArrayList<Enemy> enemies) {
        Enemy morePVEnemy = null; // Ennemi avec le plus de points de vie.
        ArrayList<Enemy> enemiesTarget = new ArrayList<>(); // Liste des cibles de la tour.
        double maxPV = Double.MIN_VALUE;

        // Parcourt les ennemis pour identifier les cibles.
        for (Enemy e : enemies) {
            // Ajoute les ennemis très proches (distance < 1).
            if (this.getPosition().distanceTo(e.getPosition()) < 1) {
                enemiesTarget.add(e);
            }

            // Trouve l'ennemi ayant le plus de points de vie dans la portée de la tour.
            if (e.getHealth() > maxPV && isInRange(e)) {
                maxPV = e.getHealth();
                morePVEnemy = e;
            }
        }

        // Ajoute l'ennemi avec le plus de points de vie à la liste des cibles.
        if (morePVEnemy != null) {
            enemiesTarget.add(morePVEnemy);
        }

        return enemiesTarget;
    }
}
