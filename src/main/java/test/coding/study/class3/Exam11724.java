package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam11724 {
    
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    static boolean chk;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                solution(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void solution(int v) {
        if (v == n + 1) {
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    solution(i);
                }
            }
        }
    }
}
