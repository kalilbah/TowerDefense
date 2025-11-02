package towerdefence.levels;

import java.util.ArrayList;


/**
 * Classe représentant une vague d'ennemis dans un niveau.
 */
public class Wave {

    private ArrayList<EnemySpawn> enemySpawns; // Liste des spawns d'ennemis.
    private double currentTime; // Temps actuel.
    private boolean isComplete; // Indique si la vague est terminée.
    private EnemyFactory enemyFactory; // Usine pour créer des ennemis.

    /**
     * Constructeur pour initialiser une vague à partir d'une liste de spawns.
     *
     * @param enemySpawns Liste des spawns d'ennemis.
     */
    public Wave(ArrayList<EnemySpawn> enemySpawns) {
        this.enemySpawns = enemySpawns;
        this.currentTime = System.currentTimeMillis();
        this.isComplete = false;
        this.enemyFactory = new EnemyFactory();
    }

    //!!!! à partir de cette ligne le code à été généré par une IA !!!!

    /**
     * Constructeur pour initialiser une vague à partir d'une chaîne.
     *
     * @param waveData Données de la vague sous forme de chaîne.
     */
    public Wave(String waveData) {
        this.enemySpawns = parseWaveData(waveData);
        this.currentTime = System.currentTimeMillis();
        this.isComplete = false;
        this.enemyFactory = new EnemyFactory();
    }

    /**
     * Analyse une chaîne pour créer une liste de spawns d'ennemis.
     *
     * @param waveData Données de la vague sous forme de chaîne.
     * @return Liste des spawns d'ennemis.
     */
    private ArrayList<EnemySpawn> parseWaveData(String waveData) {
        ArrayList<EnemySpawn> spawns = new ArrayList<>();
        String[] entries = waveData.split(";"); // Séparation des différents spawns.
        for (String entry : entries) {
            String[] parts = entry.split(","); // Séparation du temps de spawn et du type d'ennemi.
            double spawnTime = Double.parseDouble(parts[0].trim());
            String enemyType = parts[1].trim();
            spawns.add(new EnemySpawn(spawnTime, enemyType, null)); // Initialisation sans ennemi concret.
        }
        return spawns;
    }

    /**
     * Met à jour l'état de la vague en faisant apparaître les ennemis au bon
     * moment.
     *
     * @param deltaTime Temps écoulé depuis la dernière mise à jour.
     */
    public void update(double deltaTime) {
        double elapsedTime = (System.currentTimeMillis() - currentTime) / 1000.0;

        for (int i = 0; i < enemySpawns.size(); i++) {
            EnemySpawn spawn = enemySpawns.get(i);

            // Si le temps de spawn est atteint, crée l'ennemi et retire le spawn.
            if (elapsedTime >= spawn.getSpawnTime()) {
                System.out.println("Spawned enemy: " + spawn.getEnnemyType() + " at " + spawn.getEnemy().getPosition());
                enemySpawns.remove(i);
                i--; // Ajuster l'index après suppression.
            }
        }

        // Si tous les spawns sont traités, la vague est terminée.
        if (enemySpawns.isEmpty()) {
            this.isComplete = true;
        }
    }

    /**
     * Démarre la vague en réinitialisant le temps actuel.
     */
    public void startWave() {
        this.currentTime = System.currentTimeMillis();
        this.isComplete = false;
    }

    /**
     * Vérifie si la vague est terminée.
     *
     * @return True si la vague est terminée, False sinon.
     */
    public boolean isWaveComplete() {
        return isComplete;
    }
}
