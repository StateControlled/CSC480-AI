package edu.depaul.wberthou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The methods in this class cannot be <code>static</code> because the method {@link #getClass()} cannot be referenced
 * from a static enclosing method.
 */
public class FileReader {

    public FileReader() {

    }

    /**
     * Read a file from the <code>resources</code> directory.
     *
     * @param filename      the name of the file to open
     * @return              File contents as a <code>String</code>
     * @throws IOException  if an I/O error occurs, if the file cannot be found
     */
    public String readFile(final String filename) throws IOException {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                throw new IOException("File not found");
            }
            return fileContentToString(inputStream);
        }
    }

    /**
     * @param inputStream   an <code>InputStream</code>
     * @return              InputStream contents as a <code>String</code>
     * @throws IOException  if an I/O error occurs
     */
    public String fileContentToString(InputStream inputStream) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(inputStream); BufferedReader br = new BufferedReader(isr)) {
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line.strip());
            }
            inputStream.close();
            return builder.toString();
        }
    }

}
