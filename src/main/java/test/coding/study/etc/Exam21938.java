package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam21938 {
    
    static int n, m,t, answer = 0;
    static ArrayList<ArrayList<ArrayList<Integer>>> graph;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 영상처리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph.get(i).add(new ArrayList<>());
                for (int k = 0; k < 3; k++) {
                    graph.get(i).get(j).add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = graph.get(i).get(j).get(0);
                int g = graph.get(i).get(j).get(1);
                int b  = graph.get(i).get(j).get(2);
                if ((r+g+b)/3 >= t) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int y, int x) {
        graph.get(y).get(x).set(0, 0);
        graph.get(y).get(x).set(1, 0);
        graph.get(y).get(x).set(2, 0);
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n 
            ) {
                int nr = graph.get(nextY).get(nextX).get(0);
                int ng = graph.get(nextY).get(nextX).get(1);
                int nb = graph.get(nextY).get(nextX).get(2);
                if ((nr + ng + nb)/3 >= t) {
                    dfs(nextY, nextX);
                }
            }
        }
    }
}
