package softuni.advanced.stacksandqueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> q = new ArrayDeque<>();

        while (true) {
            String userCommand = sc.nextLine();

            if (userCommand.equals("print")) {
                break;
            }

            if (userCommand.equals("cancel")) {
                if (q.isEmpty()) {
                    System.out.println("Printer is on standby");
                    continue;
                }

                String currentOperation = q.poll();
                System.out.printf("Canceled %s%n", currentOperation);
                continue;
            }

            q.offer(userCommand);
        }

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
