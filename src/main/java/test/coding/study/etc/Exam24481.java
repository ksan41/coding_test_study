package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam24481 {
    
    static int n, m, r = 0;
    static int ch[], answer[];
    static ArrayList<ArrayList<Integer>> graph;

    // 알고리즘 수업 - 깊이 우선 탐색 3
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        ch = new int[n + 1];
        answer = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        
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
        dfs(r, 0);

        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int v, int depth) {
        answer[v] = depth;
        Collections.sort(graph.get(v));
        for (int i : graph.get(v)) {
            if (ch[i] == 0) {
                ch[i] = 1;
                dfs(i, depth + 1);
            }
        }
    }
}
