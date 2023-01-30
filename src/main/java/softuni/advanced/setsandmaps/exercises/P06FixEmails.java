package softuni.advanced.setsandmaps.exercises;

import java.util.*;

public class P06FixEmails {
    final private static String COMMAND_STOP = "stop";
    final private static Set<String> BANNED_TLD = Set.of("us", "uk", "com");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        while (true) {
            String name = sc.nextLine();

            if (name.equals(COMMAND_STOP)) {
                break;
            }

            String email = sc.nextLine();
            String[] emailArr = email.toLowerCase().split("\\.");
            String tld = emailArr[emailArr.length - 1];

            if (!BANNED_TLD.contains(tld)) {
                map.put(name, email);
            }
        }

        map.forEach((k, v) -> {
            System.out.printf("%s -> %s%n", k, v);
        });
    }
}
