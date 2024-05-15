package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam16174 {

    static int n = 0;
    static boolean flg = false;
    static int[][] map;
    static int[][] ch;
    static String answer = "Hing";
    static int[] dirX = {0, 1}; // 하, 우
    static int[] dirY = {1, 0};

    // 점프왕 쩰리(Large)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        ch = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 1;
            while(st.hasMoreTokens()) {
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        ch[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }

    static void dfs(int y, int x) {
        if (flg) return;
        if(map[y][x] == -1) {
            answer = "HaruHaru";
            flg = true;
        } else {
            for (int i = 0; i < dirX.length; i++) {
                int nx = x + (dirX[i] * map[y][x]);
                int ny = y + (dirY[i] * map[y][x]);
                if (nx >= 0 && nx <= n && ny >=0 && ny <= n
                && ch[ny][nx] == 0
                ) {
                    ch[ny][nx] = 1;
                    dfs(ny, nx);
                }
            }
        }
    }
}
