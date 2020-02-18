package tema3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Wrapper class for easier reading from file.
 */
public class FileReader {
    private static FileReader instance;
    private Scanner in;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static FileReader getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }

        return instance;
    }

    /**
     * Open input.
     *
     * @param file the file
     * @throws FileNotFoundException the file not found exception
     */
    public void openInput(String file) throws FileNotFoundException {
        in = new Scanner(new File(file));
    }

    /**
     * Read line string.
     *
     * @return the string
     */
    public String readLine() {
        return in.nextLine();
    }

    /**
     * Has next.
     *
     * @return the boolean
     */
    public boolean hasNext() {
        return in.hasNext();
    }
}
