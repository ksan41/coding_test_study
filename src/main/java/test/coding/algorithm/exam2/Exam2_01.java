package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        solution(arr);
        return;
    }

    public static void solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0] + " ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                sb.append(arr[i] + " ");
            }
        }
        System.out.println(sb.toString());
    }
}
