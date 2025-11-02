package towerdefence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import towerdefence.levels.Tile;
import towerdefence.levels.TileType;

/**
 * Classe utilitaire pour charger des cartes (Map) à partir de fichiers.
 * Gère la lecture et la conversion des fichiers de cartes en tuiles
 * utilisables.
 */
public class MapLoader {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    /**
     * Charge une carte sous forme de tableau de caractères à partir d'un fichier.
     *
     * @param filePath Chemin du fichier de la carte.
     * @return Tableau 2D de caractères représentant la carte.
     * @throws FileNotFoundException Si le fichier n'est pas trouvé ou inaccessible.
     */
    public static char[][] map(String filePath) throws FileNotFoundException {
        int nbLignes = 0; // Nombre total de lignes.
        int nbLettresPremiereLigne = 0; // Nombre de colonnes dans la première ligne.

        // Étape 1 : Lire le fichier pour déterminer les dimensions de la carte.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String ligne;
            boolean premiereLigneLue = false;

            while ((ligne = br.readLine()) != null) {
                nbLignes++;
                if (!premiereLigneLue) {
                    nbLettresPremiereLigne = compterLettres(ligne);
                    premiereLigneLue = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            throw new FileNotFoundException("Impossible de lire le fichier : " + filePath);
        }

        // Étape 2 : Initialiser la carte en fonction des dimensions trouvées.
        char[][] map = new char[nbLignes][nbLettresPremiereLigne];

        // Étape 3 : Remplir la carte avec les caractères du fichier.
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int row = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                map[row] = line.replace(" ", "").toCharArray(); // Supprimer les espaces.
                row++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erreur : Fichier introuvable.");
            throw e;
        }

        return map;
    }

    /**
     * Compte le nombre de caractères non-espaces dans une ligne.
     *
     * @param ligne La ligne à analyser.
     * @return Nombre de caractères non-espaces.
     */
    private static int compterLettres(String ligne) {
        return ligne.replace(" ", "").length();
    }

    /**
     * Convertit une carte de caractères en tableau de tuiles (Tile).
     *
     * @param cheminMap Chemin du fichier de la carte.
     * @return Tableau 2D de tuiles représentant la carte.
     * @throws FileNotFoundException Si le fichier n'est pas trouvé.
     */
    public static Tile[][] tiles(String cheminMap) throws FileNotFoundException {
        char[][] map = map(cheminMap);
        int lignes = map.length;
        int colonnes = map[0].length;
        Tile[][] tiles = new Tile[lignes][colonnes];

        for (int row = 0; row < lignes; row++) {
            for (int col = 0; col < colonnes; col++) {
                switch (map[row][col]) {
                    case 'S':
                        tiles[row][col] = new Tile(TileType.SPAWN, null, new Position(row, col));
                        break; // Spawn.
                    case 'R':
                        tiles[row][col] = new Tile(TileType.ROUTE, null, new Position(row, col));
                        break; // Route.
                    case 'C':
                        tiles[row][col] = new Tile(TileType.CONSTRUCTIBLE, null, new Position(row, col));
                        break; // Constructible.
                    case 'X':
                        tiles[row][col] = new Tile(TileType.NONCONSTUCTIBLE, null, new Position(row, col));
                        break; // Non constructible.
                    case 'B':
                        tiles[row][col] = new Tile(TileType.BASE, null, new Position(row, col));
                        break; // Base.
                    default:
                        tiles[row][col] = new Tile(null, null, null); // Case inconnue.
                        break;
                }
            }
        }
        return tiles;
    }

    /**
     * Calcule la largeur de la carte en pixels.
     *
     * @param cheminMap Chemin du fichier de la carte.
     * @return Largeur de la carte.
     * @throws FileNotFoundException Si le fichier n'est pas trouvé.
     */
    public static double width(String cheminMap) throws FileNotFoundException {
        char[][] map = map(cheminMap);
        int lignes = map.length;
        int colonnes = map[0].length;

        return (lignes >= colonnes) ? 700 : (700.0 * colonnes) / lignes;
    }

    /**
     * Calcule la hauteur de la carte en pixels.
     *
     * @param cheminMap Chemin du fichier de la carte.
     * @return Hauteur de la carte.
     * @throws FileNotFoundException Si le fichier n'est pas trouvé.
     */
    public static double height(String cheminMap) throws FileNotFoundException {
        char[][] map = map(cheminMap);
        int lignes = map.length;
        int colonnes = map[0].length;

        return (colonnes >= lignes) ? 700 : (700.0 * lignes) / colonnes;
    }
}
