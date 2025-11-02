package towerdefence.enemy;

import java.util.ArrayList;
import towerdefence.*;
import towerdefence.levels.Map;
import towerdefence.tower.*;

/**
 * Classe abstraite représentant un ennemi dans le jeu.
 */
public abstract class Enemy extends Entity {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    private double speed; // Vitesse de déplacement de l'ennemi.
    private int reward; // Récompense obtenue lorsqu'on élimine cet ennemi.
    private double distanceTraveled; // Distance parcourue par l'ennemi sur le chemin.
    private String nom; // Nom de l'ennemi.

    // Getters et setters.
    public String getNom() {
        return nom;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public double getSpeed() {
        return speed;
    }

    public int getReward() {
        return reward;
    }

    /**
     * Constructeur pour initialiser un ennemi avec des caractéristiques
     * spécifiques.
     *
     * @param health      Points de vie actuels.
     * @param maxHealth   Points de vie maximum.
     * @param attack      Puissance d'attaque.
     * @param attackSpeed Vitesse d'attaque.
     * @param range       Portée d'attaque.
     * @param position    Position initiale.
     * @param element     Élément de l'ennemi.
     * @param speed       Vitesse de déplacement.
     * @param reward      Récompense pour éliminer l'ennemi.
     * @param nom         Nom de l'ennemi.
     */
    public Enemy(int health, int maxHealth, int attack, double attackSpeed, double range, Position position,
            Element element, double speed, int reward, String nom) {
        super(maxHealth, attack, attackSpeed, range, position, element);
        this.speed = speed;
        this.reward = reward;
        this.distanceTraveled = 0.0;
        this.nom = nom;
    }

    /**
     * Met à jour l'état de l'ennemi, notamment en attaquant les tours à portée.
     *
     * @param towers Liste des tours disponibles.
     */
    public void update(ArrayList<Tower> towers) {
        ArrayList<Tower> target = findTarget(towers);
        for (Tower t : target) {
            if (canAttack(t)) {
                System.out.println("Attaque la cible : " + t);
                t.takeDamage(this.getAttack(), this.getElement());
            }
        }
    }

    /**
     * Vérifie si l'ennemi est prêt à attaquer en fonction du temps de recharge.
     *
     * @return True si prêt à attaquer, False sinon.
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
     * Déplace l'ennemi le long du chemin.
     *
     * @param deltaTime Temps écoulé depuis la dernière mise à jour.
     */
    public void move(double deltaTime) {
        ArrayList<Position> chemin = Map.getPath();
        setPosition(chemin.get((int) distanceTraveled * 2)); // Mise à jour de la position.
        distanceTraveled = distanceTraveled + 0.5; // Mise à jour de la distance parcourue.
    }

    /**
     * Méthode abstraite pour trouver les cibles de l'ennemi.
     *
     * @param towers Liste des tours disponibles.
     * @return Liste des cibles identifiées.
     */
    public abstract ArrayList<Tower> findTarget(ArrayList<Tower> towers);

    /**
     * Méthode pour rendre une représentation de l'ennemi (non implémentée ici).
     *
     * @return Chaîne vide par défaut.
     */
    @Override
    public String render() {
        return "";
    }
}
