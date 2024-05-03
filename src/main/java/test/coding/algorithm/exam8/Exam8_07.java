package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_07 {
    static int[][] dy = new int[35][35];

    // 이항계수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(DFS(n, r));
    }

    public static int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }
}
