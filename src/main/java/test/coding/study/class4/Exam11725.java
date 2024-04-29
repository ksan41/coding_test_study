package test.coding.study.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam11725 {

    static int n = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] answer;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        answer = new int[n + 1];
        ch = new int[n + 1];

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

        ch[1] = 1;
        // dfs(1);
        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int v) {
        for (int i : graph.get(v)) {
            if (ch[i] == 0) {
                ch[i] = 1;
                answer[i] = v;
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                for (int nc : graph.get(current)) {
                    if (ch[nc] == 0) {
                        ch[nc] = 1;
                        queue.offer(nc);
                        answer[nc] = current;
                    }
                }
            }
        }
    }
}
