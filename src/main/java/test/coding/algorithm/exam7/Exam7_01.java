package test.coding.algorithm.exam7;

import java.util.Scanner;

public class Exam7_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.nextInt());
    }

    public static void solution(int n) {
        if (n == 0) return;
        solution(n - 1);
        System.out.print(n + " ");
    }
}
