package towerdefence.levels;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

/**
 * Classe représentant un niveau dans le jeu.
 */
public class Level {

    private Map map; // Carte associée au niveau.
    private ArrayList<Wave> waves; // Liste des vagues d'ennemis dans le niveau.
    private int currentWaveIndex; // Index de la vague actuelle.
    private String levelName; // Nom du niveau.
    private boolean isLevelComplete; // Indique si le niveau est terminé.
    private String cheminFichier; // Chemin du fichier de configuration du niveau.

    /**
     * Constructeur pour initialiser un niveau en fonction de son nom.
     *
     * @param levelName Nom du niveau.
     * @throws FileNotFoundException Si le fichier du niveau n'est pas trouvé.
     */
    public Level(String levelName) throws FileNotFoundException {
        this.map = new Map(cheminMap());
        this.waves = new ArrayList<>();
        this.currentWaveIndex = 0;
        this.levelName = levelName;
        this.isLevelComplete = false;
        this.cheminFichier = trouverChemin(
                "C:\\Users\\noeca\\OneDrive\\Bureau\\licence\\2eme L2\\PO\\Projet\\projet_TowerDefenses\\resources\\levels");
        loadLevel(this.cheminFichier);
    }


    // !!!! à partir de cette ligne le code à été généré par une IA !!!!

    /**
     * Trouve le chemin absolu du fichier du niveau dans un dossier donné.
     *
     * @param cheminDossier Chemin du dossier contenant les niveaux.
     * @return Chemin absolu du fichier du niveau.
     */
    private String trouverChemin(String cheminDossier) {
        File dossier = new File(cheminDossier);
        if (dossier.isDirectory()) {
            File[] fichiers = dossier.listFiles();
            if (fichiers != null) {
                for (File fichier : fichiers) {
                    if (fichier.isFile() && fichier.getName().equals(this.levelName)) {
                        return fichier.getAbsolutePath();
                    }
                }
            }
        } else {
            System.out.println(this.levelName + " n'est pas dans le dossier level");
        }
        return null;
    }

    /**
     * Lit le chemin de la carte depuis le fichier du niveau.
     *
     * @return Chemin absolu de la carte.
     */
    private String cheminMap() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.cheminFichier))) {
            String premiereLigne = br.readLine();
            if (premiereLigne != null) {
                return trouverChemin(premiereLigne);
            } else {
                System.out.println("Le fichier est vide.");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return null;
    }

    /**
     * Démarre le niveau en initialisant la première vague.
     */
    public void startLevel() {
        if (!waves.isEmpty()) {
            currentWaveIndex = 0;
            waves.get(currentWaveIndex).startWave();
        } else {
            System.out.println("Aucune vague n'est disponible pour ce niveau.");
        }
    }

    /**
     * Passe à la vague suivante.
     */
    public void nextWave() {
        if (currentWaveIndex < waves.size() - 1) {
            currentWaveIndex++;
            waves.get(currentWaveIndex).startWave();
        } else {
            System.out.println("Toutes les vagues ont été jouées.");
            isLevelComplete = true;
        }
    }

    /**
     * Vérifie si le niveau est terminé.
     *
     * @return True si le niveau est terminé, False sinon.
     */
    public boolean isLevelComplete() {
        return isLevelComplete;
    }

    /**
     * Met à jour l'état du niveau.
     *
     * @param deltaTime Temps écoulé depuis la dernière mise à jour.
     */
    public void update(double deltaTime) {
        if (!isLevelComplete) {
            Wave currentWave = waves.get(currentWaveIndex);
            currentWave.update(deltaTime);
            if (currentWave.isWaveComplete()) {
                nextWave();
            }
        }
    }

    /**
     * Charge le niveau à partir d'un fichier.
     *
     * @param filename Nom du fichier à charger.
     */
    public void loadLevel(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Ignorer la première ligne (chemin de la carte).
                    continue;
                }
                waves.add(new Wave(line)); // Charger les vagues restantes.
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement du niveau : " + e.getMessage());
        }
    }
}
