package test.coding.study.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example11720 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int cnt = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str.substring(0, cnt);

            System.out.println(solve(str));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static int solve(String str) {
        int sum = 0;
        if (str != null) {
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(String.valueOf(arr[i]));
            }
        }
        return sum;
    }
}
