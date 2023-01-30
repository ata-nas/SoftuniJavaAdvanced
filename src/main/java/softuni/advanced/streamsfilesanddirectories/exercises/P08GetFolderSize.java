package softuni.advanced.streamsfilesanddirectories.exercises;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08GetFolderSize {
    public static void main(String[] args) {
        File file = new File("resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/Exercises Resources");

        Deque<File> q = new ArrayDeque<>();
        q.offer(file);

        int sum = 0;

        while (!q.isEmpty()) {
            File current = q.poll();
            File[] files = current.listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    q.offer(f);
                } else {
                    sum += f.length();
                }
            }
        }

        System.out.printf("Folder size: %d%n", sum);
    }
}
