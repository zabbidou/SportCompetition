package tema3;

/**
 * The interface Match visitor.
 */
public interface MatchVisitor {
    /**
     * Compute score for two football teams.
     *
     * @param team1 the team 1
     * @param team2 the team 2
     * @return the winning football team
     */
    FootballTeam visit(FootballTeam team1, FootballTeam team2);

    /**
     * Compute score for two basketball teams.
     *
     * @param team1 the team 1
     * @param team2 the team 2
     * @return the winning basketball team
     */
    BasketballTeam visit(BasketballTeam team1, BasketballTeam team2);

    /**
     * Compute score for two handball teams.
     *
     * @param team1 the team 1
     * @param team2 the team 2
     * @return the winning handball team
     */
    HandballTeam visit(HandballTeam team1, HandballTeam team2);
}
