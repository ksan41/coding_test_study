package test.coding.algorithm.exam1;

import java.util.Arrays;
import java.util.Scanner;

public class Exam1_11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        return;
    }

    public static String solution(String str) {
        String answer = "";

        char[] arr = new char[str.length() + 1];
        System.arraycopy(str.toCharArray(), 0, arr, 0, str.length());
        char current = str.charAt(0);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (current == arr[i]) {
                cnt++;
            } else {
                if (cnt == 1) {
                    answer += String.valueOf(current);
                } else {
                    answer += String.valueOf(current) + cnt;
                }
                cnt = 1;
                current = arr[i];
            }
        }

        return answer;
    }
}
