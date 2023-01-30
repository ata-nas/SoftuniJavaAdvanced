package softuni.advanced.streamsfilesanddirectories.exercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class P02SumBytes {
    public static void main(String[] args) {
        int sum = 0;

        try (FileInputStream in = new FileInputStream(
                Paths.get("resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/Exercises Resources/input.txt").toFile())) {

            int b;
            while ((b = in.read()) > -1) {
                if (b != 10 && b != 13) {
                    sum += b;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}

