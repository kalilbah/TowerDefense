package towerdefence.levels;

import towerdefence.*;
import towerdefence.tower.*;
import java.io.*;
import java.util.*;

/**
 * Classe représentant la carte d'un niveau dans le jeu Tower Defence.
 */
public class Map {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    private Tile[][] tiles; // Grille de tuiles représentant la carte.
    private Position spawnPosition; // Position de départ des ennemis.
    private Position basePosition; // Position de la base à défendre.
    private static ArrayList<Position> path; // Chemin des ennemis vers la base.
    private double width; // Largeur de la carte en pixels.
    private double height; // Hauteur de la carte en pixels.
    private String cheminMap; // Chemin du fichier décrivant la carte.

    // Getters
    public static ArrayList<Position> getPath() {
        return path;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Constructeur pour initialiser la carte à partir d'un fichier.
     *
     * @param cheminMap Chemin du fichier de la carte.
     * @throws FileNotFoundException Si le fichier n'existe pas.
     */
    public Map(String cheminMap) throws FileNotFoundException {
        this.cheminMap = cheminMap;
        this.tiles = tiles(cheminMap); // Initialisation des tuiles.
        this.spawnPosition = null;
        this.basePosition = null;
        Map.path = calculatePath(); // Calcul du chemin des ennemis.
        this.width = calculateWidth(cheminMap); // Calcul de la largeur de la carte.
        this.height = calculateHeight(cheminMap); // Calcul de la hauteur de la carte.
    }

    /**
     * Calcule le chemin des ennemis depuis le spawn jusqu'à la base.
     *
     * @return Liste des positions formant le chemin.
     * @throws FileNotFoundException Si le fichier est introuvable.
     */
    private ArrayList<Position> calculatePath() throws FileNotFoundException {
        ArrayList<Position> chemin = new ArrayList<>();
        Position positionActuel = spawnPosition;
        Position precedante = positionActuel;

        while (!positionActuel.equals(basePosition)) {
            chemin.add(positionActuel);
            switch (obtenirLaPositionSuivante(positionActuel, precedante)) {
                case "HAUT":
                    precedante = positionActuel;
                    positionActuel = new Position(positionActuel.getX(), positionActuel.getY() + 1);
                    break;
                case "DROITE":
                    precedante = positionActuel;
                    positionActuel = new Position(positionActuel.getX() + 1, positionActuel.getY());
                    break;
                case "BAS":
                    precedante = positionActuel;
                    positionActuel = new Position(positionActuel.getX(), positionActuel.getY() - 1);
                    break;
                case "GAUCHE":
                    precedante = positionActuel;
                    positionActuel = new Position(positionActuel.getX() - 1, positionActuel.getY());
                    break;
                default:
                    throw new IllegalStateException("Chemin non valide, aucune route trouvée.");
            }
        }
        return chemin;
    }

    /**
     * Détermine la direction de la prochaine position sur le chemin.
     *
     * @param positionActuel Position actuelle.
     * @param precedante     Position précédente.
     * @return Direction de la prochaine position ("HAUT", "DROITE", "BAS",
     *         "GAUCHE").
     */
    private String obtenirLaPositionSuivante(Position positionActuel, Position precedante) {
        int x = (int) positionActuel.getX();
        int y = (int) positionActuel.getY();

        if (tiles[x][y + 1].isRoute() && !new Position(x, y + 1).equals(precedante)) {
            return "HAUT";
        }
        if (tiles[x + 1][y].isRoute() && !new Position(x + 1, y).equals(precedante)) {
            return "DROITE";
        }
        if (tiles[x][y - 1].isRoute() && !new Position(x, y - 1).equals(precedante)) {
            return "BAS";
        }
        if (tiles[x - 1][y].isRoute() && !new Position(x - 1, y).equals(precedante)) {
            return "GAUCHE";
        }
        return "";
    }

    /**
     * Renvoie une tuile de la carte en fonction des coordonnées.
     *
     * @param x Coordonnée X.
     * @param y Coordonnée Y.
     * @return Tuile correspondante.
     */
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    /**
     * Initialise les tuiles de la carte en fonction du fichier.
     *
     * @param cheminMap Chemin du fichier de la carte.
     * @return Grille de tuiles initialisée.
     * @throws FileNotFoundException Si le fichier est introuvable.
     */
    private Tile[][] tiles(String cheminMap) throws FileNotFoundException {
        char[][] map = map(cheminMap);
        int lignes = map.length;
        int colonnes = map[0].length;
        Tile[][] tiles = new Tile[lignes][colonnes];

        for (int row = 0; row < lignes; row++) {
            for (int col = 0; col < colonnes; col++) {
                switch (map[row][col]) {
                    case 'S':
                        tiles[row][col] = new Tile(TileType.SPAWN, null, new Position(row, col));
                        this.spawnPosition = new Position(row, col);
                        break;
                    case 'R':
                        tiles[row][col] = new Tile(TileType.ROUTE, null, new Position(row, col));
                        break;
                    case 'C':
                        tiles[row][col] = new Tile(TileType.CONSTRUCTIBLE, null, new Position(row, col));
                        break;
                    case 'X':
                        tiles[row][col] = new Tile(TileType.NONCONSTUCTIBLE, null, new Position(row, col));
                        break;
                    case 'B':
                        tiles[row][col] = new Tile(TileType.BASE, null, new Position(row, col));
                        this.basePosition = new Position(row, col);
                        break;
                    default:
                        tiles[row][col] = new Tile(null, null, null);
                }
            }
        }
        return tiles;
    }

    /**
     * Charge une carte depuis un fichier.
     *
     * @param filePath Chemin du fichier de la carte.
     * @return Carte sous forme de caractères.
     * @throws FileNotFoundException Si le fichier est introuvable.
     */
    private char[][] map(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        ArrayList<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine().replace(" ", ""));
        }
        scanner.close();

        char[][] map = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            map[i] = lines.get(i).toCharArray();
        }
        return map;
    }

    /**
     * Calcule la largeur de la carte.
     *
     * @param cheminMap Chemin du fichier de la carte.
     * @return Largeur en pixels.
     * @throws FileNotFoundException Si le fichier est introuvable.
     */
    private double calculateWidth(String cheminMap) throws FileNotFoundException {
        char[][] map = map(cheminMap);
        int lignes = map.length;
        int colonnes = map[0].length;

        return (lignes >= colonnes) ? 700 : (700.0 * colonnes) / lignes;
    }

    /**
     * Calcule la hauteur de la carte.
     *
     * @param cheminMap Chemin du fichier de la carte.
     * @return Hauteur en pixels.
     * @throws FileNotFoundException Si le fichier est introuvable.
     */
    private double calculateHeight(String cheminMap) throws FileNotFoundException {
        char[][] map = map(cheminMap);
        int lignes = map.length;
        int colonnes = map[0].length;

        return (colonnes >= lignes) ? 700 : (700.0 * lignes) / colonnes;
    }
}
