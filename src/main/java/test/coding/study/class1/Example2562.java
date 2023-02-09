package test.coding.study.class1;

import java.util.Scanner;

public class Example2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        int order = 0;
        for (int i = 0; i < 9; i++) {
            if (max < arr[i]) {
                max = arr[i];
                order = i+1;
            }
        }
        System.out.println(max);
        System.out.println(order);
    }
}
