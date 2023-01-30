package softuni.advanced.streamsfilesanddirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class P02WriteToFile {
    final private static Set<Character> NOT_ALLOWED_SYMBOLS = Set.of(',', '.', '!', '?');
    public static void main(String[] args) throws IOException {
        String inputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/out/out.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int bytes = inputStream.read();
        while (bytes != -1) {
            char symbol = (char) bytes;
            boolean notAllowedSymbol = NOT_ALLOWED_SYMBOLS.contains(symbol);

            if (!notAllowedSymbol) {
                outputStream.write(symbol);
            }
            bytes = inputStream.read();

        }

        inputStream.close();
        outputStream.close();
    }
}
