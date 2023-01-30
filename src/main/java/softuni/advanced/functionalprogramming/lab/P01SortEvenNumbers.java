package softuni.advanced.functionalprogramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        List<String> stringList = numbersList.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", stringList));

        numbersList.sort(Integer::compare);

        System.out.println(String.join(", ",
                        numbersList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())));
    }
}
