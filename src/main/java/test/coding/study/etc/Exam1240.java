package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam1240 {
    
    static int n, m, answer = 0;
    static int[][] tree;
    static int[] ch;

    // 노드사이의 거리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[n + 1][n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            tree[a][b] = dis;
            tree[b][a] = dis;
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ch = new int[n + 1];
            answer = 0;
            ch[a] = 1;
            dfs(a, b, 0);
            bw.write(answer + "");
            bw.newLine();
        }

        bw.flush();
    }

    static void dfs(int v, int b, int move) {
        if (v == b) {
            answer = move;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0 && tree[v][i] > 0) {
                    ch[i] = 1;
                    dfs(i, b, move + tree[v][i]);
                }
            }
        }
    }
}
