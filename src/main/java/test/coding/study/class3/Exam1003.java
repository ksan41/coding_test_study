package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam1003 {

    static int[] mem;

    // 피보나치 함수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            if (N != 0) {
                mem = new int[N + 1];
                mem[1] = 1;
                dfs(N);
                bw.write(mem[N - 1] + " " + mem[N]);
            } else {
                bw.write(1 + " " + 0);
            }
            bw.newLine();
        }
        bw.flush();
    }

    static int dfs(int v) {
        if (mem[v] > 0) {
            return mem[v];
        }
        if (v == 1) {
            return mem[v] = 1;
        } else if (v == 2) {
            return mem[v] = 1;
        } else {
            return mem[v] = dfs(v-1) + dfs(v-2);
        }
    }
}
