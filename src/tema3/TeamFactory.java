package tema3;

/**
 * The factory for the class Team.
 */
public class TeamFactory {
    private static TeamFactory factory;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static TeamFactory getInstance() {
        if (factory == null) {
            factory = new TeamFactory();
        }
        return factory;
    }

    /**
     * Create team.
     *
     * @param type            the type
     * @param name            the name
     * @param gender          the gender
     * @param numberOfPlayers the number of players
     * @return the team
     */
    public Team createTeam(String type, String name, String gender, int numberOfPlayers) {
        Team team = null;

        if (type.equals("football")) {
            team = new FootballTeam(name, gender, numberOfPlayers);
        }

        if (type.equals("basketball")) {
            team = new BasketballTeam(name, gender, numberOfPlayers);
        }

        if (type.equals("handball")) {
            team = new HandballTeam(name, gender, numberOfPlayers);
        }

        return team;
    }
}
