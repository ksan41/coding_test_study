package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2292 {
    
    // 벌집
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());

        long idx = 1;
        long cnt = 1;
        boolean flg = false;
        if (N == 1) System.out.println(1);
        else {
            while(idx <= N) {
                for (long i = idx + 1; i <= idx + 6 * cnt; i++) {
                    if (i == N) {
                        flg = true;
                        break;
                    }
                }
                if (flg) break;
                idx = idx + 6 * cnt;
                cnt++;
            }

            System.out.println(cnt + 1);
        }
        
    }
}
