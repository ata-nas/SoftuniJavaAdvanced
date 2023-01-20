package softuni.javaadvanced.streamsfilesanddirectories.lab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "resources/Java-Advanced-Files-and-Streams-Lab-Resources/out/out.txt";

        FileReader fReader = new FileReader(inputPath);
        FileWriter fWriter = new FileWriter(outputPath);

        BufferedReader bufferedReader = new BufferedReader(fReader);
        PrintWriter printWriter = new PrintWriter(fWriter);

        int curRow = 1;
        String line = bufferedReader.readLine();
        while (line != null) {
            if (curRow % 3 == 0) {
                printWriter.write(line);
                printWriter.write(10);
            }
            line = bufferedReader.readLine();
            curRow++;
        }

        fReader.close();
        fWriter.close();
    }
}
