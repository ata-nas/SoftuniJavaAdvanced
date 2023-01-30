package softuni.advanced.setsandmaps.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputCount = Integer.parseInt(sc.nextLine());

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < inputCount; i++) {
            List<String> currentInput = Arrays.asList(sc.nextLine().split("\\s+"));
            set.addAll(currentInput);
        }

        System.out.printf("%s", set.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
