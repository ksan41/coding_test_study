package test.coding.algorithm.exam2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam2_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n + 2][n + 2];

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(arr));
        return;
    }

    public static int solution(int[][] arr) {
        int answer = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                int current = arr[i][j];
                List<Integer> side = Arrays.asList(arr[i-1][j], arr[i][j-1], arr[i][j+1], arr[i+1][j]);
                int max = Collections.max(side);
                if (current > max) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
