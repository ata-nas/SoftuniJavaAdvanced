package softuni.javaadvanced.setsandmaps.lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputCount = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < inputCount; i++) {
            String[] inputArr = sc.nextLine().split("\\s+");

            String continent = inputArr[0];
            String country = inputArr[1];
            String city = inputArr[2];

            if (map.containsKey(continent)) {
                if (map.get(continent).containsKey(country)){
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                }
            } else {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            }
        }

        for (var entry : map.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (var continentEntry : entry.getValue().entrySet()) {
                System.out.printf("  %s -> %s%n",
                        continentEntry.getKey(),
                        String.join(", ", continentEntry.getValue()));
            }
        }
    }
}
