package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10026 {
    
    static int n, common, juckrock = 0;
    static char[][] map;
    static int[][] ch;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 적록색약
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);                
            }
        }

        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j] == 0) {
                    common += 1;
                    dfs(i, j, map[i][j]);
                }
            }
        }

        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j] == 0) {
                    juckrock += 1;
                    dfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(common);
        System.out.println(juckrock);
    }

    static void dfs(int y, int x, char cur) {
        ch[y][x] = 1;
        if (map[y][x] == 'G') map[y][x] = 'R';
        for (int i = 0; i < dirX.length; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n
                && ch[ny][nx] == 0 && cur == map[ny][nx]
            ) {
                dfs(ny, nx, cur);
            }
        }
    }
}
