package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Exam21937 {
    
    static int n, m, x, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    // 작업
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());

        // System.out.println(bfs(x));
        ch[x] = 1;
        dfs(x);
        System.out.println(answer);
    }

    static void dfs(int v) {
        for (int i : graph.get(v)) {
            if (ch[i] == 0) {
                ch[i] = 1;
                answer++;
                dfs(i);
            }
        }
    }

    static int bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        ch[v] = 1;

        int level = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                if (graph.get(current).isEmpty()) return level;
                else {
                    for (int nc : graph.get(current)) {
                        if (ch[nc] == 0) {
                            ch[nc] = 1;
                            queue.offer(nc);
                        } else {
                            level++;
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }
}
