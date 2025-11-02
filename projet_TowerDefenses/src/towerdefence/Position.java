package towerdefence;

/**
 * Classe représentant une position 2D dans le jeu Tower Defence.
 */
public class Position {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    private double x; // Coordonnée X de la position.
    private double y; // Coordonnée Y de la position.

    /**
     * Constructeur pour initialiser une position avec des coordonnées spécifiques.
     *
     * @param x Coordonnée X.
     * @param y Coordonnée Y.
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters et setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calcule la distance euclidienne entre cette position et une autre position.
     *
     * @param other L'autre position à comparer.
     * @return La distance euclidienne entre les deux positions.
     */
    public double distanceTo(Position other) {
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Vérifie si une autre position est dans une certaine portée.
     *
     * @param other L'autre position à comparer.
     * @param range La portée à vérifier.
     * @return True si l'autre position est dans la portée, False sinon.
     */
    public boolean isInRange(Position other, double range) {
        return distanceTo(other) <= range;
    }

    @Override
    public String toString() {
        return "Position{x=" + x + ", y=" + y + "}";
    }

    /**
     * Méthode principale pour tester la classe Position.
     *
     * @param args Arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(3, 4);

        System.out.println("Position 1: " + pos1);
        System.out.println("Position 2: " + pos2);
        System.out.println("Distance entre les deux positions: " + pos1.distanceTo(pos2));
        System.out.println("Position 2 est-elle dans un rayon de 5 de Position 1 ? " + pos1.isInRange(pos2, 5));
    }
}
