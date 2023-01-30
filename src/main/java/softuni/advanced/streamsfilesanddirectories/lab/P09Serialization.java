package softuni.advanced.streamsfilesanddirectories.lab;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.Arrays;

public class P09Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path outPath = Paths.get("resources/Java-Advanced-Files-and-Streams-Lab-Resources/out.ser");

        ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(outPath.toAbsolutePath().toString()));

        List<String> list = Arrays.asList("Atanas", "Mariela");

        oOut.writeObject(list);

        oOut.flush();
        oOut.close();

        ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(outPath.toAbsolutePath().toString()));

        List<String> deserialize = (List<String>) oIn.readObject();

        oIn.close();
        deserialize.forEach(System.out::println);
    }
}
