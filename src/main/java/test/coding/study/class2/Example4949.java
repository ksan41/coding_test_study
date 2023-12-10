package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Example4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }

            bf.append(solution(str) + "\n");
        }

        System.out.println(bf.toString());
    }

    public static String solution(String str) {
        String answer = "yes";
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return "no";
                }
                char pop = stack.pop();

                if (c == ')') {
                    if (pop != '(') {
                        return "no";
                    }
                } else {
                    if (pop != '[') {
                        return "no";
                    }
                }
            }
        }

        if (!stack.isEmpty()) answer = "no";
        return answer;
    }
}
