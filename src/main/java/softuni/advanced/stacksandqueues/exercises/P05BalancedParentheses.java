package softuni.advanced.stacksandqueues.exercises;

import java.util.*;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Character> stack = new ArrayDeque<>();

        char[] par = sc.nextLine().toCharArray();

        boolean balanced = true;
        for (char currentChar : par) {
            switch (currentChar) {
                case '(':
                case '[':
                case '{':
                    stack.push(currentChar);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.size() > 0) {
                        char evalChar = stack.pop();
                        if (!(evalChar == '(') && currentChar == ')'
                                || !(evalChar == '[') && currentChar == ']'
                                || !(evalChar == '{') && currentChar == '}') {
                            balanced = false;
                            break;
                        }
                    } else {
                        balanced = false;
                    }
            }
            if (!balanced) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
