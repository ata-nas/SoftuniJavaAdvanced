package softuni.javaadvanced.setsandmaps.lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(sc.nextLine());

        Map<String, double[]> map = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = sc.nextLine();
            double[] grades = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            map.put(name, grades);
        }

        for (var entry : map.entrySet()) {
            double averageGrade = Arrays.stream(entry.getValue()).average().getAsDouble();
            System.out.printf("%s is graduated with %s%n", entry.getKey(), averageGrade);
        }
    }
}
