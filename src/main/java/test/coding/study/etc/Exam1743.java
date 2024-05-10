package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam1743 {
    
    static int n, m, k, cnt, answer = 0;
    static int[] dirX = {0,0,-1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static char[][] map;

    // 음식물 피하기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], '.');
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = '#';
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';
                    cnt = 1;
                    dfs(i, j);
                    answer = Math.max(answer, cnt);
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 1 && nextX <= m && nextY >= 1 && nextY <= n && 
            map[nextY][nextX] == '#') {
                cnt += 1;
                map[nextY][nextX] = '.';
                dfs(nextY, nextX);
            }
        }
    }
}
