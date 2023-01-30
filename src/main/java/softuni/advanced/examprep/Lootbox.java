package softuni.advanced.examprep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> firstBox = new ArrayDeque<>();
        String[] fillerFirst = sc.nextLine().split(" ");
        for (String s : fillerFirst) {
            firstBox.offer(Integer.parseInt(s));
        }

        Deque<Integer> secondBox = new ArrayDeque<>();
        String[] fillerSecond = sc.nextLine().split(" ");
        for (String s : fillerSecond) {
            secondBox.push(Integer.parseInt(s));
        }

        int sum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstNum = firstBox.peek();
            int secondNum = secondBox.pop();

            if ((firstNum + secondNum) % 2 == 0) {
                sum += firstNum + secondNum;
                firstBox.poll();
            } else {
                firstBox.offer(secondNum);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");

        } else {
            System.out.println("Second lootbox is empty");
        }

        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sum);
        }
    }
}
