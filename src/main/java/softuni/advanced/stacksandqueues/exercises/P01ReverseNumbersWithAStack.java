package softuni.advanced.stacksandqueues.exercises;

import java.util.*;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String[] numbers = sc.nextLine().split(" ");
        for (String item : numbers) {
            stack.push(item);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}