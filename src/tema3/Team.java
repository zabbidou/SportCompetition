package tema3;

import java.util.ArrayList;

/**
 * The class Team.
 */
public abstract class Team implements ITeam {
    /**
     * The Team name.
     */
    String teamName;
    /**
     * The Gender.
     */
    String gender; // feminin / masculin
    /**
     * The Number of players.
     */
    int numberOfPlayers;
    /**
     * The Players.
     */
    ArrayList<Player> players;
    /**
     * The Score.
     */
    int score;
    /**
     * The place occupied in the leaderboard.
     */
    int place;

    /**
     * Instantiates a new Team.
     *
     * @param teamName        the team name
     * @param gender          the gender
     * @param numberOfPlayers the number of players
     */
    public Team(String teamName,
                String gender,
                int numberOfPlayers) {
        this.teamName = teamName;
        this.gender = gender;
        this.numberOfPlayers = numberOfPlayers;
        this.players = new ArrayList<>();
    }

    /**
     * Add win points.
     */
    public void addWinPoints() {
        this.score += 3;
    }

    /**
     * Add draw points.
     */
    public void addDrawPoints() {
        this.score += 1;
    }

    public String getTeamName() {
        return teamName;
    }

    /**
     * Gets place.
     *
     * @return the place
     */
    public int getPlace() {
        return place;
    }

    @Override
    public int compareTo(ITeam team) {
        return ((Team)team).score - this.score;
    }

    @Override
    public String getGender() {
        return gender;
    }

    /**
     * Add player.
     *
     * @param name  the name
     * @param score the score
     */
    public void addPlayer(String name, int score) {
        this.players.add(new Player(name, score));
    }

    /**
     * Gets the min score from all the players.
     *
     * @return the min
     */
    public int getMin() {
        int min = Integer.MAX_VALUE;

        for (Player player : players) {
            if (player.score < min) {
                min = player.score;
            }
        }

        return min;
    }

    /**
     * Gets the max score from all the players.
     *
     * @return the max
     */
    public int getMax() {
        int max = Integer.MIN_VALUE;

        for (Player player : players) {
            if (player.score > max) {
                max = player.score;
            }
        }

        return max;
    }

    /**
     * Gets sum of all players' scores.
     *
     * @return the sum of scores
     */
    public int getSumOfScores() {
        int sum = 0;

        for (Player player : players) {
            sum += player.score;
        }

        return sum;
    }

    /**
     * Gets product of all players' scores.
     *
     * @return the product of scores
     */
    public int getProductOfScores() {
        int mul = 1;

        for (Player player : players) {
            mul *= player.score;
        }

        return mul;
    }

    /**
     * Gets the mean of all scores.
     *
     * @return the double
     */
    public double getMeanScore() {
        return 1.0 * getSumOfScores() / players.size();
    }

    @Override
    public String toString() {
        return "{" + "teamName: " + teamName +
                ", gender: " + gender +
                ", numberOfPlayers: " + numberOfPlayers +
                ", players: " + players +
                '}';
    }

    @Override
    public void update(int place) {
        this.place = place;
    }
}
