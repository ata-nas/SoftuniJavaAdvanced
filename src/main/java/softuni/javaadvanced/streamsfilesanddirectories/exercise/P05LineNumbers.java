package softuni.javaadvanced.streamsfilesanddirectories.exercise;

import java.io.*;
import java.nio.file.Paths;

public class P05LineNumbers {
    public static void main(String[] args) {
        String inPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/inputLineNumbers.txt";
        String outPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/out.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(Paths.get(inPath).toFile()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.get(outPath).toFile()))) {
            int lineCount = 1;
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(lineCount + "." + " " + line);
                bw.newLine();
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
