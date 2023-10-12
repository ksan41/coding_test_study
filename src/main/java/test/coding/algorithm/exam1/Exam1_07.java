package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        return;
    }

    public static String solution(String str) {
        str = str.toUpperCase();

        int start = 0;
        int last = str.length() - 1;
        while (start < last) {
            if (str.charAt(start) == str.charAt(last)) {
                start++;
                last--;
            } else {
                return "NO";
            }
        }

        return "YES";
    }
}
