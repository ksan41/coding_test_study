package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_13 {
    
    static int n, answer = 0;
    static int[][] map;
    static int[] dirX = {0,0,-1,1,-1,-1,1,1};
    static int[] dirY = {-1,1,0,0,-1,1,-1,1};

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        n = in.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    answer += 1;
                    dfs(i,j);
                }
            }
        }

        System.out.println(answer);
      }

      static void dfs(int y, int x) {
        map[y][x] = 0;
        for (int i = 0; i < dirX.length; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
      }
}
