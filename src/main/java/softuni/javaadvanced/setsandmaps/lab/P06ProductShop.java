package softuni.javaadvanced.setsandmaps.lab;

import java.util.*;

public class P06ProductShop {
    final private static String COMMAND_REVISION = "Revision";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Double>> map = new TreeMap<>();

        while (true) {
            String command = sc.nextLine();

            if (command.equals(COMMAND_REVISION)) {
                break;
            }

            String[] commandArr = command.split(", ");

            String shop = commandArr[0];
            String product = commandArr[1];
            double price = Double.parseDouble(commandArr[2]);

            if (map.containsKey(shop)) {
                if (!map.get(shop).containsKey(product)) {
                    map.get(shop).put(product, price);
                }

            } else {
                map.put(shop, new LinkedHashMap<>());
                map.get(shop).put(product, price);
            }
        }

        for (var entry : map.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (var sEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", sEntry.getKey(), sEntry.getValue());
            }
        }
    }
}
