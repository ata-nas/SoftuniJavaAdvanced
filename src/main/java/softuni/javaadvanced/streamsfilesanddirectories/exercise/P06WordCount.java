package softuni.javaadvanced.streamsfilesanddirectories.exercise;

import java.io.*;
import java.util.*;

public class P06WordCount {
    public static void main(String[] args) {
        String inputPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/words.txt";
        String search = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/text.txt";
        String outPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/out.txt";
        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();

        try (BufferedReader wordsReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
             BufferedReader textReader = new BufferedReader(new InputStreamReader(new FileInputStream(search)));
             PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            String line;

            while ((line = wordsReader.readLine()) != null) {
                Arrays.stream(line.trim().split("\\s+")).forEach(word -> words.putIfAbsent(word, 0));
            }


            while ((line = textReader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String word : tokens) {
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    }
                }
            }

            words.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(entry -> out.println(String.format("%s - %d", entry.getKey(), entry.getValue())));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
