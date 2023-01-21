package softuni.javaadvanced.setsandmaps.exercise;

import java.util.*;

public class P07HandsOfCards {
    final private static String COMMAND_JOKER = "JOKER";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> map = new LinkedHashMap<>();

        while (true) {
            String input = sc.nextLine();

            if (input.equals(COMMAND_JOKER)) {
                break;
            }

            String[] inputArr = input.split(": ");
            String name = inputArr[0];
            String[] cards = inputArr[1].split(", ");

            if (map.containsKey(name)) {
                map.get(name).addAll(Arrays.asList(cards));
            } else {
                map.put(name, new LinkedHashSet<>());
                map.get(name).addAll(Arrays.asList(cards));
            }
        }

        for (var entry : map.entrySet()) {
            int sum = 0;
            for (var card : entry.getValue()) {
                char[] cardArr = card.toCharArray();
                char power = cardArr.length == 2 ? cardArr[0] : 'T';
                char type = cardArr.length == 2 ? cardArr[1] : cardArr[2];

                int numericPower;
                int numericType = 0;

                switch (power) {
                    case 'T':
                        numericPower = 10;
                        break;
                    case 'J':
                        numericPower = 11;
                        break;
                    case 'Q':
                        numericPower = 12;
                        break;
                    case 'K':
                        numericPower = 13;
                        break;
                    case 'A':
                        numericPower = 14;
                        break;
                    default:
                        numericPower = Character.getNumericValue(power);
                }

                switch (type) {
                    case 'S':
                        numericType = 4;
                        break;
                    case 'H':
                        numericType = 3;
                        break;
                    case 'D':
                        numericType = 2;
                        break;
                    case 'C':
                        numericType = 1;
                        break;
                }

                sum += (numericPower * numericType);
            }

            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }
    }
}
