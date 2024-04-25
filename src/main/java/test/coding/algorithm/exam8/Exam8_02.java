package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_02 {

    static int c, n, answer = 0;
    static int[] arr, ch;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        c = in.nextInt();
        n = in.nextInt();
        arr = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    // public static void DFS(int v) {
    // if (v == n) {
    // int sum = 0;
    // for (int i = 0; i < n; i++) {
    // if (ch[i] == 1) {
    // sum+= arr[i];
    // }
    // }
    // if (sum > c) return;
    // answer = Math.max(sum, answer);
    // } else {
    // ch[v] = 1;
    // DFS(v + 1);
    // ch[v] = 0;
    // DFS(v + 1);
    // }
    // }

    public static void DFS(int v, int sum) {
        if (sum > c)
            return;
        if (v == n) {
            answer = Math.max(sum, answer);
        } else {
            ch[v] = 1;
            DFS(v + 1, sum + arr[v]);
            ch[v] = 0;
            DFS(v + 1, sum);
        }
    }
}
