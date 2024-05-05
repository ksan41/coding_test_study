package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam31575 {
    
    static int n, m = 0;
    static int[][] map;
    static String answer = "No";
    static int[] dirX = {0, 1};
    static int[] dirY = {1, 0};

    // 도시와 비트코인
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[m + 2][n + 2];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 1;
            while(st.hasMoreTokens()) {
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);

        System.out.println(answer);
    }

    public static void dfs(int y, int x) {
        if (y == m && x == n) answer = "Yes";
        else {
            for (int i = 0; i < dirX.length; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (map[ny][nx] == 1) {
                    map[ny][nx] = 0;
                    dfs(ny, nx);
                }
            }
        }
    }
}
