package softuni.javaadvanced.stacksandqueueslab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        boolean flagEnd = false;
        while (!flagEnd) {
            String userCommand = sc.nextLine();

            switch (userCommand) {
                case "Home":
                    flagEnd = true;
                    break;
                case "back":
                    backAction(backStack, forwardStack);
                    break;
                case "forward":
                    forwardAction(backStack, forwardStack);
                    break;
                default:
                    defaultAction(backStack, forwardStack, userCommand);
            }
        }
    }

    public static void backAction(ArrayDeque<String> backStack, ArrayDeque<String> forwardStack) {
        if (backStack.isEmpty() || backStack.size() == 1) {
            System.out.println("no previous URLs");
            return;
        }

        forwardStack.push(backStack.pop());
        String currentURL = backStack.peek();
        System.out.printf("%s%n", currentURL);
    }

    public static void forwardAction(ArrayDeque<String> backStack, ArrayDeque<String> forwardStack) {
        if (forwardStack.isEmpty()) {
            System.out.println("no next URLs");
            return;
        }

        String currentURL = forwardStack.pop();
        backStack.push(currentURL);
        System.out.printf("%s%n", currentURL);
    }

    public static void defaultAction(ArrayDeque<String> backStack, ArrayDeque<String> forwardStack, String action) {
        backStack.push(action);
        forwardStack.clear();
        System.out.printf("%s%n", action);
    }
}
