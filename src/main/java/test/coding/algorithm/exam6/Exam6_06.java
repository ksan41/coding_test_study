package test.coding.algorithm.exam6;

import java.util.Arrays;
import java.util.Scanner;

public class Exam6_06 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        solution(arr);
        return ;
      }

      public static void solution(int[] arr)  {
        int[] tempArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tempArr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tempArr[i]) {
                System.out.print(i + 1 + " ");
            }
        }
      }
}
