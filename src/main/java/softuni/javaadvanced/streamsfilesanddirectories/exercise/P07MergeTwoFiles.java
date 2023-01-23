package softuni.javaadvanced.streamsfilesanddirectories.exercise;

import java.io.*;

public class P07MergeTwoFiles {
    final private static String firstInPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/inputOne.txt";
    final private static String secondInPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/inputTwo.txt";
    final private static String outPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/out.txt";

    public static void main(String[] args) {

        try (BufferedReader firstBR = new BufferedReader(new FileReader(firstInPath));
             BufferedReader secondBR = new BufferedReader(new FileReader(secondInPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
            String line;

            while ((line = firstBR.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            firstBR.close();

            while ((line = secondBR.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
