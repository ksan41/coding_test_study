package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        System.out.println(solution(n, str));
        return;
    }

    public static String solution(int n, String str) {
        String answer = "";

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int binaryNum = 0;
            for (int j = idx; j < idx + 7; j++) {
                if (str.charAt(j) == '#') {
                    binaryNum = 10 * binaryNum + 1;
                } else {
                    binaryNum = 10 * binaryNum;
                }
            }
            binaryNum = Integer.parseInt(String.valueOf(binaryNum), 2);
            byte b = (byte)(binaryNum & 0xff);
            answer += String.valueOf((char)b);
            idx += 7;
        }

        return answer;
    }
}
