package tema3;

import java.util.ArrayList;

/**
 * The class Database.
 */
public class Database {
    private ArrayList<Team> database;
    private static Database instance;

    private Database() {
        database = new ArrayList<>();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    /**
     * Gets the size.
     *
     * @return the int
     */
    public int size() {
        return database.size();
    }

    /**
     * Gets a team.
     *
     * @param i the position of the team
     * @return the team
     */
    public Team get(int i) {
        return database.get(i);
    }

    /**
     * Add team to database.
     *
     * @param team the team
     */
    public void addTeamToDatabase(Team team) {
        database.add(team);
    }

    /**
     * Find team by name.
     *
     * @param name the name
     * @return the team
     */
    public Team find(String name) {
        for (Team team : database) {
            if (team.teamName.equals(name)) {
                return team;
            }
        }
        return null;
    }

    /**
     * Checks if a team is in the database.
     *
     * @param team the team
     * @return the boolean
     */
    public boolean contains(Team team) {
        return database.contains(team);
    }
}
