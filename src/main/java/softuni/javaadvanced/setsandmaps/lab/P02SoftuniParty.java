package softuni.javaadvanced.setsandmaps.lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftuniParty {
    final private static String COMMAND_PARTY = "PARTY";
    final private static String COMMAND_END = "END";
    final private static Set<String> guestSet = new TreeSet<>();
    final private static Set<String> arrivedSet = new HashSet<>();
    final private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String command = sc.nextLine();

            if (command.equals(COMMAND_PARTY)) {
                break;
            }

            guestSet.add(command);
        }

        while (true) {
            String command = sc.nextLine();

            if (command.equals(COMMAND_END)) {
                break;
            }

            arrivedSet.add(command);
        }

        guestSet.removeIf(arrivedSet::contains);

        System.out.println(guestSet.size());
        guestSet.forEach(System.out::println);
    }
}
