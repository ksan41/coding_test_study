package test.coding.algorithm.exam5;

import java.util.Scanner;
import java.util.Stack;

public class Exam5_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        in.close();
        return;
    }

    public static int solution(String str) {
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) { // 숫자만 스택에 쌓기
                stack.push(Character.getNumericValue(c));
            } else {
                int calcValue = 0;
                int a = stack.pop();
                int b = stack.pop();
                if (c == '+') {
                    calcValue = b + a;
                } else if (c == '-') {
                    calcValue = b - a;
                } else if (c == '*') {
                    calcValue = b * a;
                } else {
                    calcValue = b / a;
                }
                stack.push(calcValue);
            }
        }

        return stack.pop();
    }
}
