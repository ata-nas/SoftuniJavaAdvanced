package softuni.javaadvanced.streamsfilesanddirectories.exercise;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P04CountCharacterTypes {
    final private static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    final private static Set<Character> PUNCTUATION = Set.of('!', ',', '.', '?');
    public static void main(String[] args) {
        String inPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/input.txt";
        String outPath = "resources/Java-Advanced-Files-and-Streams-Exercises-Resources_2/out.txt";

        Map<String, Integer> map = new HashMap<>();
        map.put("vowels", 0);
        map.put("others", 0);
        map.put("punctuation", 0);

        try (FileInputStream in = new FileInputStream(Paths.get(inPath).toFile());
             BufferedWriter br = new BufferedWriter(new FileWriter(Paths.get(outPath).toFile()))) {
            int bytes;
            while ((bytes = in.read()) > -1) {
                if (VOWELS.contains((char)bytes)) {
                    map.replace("vowels", map.get("vowels") + 1);
                } else if (PUNCTUATION.contains((char)bytes)) {
                    map.replace("punctuation", map.get("punctuation") + 1);
                } else {
                    if ((char)bytes == ' ' || bytes == 10 || bytes == 13) {
                        continue;
                    }
                    map.replace("others", map.get("others") + 1);
                }
            }

            br.write(String.format("Vowels: %d", map.get("vowels")));
            br.newLine();
            br.write(String.format("Other symbols: %d", map.get("others")));
            br.newLine();
            br.write(String.format("Punctuation: %d", map.get("punctuation")));
            br.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
