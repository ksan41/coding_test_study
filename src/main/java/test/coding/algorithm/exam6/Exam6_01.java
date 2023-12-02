package test.coding.algorithm.exam6;

import java.util.Scanner;

public class Exam6_01 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(arr);
        in.close();
        return ;
      }

      public static void solution(int[] arr) {
        int pivot = 0;
        
        while (pivot < arr.length) {
            int min = pivot;
            for (int i = pivot + 1; i < arr.length; i++) {
                if (arr[min] > arr[i]) {
                    min = i;
                }
            }
            int temp = arr[pivot];
            arr[pivot] = arr[min];
            arr[min] = temp;
            System.out.print(arr[pivot] + " ");
            pivot++;
        }
      }
}
