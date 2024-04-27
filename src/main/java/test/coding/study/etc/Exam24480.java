package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam24480 {
    
    static int n, m, r = 0;
    static int cnt = 2;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        ch = new int[n + 1];
        answer = new int[n + 1];

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
        answer[r] = 1;
        solution(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void solution(int v) {
        if (v == n + 1) {
            return;
        } else {
            Collections.sort(graph.get(v), Collections.reverseOrder());
            for (int i : graph.get(v)) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    answer[i] = cnt++;
                    solution(i);
                }
            }
        }
    }
}
