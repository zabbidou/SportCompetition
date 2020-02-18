package tema3;

/**
 * The class for computing the score for a handball team using the Strategy pattern.
 */
public class BasketballTeamScore implements Strategy {
    /**
    * Computes the score.
    */
    @Override
    public Team computeScore(Team team1, Team team2) {
        if (Double.compare(team1.getMeanScore(), team2.getMeanScore()) > 0) {
            return team1;
        } else if (Double.compare(team1.getMeanScore(), team2.getMeanScore()) < 0) {
            return team2;
        } else {
            return null; // draw
        }
    }
}
