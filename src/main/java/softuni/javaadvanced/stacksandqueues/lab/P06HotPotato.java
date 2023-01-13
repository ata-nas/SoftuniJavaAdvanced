package softuni.javaadvanced.stacksandqueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] people = sc.nextLine().split(" ");
        Queue<String> q = new ArrayDeque<>();
        Collections.addAll(q, people);

        int steps = Integer.parseInt(sc.nextLine());

        while (!q.isEmpty()) {
            exhaustSteps(q, steps);

            if (q.size() == 1) {
                System.out.printf("Last is %s%n", q.poll());
                break;
            }

            System.out.printf("Removed %s%n", q.poll());
        }

    }

    public static void exhaustSteps(Queue<String> q, int steps) {
        for (int i = 1; i < steps; i++) {
            q.offer(q.poll());
        }
    }
}
