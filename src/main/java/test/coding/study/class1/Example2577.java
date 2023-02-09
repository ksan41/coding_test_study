package test.coding.study.class1;

import java.util.Scanner;

public class Example2577 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String[] arr = String.valueOf(a * b * c).split("");
        int[] res = new int[10];
        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    int idx = Integer.parseInt(arr[i]);
                    res[idx] += 1;
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(res[i]);
            }
        } catch (Exception e) {
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }
}
