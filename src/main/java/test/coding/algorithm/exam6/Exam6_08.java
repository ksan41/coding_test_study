package test.coding.algorithm.exam6;

import java.util.Arrays;
import java.util.Scanner;

public class Exam6_08 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println(solution(arr, m));
        return ;
      }

      public static int solution(int[] arr, int m) {
        Arrays.sort(arr);

        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;

            if (arr[mid] == m) {
                return mid + 1;
            } else if (arr[mid] > m) {
                end = mid - 1;
            } else if (arr[mid] < m ){
                start = mid + 1;
            }
        }

        return start + 1;
      }
}
