package test.coding.algorithm.exam5;

import java.util.Scanner;
import java.util.Stack;

public class Exam5_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        in.close();
        return;
    }

    // public static String solution(String str) {
    //     String answer = "";
    //     Stack<Character> stack = new Stack<>();

    //     for (char c : str.toCharArray()) {
    //         if (c == '(') {
    //             stack.push(c);
    //         }
    //         if (stack.isEmpty())
    //             answer += c;
    //         if (c == ')') {
    //             stack.pop();
    //         }
    //     }
    //     return answer;
    // }

    public static String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return new StringBuilder(answer).reverse().toString();
    }
}
