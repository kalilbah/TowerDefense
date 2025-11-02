package towerdefence.enemy;

import java.util.ArrayList;

import towerdefence.*;
import towerdefence.tower.*;

/**
 * Classe représentant un ennemi de type "Minion".
 */
public class Minion extends Enemy {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser un ennemi Minion avec des caractéristiques
     * spécifiques.
     *
     * @param nom      Nom du Minion.
     * @param position Position initiale du Minion.
     */
    public Minion(String nom, Position position) {
        super(10, 10, 0, 0, 0, position, Element.NONE, 1, 1, nom);
    }

    /**
     * Méthode pour trouver les cibles du Minion.
     * Ce type d'ennemi ne cible aucune tour, donc retourne null.
     *
     * @param towers Liste des tours disponibles.
     * @return Toujours null, car ce Minion ne cible pas de tours.
     */
    @Override
    public ArrayList<Tower> findTarget(ArrayList<Tower> towers) {
        return null;
    }
}
