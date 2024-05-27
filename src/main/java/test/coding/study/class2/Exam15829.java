package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam15829 {

    static Map<Character, Integer> map;

    // Hashing
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int r = 31;
        int M = 1234567891;

        map = new HashMap<>();
        int cnt = 97;
        for (int i = 1; i <= 26; i++) {
            map.put((char)cnt++, i);
        }

        long sum = 0;
        long powValue = 1;
        for (int i = 0; i < L; i++) {
            int idxValue = map.get(str.charAt(i));
            sum += (idxValue % M) * (powValue % M);
            powValue = powValue * r % M;
        }
        System.out.println(sum % M);
    }
}
