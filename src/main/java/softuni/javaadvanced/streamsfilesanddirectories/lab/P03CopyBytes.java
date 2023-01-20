package softuni.javaadvanced.streamsfilesanddirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class P03CopyBytes {
    final private static Set<Integer> SKIP_SYMBOLS = Set.of(10, 32);

    public static void main(String[] args) throws IOException {
        String inputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/out/out.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);


        int bytes = inputStream.read();
        while (bytes != -1) {
            boolean skipNextSymbol = SKIP_SYMBOLS.contains(bytes);
            if (skipNextSymbol) {
                outputStream.write(bytes);
            } else {
                for (int i = 0; i < String.valueOf(bytes).length(); i++) {
                    outputStream.write(String.valueOf(bytes).charAt(i));
                }
            }
            bytes = inputStream.read();
        }


        inputStream.close();
        outputStream.close();
    }
}
