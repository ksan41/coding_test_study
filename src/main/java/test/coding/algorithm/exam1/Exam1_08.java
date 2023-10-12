package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
        return;
    }

    public static String solution(String str) {
        str = str.toUpperCase();

        int start = 0;
        int last = str.length() - 1;
        while (start < last) {
            if (!checkAlphabet(str.charAt(start))) {
                start++;
            } else if (!checkAlphabet(str.charAt(last))) {
                last--;
            } else {
                if (str.charAt(start) == str.charAt(last)) {
                    start++;
                    last--;
                } else {
                    return "NO";
                }
            }

        }

        return "YES";
    }

    public static boolean checkAlphabet(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;    
        }
        return false;
    }
}
