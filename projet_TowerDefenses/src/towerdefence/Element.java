package towerdefence;

/**
 * Enumération représentant les éléments dans le jeu Tower Defence.
 * Les éléments peuvent interagir de manière à avoir des faiblesses spécifiques.
 */
public enum Element {

    //!!!! Dans cette classe seulement la javadoc et les commentaires ont été généré par une IA !!!!

    NONE,
    FIRE,
    WATER,
    EARTH,
    WIND;

    /**
     * Vérifie si cet élément est vulnérable à un autre élément.
     *
     * @param other L'autre élément à comparer.
     * @return True si cet élément est vulnérable à l'autre, False sinon.
     */
    public Boolean isVulnerableTo(Element other) {
        switch (this) {
            case FIRE:
                return other == WATER;
            case WATER:
                return other == WIND;
            case EARTH:
                return other == FIRE;
            case WIND:
                return other == EARTH;
            default:
                return false;
        }
    }

    /**
     * Méthode main pour tester les interactions entre les éléments.
     *
     * @param args Arguments de ligne de commande.
     */
    public static void main(String[] args) {
        Element fire = Element.FIRE;
        Element water = Element.WATER;
        Element earth = Element.EARTH;
        Element wind = Element.WIND;

        System.out.println("FIRE est vulnérable à WATER ? " + fire.isVulnerableTo(water));
        System.out.println("WATER est vulnérable à WIND ? " + water.isVulnerableTo(wind));
        System.out.println("EARTH est vulnérable à FIRE ? " + earth.isVulnerableTo(fire));
        System.out.println("WIND est vulnérable à EARTH ? " + wind.isVulnerableTo(earth));
        System.out.println("NONE est vulnérable à FIRE ? " + Element.NONE.isVulnerableTo(fire));
    }
}
