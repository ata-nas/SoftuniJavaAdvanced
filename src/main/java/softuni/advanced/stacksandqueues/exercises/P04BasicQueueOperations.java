package softuni.advanced.stacksandqueues.exercises;

import java.util.*;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tokens = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int toOffer = tokens[0];
        int toPoll = tokens[1];
        int toCheck = tokens[2];

        Queue<Integer> q = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(toOffer)
                .forEach(q::offer);

        while (toPoll-- > 0) {
            if (!q.isEmpty()) {
                q.poll();
            }
        }

        if (q.isEmpty()) {
            System.out.println(0);
        } else if (q.contains(toCheck)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(q));
        }
    }
}
