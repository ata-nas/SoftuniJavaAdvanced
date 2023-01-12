package softuni.javaadvanced.stacksandqueueslab;

import java.util.*;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        String userInput = sc.nextLine();
        String[] userInputArr = userInput.split("");

        for (int i = 0; i < userInputArr.length; i++) {
            if (userInputArr[i].contains("(")) {
                stack.push(i);
                continue;
            }

            if (userInputArr[i].contains(")")) {
                int startIndex = stack.pop();

                System.out.println(userInput.substring(startIndex, i + 1));
            }

        }
    }
}
