package tema3;

/**
 * The class Basketball team.
 */
public class BasketballTeam extends Team {
    /**
     * Instantiates a new Basketball team.
     *
     * @param teamName        the team name
     * @param gender          the gender
     * @param numberOfPlayers the number of players
     */
    public BasketballTeam(String teamName, String gender, int numberOfPlayers) {
        super(teamName, gender, numberOfPlayers);
    }

    @Override
    public Team accept(MatchVisitor visitor, ITeam team) {
        return visitor.visit(this, (BasketballTeam) team);
    }

    @Override
    public String getTeamType() {
        return "basketball";
    }
}
