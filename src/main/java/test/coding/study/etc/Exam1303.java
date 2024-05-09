package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1303 {
    
    static int n, m, w, b, temp = 0;
    static char[][] map;
    static int[][] ch;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 전쟁 - 전투
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        ch = new int[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'W' && ch[i][j] == 0) {
                    temp = 0;
                    dfs(i, j, 'W');
                    w += temp * temp;
                }
            }
        }

        ch = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'B' && ch[i][j] == 0) {
                    temp = 0;
                    dfs(i, j, 'B');
                    b += temp * temp;
                }
            }
        }

        System.out.println(w + " " + b);
    }

    static void dfs(int y, int x, char team) {
        ch[y][x] = 1;
        temp += 1;
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m &&
                ch[nextY][nextX] == 0 && map[nextY][nextX] == team
            ) {
                dfs(nextY, nextX, team);
            }
        }
    }
}
