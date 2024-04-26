package test.coding.algorithm.exam8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Exam8_05 {
    static int n, m = 0;
    static int answer = Integer.MAX_VALUE;
    static Integer[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int sum, int amount) {
        if (sum > m) return;
        if (amount >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, amount);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(sum + arr[i], amount + 1);
            }
        }
    }
}
