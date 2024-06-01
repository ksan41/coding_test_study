package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam1389 {
    
    static int n, m = 0;
    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] answer, ch;

    // 케빈 베이컨의 6단계 법칙
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n + 1];
        answer[0] = Integer.MAX_VALUE;
        ch = new int[n + 1];
        graph = new ArrayList<>();
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

        for (int i = 1; i <= n; i++) {
            ch = new int[n + 1];
            bfs(i);
        }
        min = Arrays.stream(answer).min().getAsInt();

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ch = new int[n + 1];
            if (answer[i] == min) result.add(i);
        }

        System.out.println(result.stream().mapToInt(v -> v).min().getAsInt());
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        ch[v] = 1;
        
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                for (int nc : graph.get(current)) {
                    if(ch[nc] == 0) {
                        queue.offer(nc);
                        answer[nc] += level + 1;
                        ch[nc] = 1;
                    }
                }
            }
            level++;
        }
    }

}
