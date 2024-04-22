package test.coding.algorithm.exam7;

import java.util.Scanner;

public class Exam7_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.nextInt());
    }

    // 6
    // 1 10 11 100 101 110
    public static void solution(int n) {
        if (n == 0) return;
        solution(n / 2);
        System.out.print(n%2);
    }
}
