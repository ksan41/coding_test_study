package test.coding.algorithm.exam8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Points {
    int x, y;

    Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Exam8_14 {

    static int n, m, len = 0;
    static int answer = Integer.MAX_VALUE;
    static int[] ch;
    static ArrayList<Points> pizzaDis, homes;

    // 피자 배달거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pizzaDis = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    pizzaDis.add(new Points(idx, i));
                } else if (num == 1) {
                    homes.add(new Points(idx, i));
                }
                idx++;
            }
        }
        len = pizzaDis.size();
        ch = new int[m];
        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int level, int start) {
        if (level == m) {
            int sum = 0;
            for (Points h : homes) {
                int min = Integer.MAX_VALUE;
                for (int p : ch) {
                    min = Math.min(min, Math.abs(h.x - pizzaDis.get(p).x) + Math.abs(h.y - pizzaDis.get(p).y));
                }
                sum += min;
            }
            answer = Math.min(sum, answer);
        } else {
            for (int i = start; i < len; i++) {
                ch[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }

}
