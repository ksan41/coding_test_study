package test.coding.algorithm.exam3;

import java.util.Scanner;

public class Exam3_03 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, n, k));
        return ;
      }

      public static int solution(int[] arr, int n, int k) {
        int answer = 0;
        for (int i = 0; i < k; i++) {
                answer += arr[i];
            }
        int end = k;
        int sum = answer;
        while (end < n) {
            sum = sum + arr[end] - arr[end - k];
            answer = Math.max(answer, sum);
            end++;
        }
        return answer;
      }
}
