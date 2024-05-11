package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam24483 {
    
    static int n, m, r = 0;
    static int cnt = 1;
    static ArrayList<ArrayList<Integer>> graph;
    static long[] order, level, ch;

    // 알고리즘 수업 - 깊이 우선 탐색 5
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        order = new long[n + 1];
        level = new long[n + 1];
        ch = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ch[r] = 1;
        order[r] = cnt++;
        dfs(r, 0);

        long sum = 0;
        for (int i = 1; i < order.length; i++) {
            sum += order[i] * level[i];
        }
        System.out.println(sum);
    }

    public static void dfs(int v, long depth) {
        level[v] = depth;

        Collections.sort(graph.get(v));
        for (int i : graph.get(v)) {
            if (ch[i] == 0) {
                ch[i] = 1;
                order[i] = cnt++;
                dfs(i, depth + 1);
            }
        }
    }
}
