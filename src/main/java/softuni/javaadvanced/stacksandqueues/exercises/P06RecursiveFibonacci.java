package softuni.javaadvanced.stacksandqueues.exercises;

import java.util.Scanner;

public class P06RecursiveFibonacci {
    static long[] cache;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fibPosition = Integer.parseInt(sc.nextLine());

        cache = new long[fibPosition + 2];

        long result = fib(fibPosition + 1);

        System.out.println(result);

    }

    public static long fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        return cache[n] = fib(n - 2) + fib(n - 1);
    }
}
