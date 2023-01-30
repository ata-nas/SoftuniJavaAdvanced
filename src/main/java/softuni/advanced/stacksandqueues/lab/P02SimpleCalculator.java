package softuni.advanced.stacksandqueues.lab;

import java.util.*;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, sc.nextLine().split(" "));

        int result = 0;

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber - secondNumber;
            }

            stack.push("" + result);
        }
        System.out.println(result);
    }
}
