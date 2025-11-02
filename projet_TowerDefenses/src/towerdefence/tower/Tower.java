package towerdefence.tower;

import java.util.ArrayList;

import towerdefence.*;
import towerdefence.enemy.*;

/**
 * Classe abstraite représentant une tour dans le jeu Tower Defence.
 */
public abstract class Tower extends Entity {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    private int cost; // Coût de la construction de la tour.

    /**
     * Récupère le coût de la tour.
     *
     * @return Coût de la tour.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Constructeur pour initialiser une tour avec ses caractéristiques.
     *
     * @param health      Points de vie actuels.
     * @param maxHealth   Points de vie maximum.
     * @param attack      Puissance d'attaque.
     * @param attackSpeed Vitesse d'attaque (nombre d'attaques par seconde).
     * @param range       Portée de la tour.
     * @param position    Position de la tour sur la carte.
     * @param element     Élément associé à la tour (feu, eau, etc.).
     * @param cost        Coût de construction de la tour.
     */
    public Tower(int health, int maxHealth, int attack, double attackSpeed, double range, Position position,
            Element element, int cost) {
        super(maxHealth, attack, attackSpeed, range, position, element);
        this.cost = cost;
    }

    /**
     * Met à jour l'état de la tour en attaquant les ennemis à portée.
     *
     * @param enemies Liste des ennemis sur la carte.
     */
    public void update(ArrayList<Enemy> enemies) {
        ArrayList<Enemy> target = findTarget(enemies);
        for (Enemy e : target) {
            if (canAttack(e)) {
                System.out.println("Attaque la cible : " + e);
                e.takeDamage(this.getAttack(), this.getElement());
            }
        }
    }

    /**
     * Méthode abstraite pour trouver les cibles de la tour.
     *
     * @param enemies Liste des ennemis sur la carte.
     * @return Liste des ennemis ciblés.
     */
    public abstract ArrayList<Enemy> findTarget(ArrayList<Enemy> enemies);

    /**
     * Vérifie si la tour est prête à attaquer en fonction de son temps de recharge.
     *
     * @return True si prête à attaquer, False sinon.
     */
    @Override
    public Boolean readyToAttack() {
        long currentTime = System.currentTimeMillis();
        double cooldownTime = getAttackSpeed() * 1000;
        if (currentTime - getLastAttackTime() >= cooldownTime) {
            setLastAttackTime(currentTime);
            return true;
        }
        return false;
    }

    /**
     * Rendu graphique ou représentation textuelle de la tour.
     *
     * @return Chaîne décrivant la tour.
     */
    @Override
    public String render() {
        // Représentation textuelle de la tour pour débogage ou affichage simple.
        return "Tour : " +
                "\n - Position : " + getPosition() +
                "\n - Élément : " + getElement() +
                "\n - Portée : " + getRange() +
                "\n - Attaque : " + getAttack() +
                "\n - Vitesse d'attaque : " + getAttackSpeed() +
                "\n - Coût : " + cost;
    }
}
