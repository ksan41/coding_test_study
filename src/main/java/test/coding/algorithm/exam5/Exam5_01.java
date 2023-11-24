package test.coding.algorithm.exam5;

import java.util.Scanner;
import java.util.Stack;

public class Exam5_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
        return;
    }

    public static String solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
 