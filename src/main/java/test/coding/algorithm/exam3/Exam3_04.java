package test.coding.algorithm.exam3;

import java.util.Scanner;

public class Exam3_04 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, m));
        return ;
      }

       public static int solution(int[] arr, int m) {
        int answer = 0;
        int pivot = 1, start = 0, sum = arr[0];
        while (pivot < arr.length) {
            if (sum < m) {
                sum += arr[pivot++];       
            } else if (sum > m) {
                sum = sum - arr[start++];
            } else {
                answer++;
                sum = sum - arr[start++];
            }
        }
        if (sum == m) answer++;
        return answer;
      }
}
