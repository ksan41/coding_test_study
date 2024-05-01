package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam16173 {
    
    static int n, current = 0;
    static int[][] graph;
    static String answer = "Hing";

    // 점프왕 쩰리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 1;
            while (st.hasMoreTokens()) {
                graph[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        current = graph[1][1];
        dfs(1, 1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        if (graph[y][x] == -1) {
            answer = "HaruHaru";
        } else {
            graph[y][x] = 0;
            int nextY = y + current > n ? 0 : y + current;
            int nextX = x + current > n ? 0 : x + current;
            
            if (graph[nextY][x] != 0) {
                current = graph[nextY][x];
                dfs(x, nextY);
            }
            if (graph[y][nextX] != 0) {
                current = graph[y][nextX];
                dfs(nextX, y);
            }
        }
    }
}
