package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam11403 {

    static int n = 0;
    static int[][] result;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    // 경로 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 1) {
                    graph.get(i).add(idx);
                }
                idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ch = new int[n];
                result[j][i] = bfs(j, i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.append(result[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    static int bfs(int v, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                for (int nc : graph.get(current)) {
                    if (ch[nc] == 0) {
                        if (nc == target) return 1;
                        ch[nc] = 1;
                        queue.offer(nc);
                    }
                }
            }
        }
        return 0;
    }
}
