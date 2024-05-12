package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam25516 {

    static int n, k, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, apples;

    // 거리가 k이하인 트리 노드에서 사과 수확하기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        apples = new int[n];
        ch = new int[n];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apples[i] = Integer.parseInt(st.nextToken());
        }

        ch[0] = 1;
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int v, int depth) {
        if (depth > k) return;
        else {
            if (apples[v] == 1) answer += 1;
            for (int i : graph.get(v)) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i, depth + 1);
                }
            }
        }
    }
}
