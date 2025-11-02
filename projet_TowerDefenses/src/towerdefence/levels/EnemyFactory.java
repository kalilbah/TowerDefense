package towerdefence.levels;

import towerdefence.*;
import towerdefence.enemy.*;

/**
 * Classe EnemyFactory pour créer des instances d'ennemis en fonction de leur
 * type.
 */
public class EnemyFactory {


    //!!!! Code de la méthode généré par une IA!!!!
    /**
     * Crée un ennemi en fonction de son nom et de sa position initiale.
     *
     * @param enemyName Nom du type d'ennemi à créer.
     * @param position  Position initiale de l'ennemi.
     * @return Instance de l'ennemi correspondant.
     */
    public Enemy createEnemy(String enemyName, Position position) {
        switch (enemyName.toLowerCase()) {
            case "boss":
                return new Boss(enemyName, position);
            case "earthbrute":
                return new EarthBruteEnemy(enemyName, position);
            case "firegrognard":
                return new FireGrognardEnemy(enemyName, position);
            case "minion":
                return new Minion(enemyName, position);
            case "waterbrute":
                return new WaterBruteEnemy(enemyName, position);
            case "windgrognard":
                return new WindGrognardEnemy(enemyName, position);
            default:
                throw new IllegalArgumentException("Type d'ennemi inconnu : " + enemyName);
        }
    }
}
