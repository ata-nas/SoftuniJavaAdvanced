package softuni.javaadvanced.streamsfilesanddirectories.lab;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {
    public static void main(String[] args) {
        Path inputPath = Paths.get("resources/Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams");

        File file = inputPath.toAbsolutePath().toFile();

        Deque<File> stack = new ArrayDeque<>();

        stack.push(file);
        int folderCount = 1;
        while (!stack.isEmpty()) {
            File currFile = stack.pop();
            File[] nested = currFile.listFiles();
            assert nested != null;
            for (File f : nested) {
                if (f.isDirectory()) {
                    stack.push(f);
                    folderCount++;
                }
            }
            System.out.println(currFile.getName());
        }

        System.out.println(folderCount + " folders");
    }
}
