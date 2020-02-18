package tema3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The class Competition.
 */
public class Competition implements Subject {
    /**
     * The Type.
     */
    String type;
    /**
     * The Gender.
     */
    String gender;
    /**
     * The Registered teams.
     */
    ArrayList<ITeam> registeredTeams;
    /**
     * The Leaderboard.
     */
    ArrayList<ITeam> leaderboard;

    /**
     * Instantiates a new Competition.
     *
     * @param type   the type
     * @param gender the gender
     */
    public Competition(String type, String gender) {
        this.type = type;
        this.gender = gender;
        registeredTeams = new ArrayList<>();
        leaderboard = new ArrayList<>();
    }

    /**
     * Runs the competition.
     * Computes the matches between every team.
     *
     * @throws IOException the io exception
     */
    public void run() throws IOException {
        int winnerPosition;
        Team winningTeam;
        MatchVisitor visitor = new MatchImplementation();

        for (int i = 0; i < leaderboard.size() - 1; i++) {
            for (int j = i + 1; j < leaderboard.size(); j++) {
                winningTeam = leaderboard.get(i).accept(visitor, leaderboard.get(j));

                if (winningTeam == null) {
                    ((Team)leaderboard.get(i)).addDrawPoints();
                    ((Team)leaderboard.get(j)).addDrawPoints();
                    continue;
                } else if (leaderboard.get(i).equals(winningTeam)) {
                    winnerPosition = i;
                } else {
                    winnerPosition = j;
                }

                ((Team)leaderboard.get(winnerPosition)).addWinPoints();
            }
        }

        notifyObservers();
        aftermath();
    }

    /**
     * Add team to competition.
     *
     * @param name the name
     */
    public void addTeamToCompetition(String name) {
        Team team = Database.getInstance().find(name);
        registerObserver(team);
    }

    @Override
    public void registerObserver(ITeam observer) throws IllegalArgumentException {
        if (Database.getInstance().contains((Team) observer)) {
            if (observer.getTeamType().equals(this.type) && observer.getGender().equals(this.gender)) {
                registeredTeams.add(observer);
                leaderboard.add(observer);
            }
        }
    }

    @Override
    public void notifyObservers() {
        Collections.sort(leaderboard);
        for (int i = 0; i < leaderboard.size(); i++) {
            leaderboard.get(i).update(i);
        }
    }

    /**
     * Computes the final touches.
     * Prints the results in the format requested.
     *
     * @throws IOException the io exception
     */
    public void aftermath() throws IOException {
        for (int i = 0; i < 3; i++) {
            FileWriter.getInstance().write(leaderboard.get(i).getTeamName());
        }
        for (ITeam registeredTeam : registeredTeams) {
            Team team = (Team) registeredTeam;
            FileWriter.getInstance().write("Echipa " + team.getTeamName() + " a ocupat locul " + (team.getPlace() + 1));
        }
    }
}
