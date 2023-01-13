package softuni.javaadvanced.stacksandqueues.exercises;

import java.util.*;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        int commands = Integer.parseInt(sc.nextLine());
        while (commands-- > 0) {
            String[] token = sc.nextLine().split("\\s+");
            String command = token[0];
            switch (command) {
                case "1":
                    int targetNum = Integer.parseInt(token[1]);
                    stack.push(targetNum);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
