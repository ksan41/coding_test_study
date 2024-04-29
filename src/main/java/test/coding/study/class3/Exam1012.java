package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1012 {

    static int t, m, n, k = 0;
    static int[][] graph, ch;
    static int[] xarr = { 0, 0, -1, 1 };
    static int[] yarr = { -1, 1, 0, 0 };
    static int[] answer;

    // 1012 유기농 배추
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        answer = new int[t];

        for (int cnt = 0; cnt < t; cnt++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
    
            graph = new int[n + 2][m + 2];
            ch = new int[n + 2][m + 2];
    
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[b + 1][a + 1] = 1;
            }
    
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (ch[i][j] == 0 && graph[i][j] == 1) {
                        answer[cnt] += 1;
                        dfs(j, i);
                    }
                }
            }
        }

        for (int a : answer) {
            System.out.println(a);
        }

    }

    public static void dfs(int x, int y) {
        ch[y][x] = 1;
        for (int i = 0; i < xarr.length; i++) {
            int newY = y + yarr[i];
            int newX = x + xarr[i];
            if (graph[newY][newX] == 1 && ch[newY][newX] == 0) {
                dfs(newX, newY);
            }
        }
    }
}
