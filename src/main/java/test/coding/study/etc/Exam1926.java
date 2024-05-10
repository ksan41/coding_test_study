package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1926 {
    
    static int n,m, cnt, max, sum=0;
    static int[][] map;
    static int[] dirX = {0,0,-1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    // 그림
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while(st.hasMoreTokens()) {
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    cnt += 1;
                    sum = 1;
                    map[i][j] = 0;
                    dfs(i, j);
                    max = Math.max(max,sum);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n &&
                map[nextY][nextX] == 1
            ) {
                sum += 1;
                map[nextY][nextX] = 0;
                dfs(nextY, nextX);
            }
        }
    }
}
