package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exam2210 {
    
    static int[][] map = new int[5][5];
    static int[] temp = new int[6];
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};
    static Set<String> set = new HashSet<>();

    // 숫자판 점프
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            while(st.hasMoreTokens()) {
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(j,i, 0);
            }
        }

        System.out.println(set.size());
    }

    public static void dfs(int y, int x, int idx) {
        if (idx > 5) return;
        temp[idx] = map[y][x];
        if (idx == 5) {
            String number = "";
            for (int i : temp) {
                number += String.valueOf(i);
            }
            if (!set.contains(number)) set.add(number);
        } else {
            for (int i = 0; i < dirX.length; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                if (nextX < 5 && nextX >= 0 && nextY < 5 && nextY >= 0) {
                    idx++;
                    dfs(nextY, nextX, idx);
                    idx--;
                }
            }
        }
        
    }
}
