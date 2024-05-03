package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_09 {
    
    static int n, m, num = 0;
    static int[] ch;
    static int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n + 1];
        answer = new int[99][m];

        for (int i = 1; i <= n; i++) {
            ch[i] = 1;
            dfs(i, 1);
            ch[i] = 0;
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i][0] == 0) break;
            for (int v : answer[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int v, int cnt) {
        if (cnt > m) return;
        if (cnt == m) {
            int idx = 0;
            for (int i=1; i <= n; i++) {
                if (ch[i] == 1) {
                    answer[num][idx++] = i;
                }
            }
            num++;
        } else {
                for (int i = v; i <= n; i++) {
                    if (ch[i] == 0) {
                        ch[i] = 1;
                        dfs(i, cnt + 1);
                        ch[i] = 0;
                    }
                }
        }
    }
}
