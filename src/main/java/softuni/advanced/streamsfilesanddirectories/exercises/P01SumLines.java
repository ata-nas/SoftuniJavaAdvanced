package softuni.advanced.streamsfilesanddirectories.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P01SumLines {
    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(
                Paths.get("resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int sum = 0;
                for (char c : line.toCharArray())  {
                    sum += c;
                }

                System.out.println(sum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
