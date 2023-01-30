package softuni.advanced.setsandmaps.exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int iterations = Integer.parseInt(sc.nextLine());

        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < iterations; i++) {
            set.add(sc.nextLine());
        }

        set.forEach(System.out::println);
    }
}
