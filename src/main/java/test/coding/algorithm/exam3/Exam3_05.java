package test.coding.algorithm.exam3;

import java.util.Scanner;

public class Exam3_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution(n));
        return;
    }

    // public static int solution(int n) {
    // int answer = 0;

    // int pivot = 1;
    // while (pivot < n) {
    // int sum = 0;
    // for (int i = pivot; i < n; i++) {
    // if (sum == n) {
    // answer++;
    // break;
    // } else if (sum < n) {
    // sum += i;
    // } else {
    // break;
    // }
    // }
    // pivot++;
    // }
    // return answer;
    // }

    public static int solution(int n) {
        int answer = 0;

        int pivot = 0, start = 0;
        int sum = 0;
        while (pivot < n / 2 + 1) {
            if (sum < n) {
                sum += pivot++;
            } else if (sum > n) {
                sum -= start++;
            } else {
                answer++;
                sum -= start++;
            }
        }
        if (sum == n)
            answer++;
        return answer;
    }

}
