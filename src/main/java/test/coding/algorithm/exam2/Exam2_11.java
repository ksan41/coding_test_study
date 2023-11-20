package test.coding.algorithm.exam2;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2_11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(arr, n));
        return;
    }

    public static int solution(int[][] arr, int n) {
        int[] studentsCnt = new int[arr.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        studentsCnt[i]++;
                        break;
                    }
                }
            }
        }
        int maxValue = Arrays.stream(studentsCnt).max().getAsInt();
        for (int i = 0; i < studentsCnt.length; i++) {
            if (maxValue == studentsCnt[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
