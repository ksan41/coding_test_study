package test.coding.algorithm.exam7;

import java.util.Scanner;

public class Exam7_04 {
    static int[] arr;

    public static void main(String[] args) {
        // 재귀 피보나치
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        solution(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // n == 항의 번호
    public static int solution(int n) {
        if (arr[n] > 0) return arr[n]; // 이미 구해진 항의 값은 바로 리턴하도록함
        if (n==1) return arr[n] = 1;
        else if (n==2) return arr[n] = 1;
        else return arr[n] = solution(n - 2) + solution(n - 1);
    }

}
