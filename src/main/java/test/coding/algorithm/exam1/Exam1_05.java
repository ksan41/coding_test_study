package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        return;
    }

    public static String solution(String str) {

        char[] arr = str.toCharArray();
        int start = 0;
        int last = str.length() - 1;
        while (start < last) {
            if (!checkAscii(arr[start])) {
                start++;
            } else if (!checkAscii(arr[last])) {
                last--;
            } else {
                char temp = arr[start];
                arr[start] = arr[last];
                arr[last] = temp;
                start++;
                last--;
            }
        }
        return String.valueOf(arr);
    }

    public static boolean checkAscii(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;    
        }
        return false;
    }
}
