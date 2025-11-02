package towerdefence;

/**
 * Classe principale pour dessiner les zones du jeu Tower Defence.
 * Utilise StdDraw pour gérer les dessins.
 */
public class GameZones {

    //!!!! Dans cette classe seulement les commentaires ont été généré par une IA !!!!

    public static void main(String[] args) {
        // Configuration de la fenêtre de dessin
        StdDraw.setCanvasSize(1024, 720);
        StdDraw.setXscale(-12, 1012); // Définit les limites horizontales.
        StdDraw.setYscale(-10, 710); // Définit les limites verticales.
        // StdDraw.enableDoubleBuffering(); // Active le double buffering pour des
        // animations fluides (décommenter si nécessaire).

        // Dessiner le rectangle violet représentant une zone spécifique
        StdDraw.setPenColor(StdDraw.PURPLE);
        StdDraw.filledRectangle(350, 350, 350, 350);

        // Appeler le rendu de la carte (hypothétique MapZone.render)
        MapZone.render(); // Assurez-vous que MapZone est une classe définie.

        // Dessiner des zones rouges, vertes et bleues représentant d'autres éléments
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(856, 688, 144, 12); // Zone rouge.

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(856, 641, 144, 25); // Zone verte.

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledRectangle(856, 303, 144, 303); // Zone bleue.
    }
}
