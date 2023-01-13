package softuni.javaadvanced.stacksandqueues.stacksandqueuesexercises;

import java.util.*;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] token = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int toPush = token[0];
        int toPop = token[1];
        int toCheck = token[2];

        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(toPush)
                .forEach(stack::push);

        while (toPop-- > 0) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        if (stack.contains(toCheck)) {
            System.out.println(true);
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
