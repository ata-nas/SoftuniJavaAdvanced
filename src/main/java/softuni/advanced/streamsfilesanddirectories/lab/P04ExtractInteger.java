package softuni.advanced.streamsfilesanddirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class P04ExtractInteger {
    public static void main(String[] args) throws IOException {
        String inputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/out/out.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        Scanner sc = new Scanner(inputStream);

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int nextInt = sc.nextInt();
                for (int i = 0; i < String.valueOf(nextInt).length(); i++) {
                    outputStream.write(String.valueOf(nextInt).charAt(i));
                }
                outputStream.write(10);

            }
            sc.next();
        }

        sc.close();
        inputStream.close();
        outputStream.close();
    }
}
