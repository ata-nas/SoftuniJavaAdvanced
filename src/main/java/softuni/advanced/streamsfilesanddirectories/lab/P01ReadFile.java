package softuni.advanced.streamsfilesanddirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {
        String inputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/out/out.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int bytes = inputStream.read();
        while (bytes != -1) {
            outputStream.write(Integer.toBinaryString(bytes).getBytes());
            outputStream.write(32);
            bytes = inputStream.read();
        }

        inputStream.close();
    }
}
