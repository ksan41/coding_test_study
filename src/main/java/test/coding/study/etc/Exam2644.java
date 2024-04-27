package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam2644 {
    
    static int n, a, b, m = 0;
    static int level = -1;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        ch[a] = 1;
        // dfs(a, 0);
        bfs(a);

        // System.out.println(level);
        System.out.println(level);
    }

    public static void dfs(int v, int num) {
        if (v == b) {level = num; return;}
        else {
            Collections.sort(graph.get(v));
            for (int i : graph.get(v)) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i, num + 1);
                }
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        int num = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                
                for (int nc : graph.get(current)) {
                    if (ch[nc] == 0) {
                        queue.offer(nc);
                        ch[nc] = 1;
                        if (nc == b) {
                            num++;
                            level = num;
                            return;
                        }
                    }
                }
            }
            num++;
        }
    }
}
