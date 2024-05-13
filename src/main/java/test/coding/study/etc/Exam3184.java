package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam3184 {
    
    static int r, c, sheep, wolf = 0;
    static char[][] map;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 양
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            int idx = 0;
            for (char c : str.toCharArray()) {
                map[i][idx++] = c;
            }
        }

        int w = 0;
        int s = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#') {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);
                    if (sheep > wolf) s += sheep;
                    else w += wolf;
                }
            }
        }

        System.out.println(s + " " + w);
    }

    static void dfs(int y, int x) {
        if (map[y][x] == 'o') sheep++;
        if (map[y][x] == 'v') wolf++;
        map[y][x] = '#';
        for (int i = 0; i < dirX.length; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            if (nx >= 0 && nx < c && ny >= 0 && ny < r &&
                map[ny][nx] !='#'
            ) {
                dfs(ny, nx);
            }
        }
    }
}
