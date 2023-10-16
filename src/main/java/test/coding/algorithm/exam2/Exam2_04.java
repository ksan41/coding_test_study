package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solution(n);
        return;
    }

    public static void solution(int n) {
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
