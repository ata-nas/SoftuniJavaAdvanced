package softuni.javaadvanced.setsandmaps.exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] setSizes = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();

        for (int i = 0; i < setSizes[0]; i++) {
            firstSet.add(Integer.parseInt(sc.nextLine()));
        }

        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < setSizes[1]; i++) {
            secondSet.add(Integer.parseInt(sc.nextLine()));
        }

        firstSet.retainAll(secondSet);

        System.out.printf("%s", firstSet.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

}
