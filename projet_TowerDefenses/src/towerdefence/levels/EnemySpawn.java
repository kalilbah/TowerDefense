package towerdefence.levels;

import towerdefence.enemy.Enemy;

/**
 * Classe EnemySpawn représentant un ennemi qui doit apparaître sur le champ de
 * bataille.
 */
public class EnemySpawn {

    private double spawnTime; // Temps d'apparition de l'ennemi.
    private String ennemyType; // Type de l'ennemi à faire apparaître.
    private Enemy enemy; // Instance de l'ennemi.

    /**
     * Constructeur pour initialiser les détails d'un spawn d'ennemi.
     *
     * @param spawnTime  Temps auquel l'ennemi doit apparaître.
     * @param ennemyType Type d'ennemi à faire apparaître (ex. "Boss", "Minion").
     * @param enemy      Instance de l'ennemi à faire apparaître.
     */
    public EnemySpawn(double spawnTime, String ennemyType, Enemy enemy) {
        this.spawnTime = spawnTime;
        this.ennemyType = ennemyType;
        this.enemy = enemy;
    }

    // Ajout de getters pour accéder aux attributs.

    /**
     * @return Temps d'apparition de l'ennemi.
     */
    public double getSpawnTime() {
        return spawnTime;
    }

    /**
     * @return Type de l'ennemi à faire apparaître.
     */
    public String getEnnemyType() {
        return ennemyType;
    }

    /**
     * @return Instance de l'ennemi.
     */
    public Enemy getEnemy() {
        return enemy;
    }
}
