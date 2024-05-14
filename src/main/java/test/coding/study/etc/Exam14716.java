package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam14716 {
    
    static int m, n, answer = 0;
    static int[][] map;
    static int[] dirX = {0,0,-1,1,-1,-1,1,1};
    static int[] dirY = {-1,1,0,0,-1,1,-1,1};

    // 현수막
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while(st.hasMoreTokens()) {
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    answer++;
                    dfs(i, j);
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
            if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                map[ny][nx] == 1
            ) {
                dfs(ny, nx);
            }
        }
    }
}
