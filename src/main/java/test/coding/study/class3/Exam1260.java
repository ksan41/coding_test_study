package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Exam1260 {
    
    static int n, m, v, level = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        ch = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a  = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ch[v] = 1;
        System.out.print(v + " ");
        DFS(v);
        System.out.println();
        ch = new int[n + 1];
        BFS(v);
    }

    public static void DFS(int v) {
        if (v == n + 1) {
            return;
        } else {
            Collections.sort(graph.get(v));
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    System.out.print(nv + " ");
                    DFS(nv);
                }
            }
        }
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                System.out.print(current + " ");
                
                for (int nv : graph.get(current)) {
                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        queue.offer(nv);
                    }
                }
            }
            level++;
        }

    }
}
