package tema3;

/**
 * The implementation for the MatchVisitor.
 */
public class MatchImplementation implements MatchVisitor {
    /**
    * The strategy used.
    */
    Strategy strategy;

    @Override
    public FootballTeam visit(FootballTeam team1, FootballTeam team2) {
        strategy = new FootballTeamScore();
        return (FootballTeam) strategy.computeScore(team1, team2);
    }

    @Override
    public BasketballTeam visit(BasketballTeam team1, BasketballTeam team2) {
        strategy = new BasketballTeamScore();
        return (BasketballTeam) strategy.computeScore(team1, team2);
    }

    @Override
    public HandballTeam visit(HandballTeam team1, HandballTeam team2) {
        strategy = new HandballTeamScore();
        return (HandballTeam) strategy.computeScore(team1, team2);
    }
}
