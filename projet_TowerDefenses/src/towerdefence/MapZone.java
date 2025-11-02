package towerdefence;

import java.io.FileNotFoundException;
import java.awt.Color;

/**
 * Classe responsable du rendu visuel d'une zone de la carte.
 * Utilise StdDraw pour afficher les tuiles et la grille.
 */
public class MapZone {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Méthode pour dessiner une carte en fonction de son contenu.
     * Charge une carte à partir d'un fichier et dessine chaque case avec sa couleur
     * associée.
     */
    public static void render() {
        try {
            // Charger la carte
            char[][] map = MapLoader.map(
                    "C:\\Users\\noeca\\OneDrive\\Bureau\\licence\\2eme L2\\PO\\Projet\\projet_TowerDefenses\\resources\\maps\\10-10.mtp");

            // Dimensions de la grille
            double startX = 0;
            double startY = 0;
            double width = 700; // Largeur totale de la carte
            double height = 700; // Hauteur totale de la carte
            int gridSize = 10; // Taille de la grille (10x10)

            double cellWidth = width / gridSize; // Largeur d'une case
            double cellHeight = height / gridSize; // Hauteur d'une case

            // Dessiner la grille
            for (int row = 0; row < map.length; row++) {
                for (int col = 0; col < map[row].length; col++) {
                    double x = startX + (col + 0.5) * cellWidth; // Centre X de la case
                    double y = startY + (row + 0.5) * cellHeight; // Centre Y de la case

                    // Déterminer la couleur de la case
                    switch (map[row][col]) {
                        case 'S': StdDraw.setPenColor(StdDraw.RED); break;       // Spawn
                        case 'R': StdDraw.setPenColor(new Color(210, 180, 140)); break; // Route
                        case 'C': StdDraw.setPenColor(Color.LIGHT_GRAY); break; // Constructible
                        case 'X': StdDraw.setPenColor(new Color(11, 102, 35)); break; // Non constructible
                        case 'B': StdDraw.setPenColor(Color.ORANGE); break;     // Base
                        default: StdDraw.setPenColor(Color.BLACK); break;       // Erreur ou case inconnue
                    }

                    // Dessiner la case
                    StdDraw.filledRectangle(x, y, cellWidth / 2, cellHeight / 2);
                }
            }

            StdDraw.setPenColor(Color.BLACK); // Couleur des lignes de la grille

            // Lignes verticales
            for (int i = 0; i <= gridSize; i++) {
                double x = startX + i * cellWidth;
                StdDraw.line(x, startY, x, startY + height);
            }

            // Lignes horizontales
            for (int j = 0; j <= gridSize; j++) {
                double y = startY + j * cellHeight;
                StdDraw.line(startX, y, startX + width, y);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichier de carte introuvable : " + e.getMessage());
        }
    }
}
