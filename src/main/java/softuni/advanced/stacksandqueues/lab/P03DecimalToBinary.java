package softuni.advanced.stacksandqueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        int decimal = Integer.parseInt(sc.nextLine());

        if (decimal == 0) {
            System.out.println(0);
            return;
        }

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        String result = "";
        while (stack.size() > 0) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
