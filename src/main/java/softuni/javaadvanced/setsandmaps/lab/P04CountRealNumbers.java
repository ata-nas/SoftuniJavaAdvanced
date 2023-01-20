package softuni.javaadvanced.setsandmaps.lab;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] inputArr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> map = new LinkedHashMap<>();


        for (double item : inputArr) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                map.replace(item, map.get(item) + 1);
            }
        }

        for (Map.Entry<Double, Integer> kvEntry : map.entrySet()) {
            System.out.printf("%.01f -> %d%n", kvEntry.getKey(), kvEntry.getValue());
        }

    }
}
