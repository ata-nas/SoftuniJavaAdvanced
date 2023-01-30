package softuni.advanced.setsandmaps.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    final private static String COMMAND_SEARCH = "search";
    final private static String COMMAND_STOP = "stop";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();

        while (true) {
            String input = sc.nextLine();

            if (input.equals(COMMAND_SEARCH)) {
                break;
            }

            String[] inputArr = input.split("-");
            String name = inputArr[0];
            String phone = inputArr[1];

            if (map.containsKey(name)) {
                map.replace(name, phone);
            } else {
                map.put(name, phone);
            }
        }

        while (true) {
            String query = sc.nextLine();

            if (query.equals(COMMAND_STOP)) {
                break;
            }

            if (map.containsKey(query)) {
                System.out.printf("%s -> %s%n", query, map.get(query));
            } else {
                System.out.printf("Contact %s does not exist.%n", query);
            }
        }
    }
}
