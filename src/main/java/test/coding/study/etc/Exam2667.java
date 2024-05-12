package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam2667 {
    
    static int n, cnt, temp = 0;
    static int[][] map;
    static ArrayList<Integer> answer;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 단지번호붙이기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int idx = 0;
            for (char c : str.toCharArray()) {
                map[i][idx++] = Character.getNumericValue(c);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    temp = 0;
                    dfs(i, j);
                    answer.add(temp);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    static void dfs(int y, int x) {
        temp++;
        map[y][x] = 0;
        for (int i = 0; i < dirX.length; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                map[ny][nx] == 1
            ) {
                dfs(ny, nx);
            }
        }
    }
}
