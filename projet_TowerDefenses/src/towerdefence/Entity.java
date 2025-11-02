package towerdefence;

/**
 * Classe abstraite représentant une entité dans le jeu Tower Defence.
 * Une entité peut être une tour, un ennemi ou une autre unité ayant des
 * caractéristiques de combat.
 */
public abstract class Entity {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    private int health; // Points de vie actuels.
    private int maxHealth; // Points de vie maximum.
    private int attack; // Puissance d'attaque.
    private double attackSpeed; // Vitesse d'attaque (nombre d'attaques par seconde).
    private double range; // Portée d'attaque.
    private Position position; // Position actuelle de l'entité.
    private Element element; // Élément associé à l'entité (FIRE, WATER, etc.).
    private HealthBar healthBar; // Barre de santé associée à l'entité.
    private long lastAttackTime; // Temps du dernier coup porté.

    // Getters et setters
    public long getLastAttackTime() {
        return lastAttackTime;
    }

    public void setLastAttackTime(long lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    public HealthBar getHealthBar() {
        return healthBar;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health cannot be negative");
        }
        this.health = Math.min(health, this.maxHealth);
    }

    public void setMaxHealth(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Max health must be positive");
        }
        this.maxHealth = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        if (attackSpeed <= 0) {
            throw new IllegalArgumentException("Attack speed must be positive");
        }
        this.attackSpeed = attackSpeed;
    }

    public double getRange() {
        return range;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        this.position = position;
    }

    public Element getElement() {
        return element;
    }

    /**
     * Constructeur pour initialiser une entité avec des caractéristiques
     * spécifiques.
     *
     * @param maxHealth   Points de vie maximum.
     * @param attack      Puissance d'attaque.
     * @param attackSpeed Vitesse d'attaque (attaques par seconde).
     * @param range       Portée d'attaque.
     * @param position    Position initiale.
     * @param element     Élément de l'entité.
     */
    public Entity(int maxHealth, int attack, double attackSpeed, double range, Position position, Element element) {
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.position = position;
        this.element = element;
        this.healthBar = new HealthBar(maxHealth, position);
        this.lastAttackTime = 0;
    }

    /**
     * Réduit les points de vie de l'entité en fonction des dégâts subis et des
     * interactions élémentaires.
     *
     * @param damage        Quantité de dégâts infligés.
     * @param sourceElement Élément de la source des dégâts.
     */
    public void takeDamage(int damage, Element sourceElement) {
        double multiplier = 1.0;

        // Vérifie la vulnérabilité ou la résistance
        if (this.element.isVulnerableTo(sourceElement)) {
            multiplier = 1.5; // Vulnérabilité accrue
        } else if (sourceElement.isVulnerableTo(this.element)) {
            multiplier = 0.5; // Résistance réduite
        }

        // Applique les dégâts avec le multiplicateur
        int finalDamage = (int) (damage * multiplier);
        this.health -= finalDamage;

        // Santé minimale à 0
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Vérifie si une entité cible est dans la portée de cette entité.
     *
     * @param target Entité cible.
     * @return True si la cible est dans la portée, False sinon.
     */
    public boolean isInRange(Entity target) {
        return this.position.distanceTo(target.position) <= this.range;
    }

    /**
     * Vérifie si cette entité peut attaquer une entité cible.
     *
     * @param target Entité cible.
     * @return True si l'entité peut attaquer, False sinon.
     */
    public boolean canAttack(Entity target) {
        if (this.health == 0) {
            return false; // Cette entité est morte.
        }
        if (target.getHealth() <= 0) {
            return false; // La cible est morte.
        }
        if (!this.isInRange(target)) {
            return false; // La cible est hors de portée.
        }
        if (!readyToAttack()) {
            return false; // Cette entité n'est pas prête à attaquer.
        }
        return true;
    }

    /**
     * Méthode abstraite pour représenter visuellement l'entité (à implémenter dans
     * les sous-classes).
     *
     * @return Représentation visuelle ou textuelle de l'entité.
     */
    public abstract String render();

    /**
     * Méthode abstraite pour vérifier si l'entité est prête à attaquer (à
     * implémenter dans les sous-classes).
     *
     * @return True si prête à attaquer, False sinon.
     */
    public abstract Boolean readyToAttack();
}
