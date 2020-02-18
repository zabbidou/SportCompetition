package tema3;

/**
 * The class Football team.
 */
public class FootballTeam extends Team {
    /**
     * Instantiates a new Football team.
     *
     * @param teamName        the team name
     * @param gender          the gender
     * @param numberOfPlayers the number of players
     */
    public FootballTeam(String teamName, String gender, int numberOfPlayers) {
        super(teamName, gender, numberOfPlayers);
    }

    @Override
    public Team accept(MatchVisitor visitor, ITeam team) {
        return visitor.visit(this, (FootballTeam) team);
    }

    @Override
    public String getTeamType() {
        return "football";
    }
}
