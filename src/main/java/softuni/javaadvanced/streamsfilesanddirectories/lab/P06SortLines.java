package softuni.javaadvanced.streamsfilesanddirectories.lab;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("resources/Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        Path outputPath = Paths.get("resources/Java-Advanced-Files-and-Streams-Lab-Resources/out/out.txt");

        FileInputStream inputStream = new FileInputStream(inputPath.toAbsolutePath().toString());
        FileOutputStream outputStream = new FileOutputStream(outputPath.toAbsolutePath().toString());

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

        Scanner sc = new Scanner(br);

        List<String> sortedText = new ArrayList<>();

        while (sc.hasNext()) {
            sortedText.add(sc.nextLine());
        }

        Collections.sort(sortedText);

        sortedText.forEach(e -> {
            try {
                bw.write(e);
                bw.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bw.flush();
        bw.close();
        br.close();

        outputStream.flush();
        outputStream.close();
        inputStream.close();


    }
}
