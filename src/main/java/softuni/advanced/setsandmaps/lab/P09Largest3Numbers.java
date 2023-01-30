package softuni.advanced.setsandmaps.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((x, y) -> y.compareTo(x))
                .limit(3)
                .collect(Collectors.toList());

        sorted.forEach(e -> System.out.print(e + " "));
    }
}
