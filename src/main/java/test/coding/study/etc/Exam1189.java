package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1189 {
    
    static int r, c, k, answer = 0;
    static char[][] map;
    static int[][] ch;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 컴백홈
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        ch = new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        ch[r-1][0] = 1;
        dfs(r - 1, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int y, int x, int dist) {
        if (x == c - 1 && y == 0) {
            if (dist == k) answer += 1;
        } else {
            for (int i = 0; i < dirX.length; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                if (nextX >= 0 && nextX < c && nextY >= 0 && nextY < r
                    && ch[nextY][nextX] == 0 && map[nextY][nextX] != 'T'
                ) {
                    ch[nextY][nextX] = 1;
                    dfs(nextY, nextX, dist + 1);
                    ch[nextY][nextX] = 0;
                }
            }
        }
    }
}
