package test.coding.algorithm.exam7;

import java.util.Scanner;

public class Exam7_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt()));
    }

    public static int solution(int n) {
        if (n == 1) return 1;
        return n * solution(n - 1);
    }
}
