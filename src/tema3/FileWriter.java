package tema3;

import java.io.File;
import java.io.IOException;

/**
 * Wrapper class for easier writing.
 */
public class FileWriter {
    private static FileWriter instance;
    private java.io.FileWriter out;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static FileWriter getInstance() {
        if (instance == null) {
            instance = new FileWriter();
        }
        return instance;
    }

    /**
     * Open output.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public void openOutput(String file) throws IOException {
        out = new java.io.FileWriter(new File(file));
    }

    /**
     * Write.
     *
     * @param data the data
     * @throws IOException the io exception
     */
    public void write(String data) throws IOException {
        System.out.println(data);
        out.write(data);
        out.write(System.lineSeparator());
    }

    /**
     * Close.
     *
     * @throws IOException the io exception
     */
    public void close() throws IOException {
        out.close();
    }
}
