package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam4963 {
    
    static int w, h, answer = 0;
    static int[][] graph;
    static int[] dirX = {0,0,-1,1,-1,1,-1,1}; // 상하좌우상좌상우하좌하우
    static int[] dirY = {-1,1,0,0,-1,-1,1,1};


    // 섬의 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            graph = new int[h + 2][w + 2];

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = 1;
                while(st.hasMoreTokens()) {
                    graph[i][idx++] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;

            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph[0].length; j++) {
                    if (graph[i][j] == 1) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int y, int x) {
        graph[y][x] = 0;

        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            
            if (graph[nextY][nextX] == 1) {
                dfs(nextY, nextX);
            }
        }
    }
}
