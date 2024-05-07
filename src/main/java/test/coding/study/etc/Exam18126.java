package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam18126 {

    static int n = 0;
    static long answer = 0;
    static ArrayList<ArrayList<Integer[]>> graph;
    static int[] ch;

    // 너구리 구구
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[2];
            arr[0] = b;
            arr[1] = c;
            graph.get(a).add(arr);
            Integer[] arr2 = new Integer[2];
            arr2[0] = a;
            arr2[1] = c;
            graph.get(b).add(arr2);
        }

        dfs(1, 0);
        System.out.println(answer);
    }

    public static void dfs(int v, long sum) {
        ch[v] = 1;
        answer = Math.max(sum, answer);
        for (Integer[] i : graph.get(v)) {
            if (ch[i[0]] == 0) {
                ch[i[0]] = 1;
                dfs(i[0], sum + i[1]);
            }
        }
    }
}
