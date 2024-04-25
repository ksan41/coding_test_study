package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam2606 {

    static int[] ch;
    static int com, answer = 0;

    static int[][] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());

        ch = new int[com + 1];

        graph = new int[com+1][com+1];

        for (int i = 0; i < lines; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        ch[1] = 1;
        solution(1);
        System.out.println(answer);
    }

    public static void solution(int v) {
        if (v == com + 1) {
            return;
        } else {
            for (int i = 1; i <= com; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    answer++;
                    solution(i);
                }
            }
        }
    }
}
