package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam9095 {
    
    static int answer = 0;

    // 1, 2, 3 더하기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < t; i++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            dfs(n);

            bw.write(answer + "");
            bw.newLine();
        }

        bw.flush();
    }

    static void dfs(int v) {
        if (v < 0) return;
        if (v == 0) answer += 1;
        else {
            dfs(v-1);
            dfs(v-2);
            dfs(v-3);
        }
    }
}
