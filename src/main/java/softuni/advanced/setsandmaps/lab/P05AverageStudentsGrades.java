package softuni.advanced.setsandmaps.lab;

import java.text.DecimalFormat;
import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(sc.nextLine());

        String[] inputArr = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            inputArr[i] = sc.nextLine();
        }

        Map<String, List<Double>> map = new TreeMap<>();

        for (String input : inputArr) {
            String[] curInput = input.split("\\s+");

            String studentName = curInput[0];
            double studentGrade = Double.parseDouble(curInput[1]);

            if (map.containsKey(studentName)) {
                map.get(studentName).add(studentGrade);
            } else {
                map.put(studentName, new ArrayList<>(Arrays.asList(studentGrade)));
            }
        }

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            String name = entry.getKey();
            double averageGrade = generateAverageGrade(entry.getValue());
            StringBuilder grades = new StringBuilder();

            DecimalFormat df = new DecimalFormat("#.00");
            for (double g : entry.getValue()) {
                grades.append(String.valueOf(df.format(g))).append(" ");
            }
            System.out.printf("%s -> %s(avg: %.02f)%n", name, grades, averageGrade);
        }
    }

    private static double generateAverageGrade(List<Double> grades) {
        double sum = 0;

        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}
