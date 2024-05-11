package test.coding.algorithm.exam8;

import java.util.Arrays;
import java.util.Scanner;

public class Exam8_10 {
    
    static int answer = 0;
    static int[][] graph;
    static int[] dirX = {0,0, -1,1};
    static int[] dirY = {-1,1,0,0};

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        graph = new int[9][9];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 2);
        }


        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        graph[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        if (x == 7 && y == 7) {
            answer += 1;
        } else {
            for (int i = 0; i < dirX.length; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                if (graph[nextX][nextY] == 0) {
                    graph[nextX][nextY] = 1;
                    dfs(nextX, nextY);
                    graph[nextX][nextY] = 0;
                }
            }
        }
    }
}
