package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Example1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution(n, arr);
    }

    public static void solution(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] numbers = new int[n];
        int idx = 0;
        for (int i = 1; i <= numbers.length; i++) {
            numbers[i-1] = i;
        }

        StringBuffer sb = new StringBuffer();

        for (int c : arr) {
            if (stack.peek() < c) {
                while (idx < c) {
                    stack.push(numbers[idx++]);
                    sb.append("+\n");
                }
            }
            if (stack.peek() == c) {
                stack.pop();
                sb.append("-\n");
            }
            if (stack.peek() > c) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}