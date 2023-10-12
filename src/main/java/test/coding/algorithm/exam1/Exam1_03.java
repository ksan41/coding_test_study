package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
        return;
    }

    public static String solution(String str) {
        String answer = "";

        for (String s : str.split(" ")) {
            if (s.length() > answer.length()) {
                answer = s;
            }
        }

        return answer;
    }
}
