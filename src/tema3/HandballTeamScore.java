package tema3;

/**
 * The class for computing the score for a handball team using the Strategy pattern.
 */
public class HandballTeamScore implements Strategy {
    /**
    * Computes the score.
    */
    @Override
    public Team computeScore(Team team1, Team team2) {
        int score1;
        int score2;

        if (team1.gender.equals("feminin")) {
            score1 = team1.getProductOfScores();
            score2 = team2.getProductOfScores();
        } else {
            score1 = team1.getSumOfScores();
            score2 = team2.getSumOfScores();
        }

        if (score1 > score2) {
            return team1;
        } else if (score1 < score2) {
            return team2;
        } else {
            return null; // draw
        }
    }
}
