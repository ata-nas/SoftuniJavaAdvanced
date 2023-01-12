package softuni.javaadvanced.stacksandqueues.stacksandqueueslab;

import java.util.*;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] people = sc.nextLine().split(" ");
        PriorityQueue<String> q = new PriorityQueue<>();
        Collections.addAll(q, people);

        int steps = Integer.parseInt(sc.nextLine());
        int cycle = 1;

        while (!q.isEmpty()) {
            exhaustSteps(q, steps);

            if (q.size() == 1) {
                System.out.printf("Last is %s%n", q.poll());
                break;
            }

            if (isPrime(cycle)) {
                System.out.printf("Prime %s%n", q.peek());
            } else {
                System.out.printf("Removed %s%n", q.poll());
            }
            cycle++;
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void exhaustSteps(Queue<String> q, int steps) {
        for (int i = 1; i < steps; i++) {
            q.offer(q.poll());
        }
    }
}
