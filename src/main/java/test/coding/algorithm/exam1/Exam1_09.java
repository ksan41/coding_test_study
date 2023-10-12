package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
        return;
    }

    public static int solution(String str) {
        str = str.replaceAll("[^0-9]","");
        return Integer.valueOf(str);
    }
}
