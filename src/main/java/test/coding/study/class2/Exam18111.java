package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam18111 {
    
    static int n, m, b, landHeight= 0;
    static int time = Integer.MAX_VALUE;
    static int[][] field;

    // 마인크래프트
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        field = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while(st.hasMoreTokens()) {
                field[i][idx] = Integer.parseInt(st.nextToken());
                min = Math.min(min, field[i][idx]);
                max = Math.max(max, field[i][idx]);
                idx++;
            }
        }

        for (int i = min; i <= max; i++) {
            int result = work(i, b);
            if (result == -1) continue;
                if (time >= result) {
                    time = result;
                    landHeight = Math.max(landHeight, i);
                }
        }

        System.out.println(time + " " + landHeight);
    }

    static int work(int current, int blocks) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (current > field[i][j]) {
                    result +=current - field[i][j];
                    blocks -=current - field[i][j];
                } else if (current < field[i][j]) {
                    result += (field[i][j] - current) * 2;
                    blocks += field[i][j] - current;
                }
                if (result > time) return -1;
            }
        }
        if (blocks < 0) {
            return -1;
        }
        return result;
    }
}
