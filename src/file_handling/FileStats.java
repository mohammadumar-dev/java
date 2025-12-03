package file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStats {
    public static void main(String[] args) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/file_handling/sample.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;                               // Count lines
                charCount += line.length();                // Count characters

                String words[] = line.split("\\s+");       // Split by spaces
                wordCount += words.length;                 // Count words
            }

            br.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);
    }
}

