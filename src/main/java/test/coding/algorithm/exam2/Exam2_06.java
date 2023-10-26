package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int result = solution(in.next());
            if (result > 0) {
                System.out.printf("%d ", result);
            }
        }

        return;
    }

    public static int solution(String str) {
        int reversed = Integer.valueOf(new StringBuffer(str).reverse().toString());
        if (reversed < 2) {
            return 0;
        }

        for (int i = 2; i <= Math.sqrt(reversed); i++) {
            if (reversed % i == 0) {
                return 0;
            }
        }

        return reversed;

    }
}
