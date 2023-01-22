package softuni.javaadvanced.streamsfilesanddirectories.lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class P07ListFiles {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("resources/Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams");

        File file = inputPath.toAbsolutePath().toFile();

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : Objects.requireNonNull(files)) {
                    if (!f.isDirectory() && !f.getName().equals(".DS_Store")) {
                        System.out.printf("%s: [%d]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
