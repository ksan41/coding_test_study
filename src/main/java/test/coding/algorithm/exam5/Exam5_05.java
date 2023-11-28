package test.coding.algorithm.exam5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Exam5_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        in.close();
        return;
    }

    // public static int solution(String str) {
    // // 레이저 위치
    // Map<Integer, Integer> lazer = new HashMap<>();
    // Map<Integer, Integer> sticks = new HashMap<>();
    // Stack<Character> stack = new Stack<>();
    // Stack<Integer> idxStack = new Stack<>();

    // for (int i = 0; i < str.length(); i++) {
    // if (str.charAt(i) == ')') {
    // if (str.charAt(i - 1) == '(') {
    // lazer.put(i - 1, i);
    // stack.pop();
    // idxStack.pop();
    // } else {
    // sticks.put(idxStack.pop(), i);
    // stack.pop();
    // }
    // } else {
    // stack.push(str.charAt(i));
    // idxStack.push(i);
    // }
    // }

    // int answer = sticks.size();
    // for (int i : sticks.keySet()) {
    // for (int j : lazer.keySet()) {
    // if (j > i && lazer.get(j) < sticks.get(i)) {
    // answer++;
    // }
    // }
    // }

    // return answer;
    // }

    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        int idx = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (str.charAt(idx - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
            idx++;
        }

        return answer;
    }
}
