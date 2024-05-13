package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam26170 {
    
    static int answer = Integer.MAX_VALUE;
    static int r, c = 0;
    static int[][] map;
    static int[][] ch;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 사과 빨리 먹기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        ch = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ch[r][c] = 1;
        dfs(r, c, 0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void dfs(int y, int x, int apples, int cnt) {
        if (map[y][x] == 1) apples += 1;
        map[y][x] = -1;
        if (apples >= 3) {
            answer = Math.min(answer, cnt);
        } else {
            for (int i = 0; i < dirX.length; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 &&
                map[nextY][nextX] != -1 && ch[nextY][nextX] == 0
                ) {
                    int temp = map[nextY][nextX];
                    ch[nextY][nextX] = 1;
                    dfs(nextY, nextX, apples, cnt + 1);
                    ch[nextY][nextX] = 0;
                    map[nextY][nextX] = temp;
                }
            }
        }
    }
}
