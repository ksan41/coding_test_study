package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2839 {

    // 설탕 배달
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int carry = 0;
        int cnt3 = 0;
        int cnt5 = 0;
        boolean flg = true;
        carry = n / 5 * 5;
        cnt5 = n / 5;
        while(carry <= n) {
            if (cnt5 < 0 || cnt3 < 0) {
                flg = false;
                break;
            }
            if (carry == n) break;
            else {
                if ((n - carry) % 3 == 0) {
                    carry += 3;
                    cnt3 += 1;
                } else {
                    carry -= 2;
                    cnt5 -= 1;
                    cnt3 += 1;
                }
            }
        }

        if (flg) System.out.println(cnt3 + cnt5);
        else System.out.println(-1);


        
    }
}
