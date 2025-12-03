package file_handling;

import java.io.FileReader;
import java.io.IOException;

public class ReadUsingFileReader {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("src/file_handling/sample.txt");
            int ch;

            while ((ch = fr.read()) != -1) {   // reads one character at a time
                System.out.print((char) ch);
            }

            fr.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

