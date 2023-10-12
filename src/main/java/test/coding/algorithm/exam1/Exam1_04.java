package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.next();
        }

        solution(arr);
        return;
    }

    public static void solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            char[] charArr = str.toCharArray();
            for (int i = charArr.length - 1; i >= 0; i--) {
                sb.append(charArr[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
