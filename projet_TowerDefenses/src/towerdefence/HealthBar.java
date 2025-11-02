package towerdefence;

/**
 * Classe représentant une barre de santé pour les entités du jeu Tower Defence.
 * Gère l'affichage visuel et les mises à jour de la santé d'une entité.
 */
public class HealthBar {
    private int maxHealth; // Santé maximale de l'entité.
    private int health; // Santé actuelle de l'entité.
    private Position position; // Position associée à la barre de santé.

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Constructeur pour initialiser une barre de santé.
     *
     * @param maxHealth Santé maximale de l'entité.
     * @param position  Position de l'entité sur la carte.
     */
    public HealthBar(int maxHealth, Position position) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Max health must be positive");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Santé initiale = santé maximale.
        this.position = position;
    }

    /**
     * Met à jour la santé actuelle de l'entité.
     *
     * @param newHealth Nouvelle valeur de santé.
     */
    public void updateHealth(int newHealth) {
        if (newHealth > maxHealth) {
            this.health = maxHealth; // Ne dépasse pas la santé maximale.
        } else if (newHealth < 0) {
            this.health = 0; // La santé ne peut pas être négative.
        } else {
            this.health = newHealth;
        }
    }

    /**
     * Vérifie si l'entité est morte (santé à 0).
     *
     * @return True si l'entité est morte, False sinon.
     */
    public boolean isDead() {
        return health == 0;
    }

    /**
     * Représentation visuelle de la barre de santé.
     * La barre est composée de blocs pleins (█) et vides (-).
     *
     * @return Chaîne représentant l'état visuel de la barre de santé.
     */
    public String render() {
        int width = 10; // Largeur fixe pour la barre de santé.
        int filledUnits = (int) ((double) health / maxHealth * width);
        int emptyUnits = width - filledUnits;

        return "█".repeat(filledUnits) + "-".repeat(emptyUnits);
    }

    @Override
    public String toString() {
        return "HealthBar [Position=" + position + ", Health=" + health + "/" + maxHealth + ", Visual=" + render()
                + "]";
    }

    /**
     * Méthode principale pour tester la classe HealthBar.
     *
     * @param args Arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        Position position = new Position(5, 5);
        HealthBar healthBar = new HealthBar(100, position);

        System.out.println("Initial : " + healthBar); // Affiche la barre complète.

        healthBar.updateHealth(50);
        System.out.println("50% Health : " + healthBar); // Affiche une barre à moitié remplie.

        healthBar.updateHealth(0);
        System.out.println("Dead : " + healthBar); // Affiche une barre vide.
        System.out.println("Is dead? " + healthBar.isDead()); // true.
    }
}
