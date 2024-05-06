package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam11123 {
    
    static int h, w = 0;
    static char[][] map;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 양 한마리... 양 두마리...
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            for (int j = 0; j < h; j++) {
                String newLine = br.readLine();   
                int idx = 0;
                for (char c : newLine.toCharArray()) {
                    map[j][idx++] = c;
                }
            }
            int answer = 0;
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (map[j][k] == '#') {
                        answer++;
                        dfs(j, k);
                    }
                }
            }
            bw.write(answer + "");
            bw.newLine();
        }

        bw.flush();
    }

    public static void dfs(int y, int x) {
        map[y][x] = '.';
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 0 && nextX < w && nextY >= 0 && nextY < h
                && map[nextY][nextX] == '#'
            ) {
                dfs(nextY, nextX);
            }
        }
    }
}
