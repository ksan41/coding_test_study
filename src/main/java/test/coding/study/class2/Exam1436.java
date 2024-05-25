package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1436 {
    
    // 영화감독 숌
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int i = 0;
        int cnt = 0;
        String str = "";
        while (true) {
            str = String.valueOf(i);
            if (str.contains("666")) {
                cnt++;
                if (cnt == n) break;
            }
            i++;
        }
        System.out.println(str);
    }
}
