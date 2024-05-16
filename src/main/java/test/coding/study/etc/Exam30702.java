package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam30702 {
    
    static int n, m, paint = 0;
    static char[][] mapA, mapB;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 국기 색칠하기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mapA = new char[n][m];
        mapB = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                mapA[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                mapB[i][j] = str.charAt(j);
            }
        }
        
        paint = n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapA[i][j] == mapB[i][j]) {
                    if (mapA[i][j] != 0 && mapB[i][j] != 0) {
                        mapA[i][j] = 0;
                        mapB[i][j] = 0;
                        paint -= 1;
                    }
                } else {
                    if (mapA[i][j] != 0) {
                        dfs(i, j, mapA[i][j], mapB[i][j]);
                    }
                }
            }
        }

        if (paint == 0 ) System.out.println("YES");
        else System.out.println("NO");
    }


    static void dfs(int y, int x, char a, char b) {
        if (paint == 0) return;
        if (mapA[y][x] == a && mapB[y][x] == b) {
            mapB[y][x] = 0;
            paint -= 1;
        }
        mapA[y][x] = 0;
        for (int i = 0; i < dirX.length; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                mapA[ny][nx] == a
            ) {
                dfs(ny, nx, a, b);
            }
        }
    }
}
