package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_08 {

    static int n, f = 0;
    static int[] b;
    static int[] p;
    static int[] ch;
    static int[][] dy;
    static boolean flg = false;

    // 수열 추측하기
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();

        b = new int[n + 1];
        p = new int[n + 1];
        dy = new int[n + 1][n + 1];

        // n-1C 0 ~ n-1Cn-1 구해놓기
        for (int i = 1; i <= n; i++) {
            b[i] = dfs(n - 1, i - 1);
        }

        ch = new int[n + 1];
        solution(1, 0);
    }

    static int dfs(int n1, int r1) {
        if (dy[n1][r1] > 0)
            return dy[n1][r1];
        if (r1 == 0 || n1 == r1) {
            return 1;
        } else {
            return dy[n1][r1] = dfs(n1 - 1, r1 - 1) + dfs(n1 - 1, r1);
        }
    }

    static void solution(int v, int sum) {
        if (flg) return;
        if (v == n + 1) {
            if (sum == f) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(p[i] + " ");
                }
                flg = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[v] = i;
                    solution(v + 1, sum + (b[v] * p[v]));
                    ch[i] = 0;
                }
            }
        }
    }
}
