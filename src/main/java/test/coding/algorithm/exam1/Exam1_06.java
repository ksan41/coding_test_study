package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        return;
    }

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
