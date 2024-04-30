package test.coding.study.programmers.level2;

import java.util.Stack;

public class Exam2 {
    
    // 올바른 괄호
    public static void main(String[] args) {
        String s = "(()(";

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.add(c);
            else {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.add(c);
            }
        }

        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}
