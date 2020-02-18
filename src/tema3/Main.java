package tema3;

import java.io.IOException;

/**
 * The main class.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        FileReader in = FileReader.getInstance();
        FileWriter out = FileWriter.getInstance();
        in.openInput(args[1]);
        out.openOutput(args[3]);

        while (in.hasNext()) {
            if (args[0].equals("inscriere")) {
                out.write(parseTeam().toString());
            } else {
                parseTeam();
            }
        }

        if (args[0].equals("competitie")) {
            in.openInput(args[2]);
            parseCompetition();
        }

        out.close();
    }

    private static void parseCompetition() throws IOException {
        String[] tokens = getTokens();
        Competition competition = new Competition(tokens[0], tokens[1]);

        while (FileReader.getInstance().hasNext()) {
            competition.addTeamToCompetition(FileReader.getInstance().readLine());
        }

        competition.run();
    }

    private static Team parseTeam() {
        String[] tokens = getTokens();
        Team team = TeamFactory.getInstance().createTeam(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
        Database.getInstance().addTeamToDatabase(team);
        addPlayersFromInput(Integer.parseInt(tokens[3]), team);
        return team;
    }

    private static void addPlayersFromInput(int nrOfPlayers, Team team) {
        String[] tokens;
        for (int i = 0; i < nrOfPlayers; i++) {
            tokens = getTokens();
            team.addPlayer(tokens[0], Integer.parseInt(tokens[1]));
        }
    }

    private static String[] getTokens() {
        FileReader in = FileReader.getInstance();
        String buffer = in.readLine();
        buffer = buffer.replace(", ", ",");
        return buffer.split(",");
    }
}
