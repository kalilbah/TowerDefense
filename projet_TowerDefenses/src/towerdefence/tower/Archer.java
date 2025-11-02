package towerdefence.tower;

import towerdefence.enemy.Enemy;
import java.util.ArrayList;
import towerdefence.*;

/**
 * Classe représentant une tour de type "Archer".
 */
public class Archer extends Tower {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser une tour Archer avec des caractéristiques par
     * défaut.
     *
     * @param position Position initiale de la tour sur la carte.
     */
    public Archer(Position position) {
        super(30, 30, 5, 1, 2, position, Element.NONE, 20);
    }

    /**
     * Méthode pour trouver la cible la plus avancée parmi les ennemis à portée.
     *
     * @param enemies Liste des ennemis présents sur la carte.
     * @return Liste contenant uniquement l'ennemi le plus avancé.
     */
    @Override
    public ArrayList<Enemy> findTarget(ArrayList<Enemy> enemies) {
        Enemy mostAdvancedEnemy = null;
        double maxDistance = Double.MIN_VALUE;

        // Parcourt les ennemis pour trouver celui qui est le plus avancé dans le
        // chemin.
        for (Enemy e : enemies) {
            if (isInRange(e) && e.getDistanceTraveled() > maxDistance) {
                maxDistance = e.getDistanceTraveled();
                mostAdvancedEnemy = e;
            }
        }

        // Crée une liste contenant uniquement l'ennemi trouvé.
        ArrayList<Enemy> enemy = new ArrayList<>();
        if (mostAdvancedEnemy != null) {
            enemy.add(mostAdvancedEnemy);
        }
        return enemy;
    }
}
