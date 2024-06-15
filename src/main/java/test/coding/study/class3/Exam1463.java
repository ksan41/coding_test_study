package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam1463 {
    
    static int answer = Integer.MAX_VALUE;

    // 1로 만들기(ing, 시간초과)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        answer = dfs(x, 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "");
        bw.flush();
    }

    static int dfs(int num, int cnt) {
        if (num == 1) return answer = Math.min(answer, cnt);
        if (num % 3 == 0) dfs(num/3, cnt + 1);
        if (num % 2 == 0) dfs(num/2, cnt + 1);
        return dfs(num - 1, cnt + 1);
    }
}
