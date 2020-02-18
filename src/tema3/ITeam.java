package tema3;

/**
 * The interface Team.
 */
public interface ITeam extends Comparable<ITeam>{
    /**
     * Accept team.
     *
     * @param visitor the visitor
     * @param team    the team
     * @return the team
     */
    public Team accept(MatchVisitor visitor, ITeam team);

    /**
     * Update the team's field containing the place in the leaderboard.
     *
     * @param place the place
     */
    void update(int place);

    /**
     * Gets gender.
     *
     * @return the gender
     */
    String getGender();

    /**
     * Gets team type.
     *
     * @return the team type
     */
    String getTeamType();

    /**
     * Gets team name.
     *
     * @return the team name
     */
    String getTeamName();

}
