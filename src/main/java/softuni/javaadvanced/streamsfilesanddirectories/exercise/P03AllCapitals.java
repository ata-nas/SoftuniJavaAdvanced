package softuni.javaadvanced.streamsfilesanddirectories.exercise;

import java.io.*;
import java.nio.file.Paths;

public class P03AllCapitals {
    public static void main(String[] args) {
        String inPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/input.txt";
        String outPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/out.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.get(inPath).toFile()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.get(outPath).toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder result = new StringBuilder();

                char[] curLine = line.toCharArray();
                for (char c : curLine) {
                    if (Character.isAlphabetic(c)) {
                        result.append(Character.toUpperCase(c));
                    } else {
                        result.append(c);
                    }
                }

                bw.write(String.valueOf(result));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
