package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example11050 {

    static int n, k = 0;

    // 이항 계수 1
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(dfs(n, k));
    }

    static int dfs(int n, int k) {
        if (n == k || n == 0 || k == 0) {
            return 1;
        } else {
            return dfs(n - 1, k - 1) + dfs(n - 1, k);
        }
    }
}
