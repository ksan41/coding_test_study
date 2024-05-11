package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam2583 {
    
    static int m, n, k, cnt, temp = 0;
    static ArrayList<Integer> answer;
    static int[][] map;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 영역 구하기
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        answer = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[k][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                    temp = 0;
                    dfs(i, j);
                    answer.add(temp);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(cnt);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static void dfs(int y, int x) {
        temp+=1;
        map[y][x] = 1;
        for (int i = 0; i < dirX.length; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                && map[nextY][nextX] == 0
            ) {
                dfs(nextY, nextX);
            }
        }
    }
}
