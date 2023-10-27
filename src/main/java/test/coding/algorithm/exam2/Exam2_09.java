package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(arr));
        return;
    }

    public static int solution(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int dia1 = 0;
        int dia2 = 0;
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            int hor = 0;
            int ver = 0;
            dia1 += arr[i][idx];
            dia2 += arr[arr.length - 1 - idx][i];
            idx++;
            for (int j = 0; j < arr[i].length; j++) {
                hor += arr[i][j];
                ver += arr[j][i];
            }
            max = Math.max(max, hor);
            max = Math.max(max, ver);
        }

        max = Math.max(max, dia1);
        max = Math.max(max, dia2);
        return max;
    }
}
