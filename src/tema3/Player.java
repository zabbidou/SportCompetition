package tema3;

/**
 * The class Player.
 */
public class Player {
    /**
     * The Name.
     */
    String name;
    /**
     * The Score.
     */
    int score;

    /**
     * Instantiates a new Player.
     *
     * @param name  the name
     * @param score the score
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" + "name: " + name +
                ", score: " + score +
                '}';
    }
}
