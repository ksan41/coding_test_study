package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1388 {
    
    static int n, m, answer = 0;
    static char[][] graph;
    static char current;

    // 바닥 장식
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= str.length(); j++) {
                graph[i][j] = str.charAt(j-1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] != 0) {
                    current = graph[i][j];
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }


    public static void dfs(int y, int x) {
        graph[y][x] = 0;
        if (current == '-') {
            if (graph[y][x + 1] == current) {dfs(y, x + 1);}
        } else {
            if (graph[y + 1][x] == current) { dfs(y + 1, x); }
        }
    }
}
