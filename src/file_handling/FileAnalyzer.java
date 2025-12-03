package file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FileAnalyzer {
    public static void main(String[] args) {
        String longest = "";
        String shortest = null;
        HashSet<String> uniqueWords = new HashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/file_handling/sample.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String words[] = line.split("\\s+");

                for (String w : words) {
                    String word = w.replaceAll("[^a-zA-Z]", ""); // remove punctuation
                    if (word.isEmpty()) continue;

                    uniqueWords.add(word.toLowerCase());

                    if (word.length() > longest.length())
                        longest = word;

                    if (shortest == null || word.length() < shortest.length())
                        shortest = word;
                }
            }

            br.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Longest word: " + longest);
        System.out.println("Shortest word: " + shortest);
        System.out.println("Unique words: " + uniqueWords.size());
    }
}

