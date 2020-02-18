package tema3;

/**
 * The class Handball team.
 */
public class HandballTeam extends Team {
    /**
     * Instantiates a new Handball team.
     *
     * @param teamName        the team name
     * @param gender          the gender
     * @param numberOfPlayers the number of players
     */
    public HandballTeam(String teamName, String gender, int numberOfPlayers) {
        super(teamName, gender, numberOfPlayers);
    }

    @Override
    public Team accept(MatchVisitor visitor, ITeam team) {
        return visitor.visit(this, (HandballTeam) team);
    }

    @Override
    public String getTeamType() {
        return "handball";
    }
}
