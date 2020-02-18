package tema3;

/**
 * The class for computing the score for a handball team using the Strategy pattern.
 */
public class FootballTeamScore implements Strategy {
    /**
    * Computes the score.
    */
    @Override
    public Team computeScore(Team team1, Team team2) {
        int value1 = 0;
        int value2 = 0;

        if (team1.gender.equals("feminin")) {
            value1 = team1.getMin();
            value2 = team2.getMin();
        } else {
            value1 = team1.getMax();
            value2 = team2.getMax();
        }

        if (value1 + team1.getSumOfScores() > value2 + team2.getSumOfScores()) {
            return team1;
        } else if (value1 + team1.getSumOfScores() < value2 + team2.getSumOfScores()) {
            return team2;
        } else {
            return null; // draw
        }
    }
}
