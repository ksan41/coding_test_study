package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam14248 {
    
    static int n, s, answer = 0;
    static int[] Ai;
    static int[] ch;

    // 14248 점프 점프
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        Ai = new int[n + 1];
        ch = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        
        ch[s] = 1;
        dfs(s);

        for (int i : ch) {
            if (i == 1) answer += 1;
        }

        System.out.println(answer);
    }

    public static void dfs(int v) {
        if (v > n + 1 || v < 1) {
            return;
        } else {
            int current = Ai[v];
            if (v + current < n + 1 ) {
                ch[v + current] = 1;
                if (ch[v + current] == 0) ch[v + current] = 1;
                dfs(v + current);
            } 
            if (v - current > 0) {
                ch[v - current] = 1;
                if (ch[v - current] == 0) ch[v - current] = 1;
                dfs(v - current);
            }
        }
    }
}
