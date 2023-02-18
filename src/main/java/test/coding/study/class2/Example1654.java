package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int k = Integer.parseInt(str[0]);
        int n =Integer.parseInt(str[1]);

        long[] arr = new long[(int)k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long max = arr[arr.length -1];
        long min = 1;
        long mid = 0;
        
        long cnt = 0;
        while(min <= max) {
            cnt = 0;
            mid = (max+min)/ 2;
            for (int i = 0; i < arr.length; i++) {
                cnt+= arr[i]/mid;
            }
            if (cnt >= n) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}
