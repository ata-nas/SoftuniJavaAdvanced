package softuni.javaadvanced.stacksandqueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (true) {
            String userCommand = sc.nextLine();

            if (userCommand.equals("Home")) {
                break;
            }

            if (userCommand.equals("back")) {
                if (stack.isEmpty() || stack.size() == 1) {
                    System.out.println("no previous URLs");
                    continue;
                }

                stack.pop();
                String currentAddress = stack.peek();
                System.out.println(currentAddress);
                continue;
            }

            stack.push(userCommand);
            System.out.println(userCommand);
        }
    }
}
