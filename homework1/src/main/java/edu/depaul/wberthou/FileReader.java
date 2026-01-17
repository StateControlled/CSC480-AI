package edu.depaul.wberthou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {


    public FileReader() {

    }

    public String readFile(final String filename) throws IOException {
        try (InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(filename)) {
            if (ioStream == null) {
                throw new IOException("File not found");
            }
            return printFileContent(ioStream);
        }
    }

    public String printFileContent(InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            is.close();
            return builder.toString();
        }
    }

}
