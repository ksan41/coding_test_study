package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = in.nextInt();
        }
        solution(a, b);
        return;
    }

    public static void solution(int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            int currentA = a[i];
            int currentB = b[i];
            if (currentA == currentB) {
                sb.append("D\n");
                continue;
            }

            if (currentA > currentB) {
                if (currentA - currentB < 2) {
                    sb.append("A");
                } else {
                    sb.append("B");
                }
            } else {
                if (currentB - currentA < 2) {
                    sb.append("B");
                } else {
                    sb.append("A");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
