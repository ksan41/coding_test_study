package test.coding.study.class2;

import java.util.Scanner;

public class Example1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[] arr = new int[3];
        if (x >= y) {
            arr[0] = y;
        } else {
            arr[0] = x;
        }

        arr[1] = w-x;
        arr[2] = h-y;
        int min = arr[0];
        for (int i = 1; i < 3; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
