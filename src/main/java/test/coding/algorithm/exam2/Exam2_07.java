package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr));
        return;
    }

    public static int solution(int[] arr) {
        int answer = 0;

        int added = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                added = 0;
            } else {
                added++;
                answer += added;
            }
        }

        return answer;
    }
}
