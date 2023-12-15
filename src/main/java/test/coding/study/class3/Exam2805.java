package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exam2805 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");
            long n = Long.parseLong(str[0]);
            long m = Long.parseLong(str[1]);

            long[] arr = new long[Long.valueOf(n).intValue()];

            str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(str[i]);
            }

            System.out.println(solution(n, m, arr));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static long solution(long n, long m, long[] arr) {
        long answer = 0;
        long start = 0;
        long end = Arrays.stream(arr).max().getAsLong();
        
        while(start <= end) {
            long mid = (start + end) / 2;

            long h = cropWood(mid, arr);
            if (h == m) {
                answer = mid;
                break;
            } else if (h > m) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    public static long cropWood(long cropHight, long[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - cropHight > 0) {
                sum += arr[i] - cropHight;
            }
        }
        return sum;
    }
}
