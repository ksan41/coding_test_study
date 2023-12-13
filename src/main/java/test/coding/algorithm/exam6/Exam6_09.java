package test.coding.algorithm.exam6;

import java.util.Arrays;
import java.util.Scanner;

public class Exam6_09 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println(solution(arr, m));
        return ;
      }

      public static int solution(int[] arr, int m) {
        int answer = 0;
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        int mid = 0;
        
        while (start <= end) {
            mid = (start + end) / 2;

            int cnt = 1;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    cnt++;
                    sum = arr[i];
                }

            }

            if (cnt <= m) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
      }
}
