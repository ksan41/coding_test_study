package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam18110 {
    
    // solved.ac
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 0;
        int cnt = n;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < Math.round(Double.valueOf(n) * 0.15); i++) {
            sum -= arr[i];
            sum -= arr[arr.length - 1 - i];
            cnt -= 2;
        }
        System.out.println(Math.round(Double.valueOf(sum) / Double.valueOf(cnt)));
    }
}
