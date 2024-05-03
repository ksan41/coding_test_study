package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam26169 {

    static int r, c, answer = 0;
    static int[][] map, ch;
    static int[] dirX = { 0, 0, -1, 1 };
    static int[] dirY = { -1, 1, 0, 0 };

    // 세 번 이내에 사과를 먹자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        ch = new int[5][5];
        
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ch[r][c] = 1;
        if (map[r][c] == 1) dfs(r, c, 0, 1);
        else dfs(r, c, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int y, int x, int cnt, int apple) {
        if (cnt > 3) return;
        if (map[y][x] == 1) apple+=1;
        if (apple >= 2) answer = 1;
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX < 5 && nextX >= 0 && nextY >= 0 && nextY < 5 && 
                ch[nextY][nextX] == 0 && map[nextY][nextX] != -1) {
                ch[nextY][nextX] = 1;
                dfs(nextY, nextX, cnt + 1, apple);
                ch[nextY][nextX] = 0;
            }
        }
    }
}
