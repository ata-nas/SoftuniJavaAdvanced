package softuni.javaadvanced.setsandmaps.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.nextLine().toCharArray();

        Map<Character, Integer> map = new TreeMap<>();

        for (char item : input) {
            map.putIfAbsent(item, 0);
            int updateCount = map.get(item) + 1;
            map.replace(item, updateCount);
        }

        map.forEach((k, v) -> {
            System.out.printf("%c: %d time/s%n", k, v);
        });
    }
}
