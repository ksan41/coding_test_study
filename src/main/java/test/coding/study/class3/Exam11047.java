package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam11047 {

    static int n, k, answer = 0;
    static boolean flg = false;
    static int[] money;

    // 동전 0
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        money = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
        }

        dfs(k, 0);
        System.out.println(answer);
    }

    static void dfs(int v, int coin) {
        if (flg) return;
        if (v == 0) {
            answer = coin;
            flg = true;
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (v - money[i] >= 0) {
                    dfs(v % money[i], coin + v / money[i]);
                }
            }
        }
    }
}
