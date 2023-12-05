package test.coding.algorithm.exam6;

import java.util.Scanner;

public class Exam6_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(arr);
        in.close();
        return;
    }

    public static void solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pivotNum = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (pivotNum < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
