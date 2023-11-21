package test.coding.algorithm.exam3;

import java.util.Scanner;

public class Exam3_06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, k));
        return;
    }

    public static int solution(int[] arr, int k) {
        int answer = Integer.MIN_VALUE; // max
        int start = 0, end = 0;

        int sum = 0;
        int cnt = 0;
        while (end < arr.length) {
            answer = Math.max(answer, sum);
            if (arr[end] == 1) {
                sum++;
                end++;
            } else {
                if (cnt == k) {
                    if (arr[start] == 0) {
                        cnt--;
                    }
                    start++;
                    sum--;
                } else {
                    cnt++;
                    sum++;
                    end++;
                }
            }
        }

        return answer;
    }
}
