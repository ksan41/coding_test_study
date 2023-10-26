package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution(n));
        return;
    }

    public static int solution(int n) {
        int answer = 0;

        int[] checkArr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (checkArr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j += i) {
                    checkArr[j] = 1;
                }
            }
        }

        return answer;
    }
}
