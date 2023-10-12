package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);
        System.out.println(solution(str, c));
        return;
    }

    public static int solution(String str, char c) {
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for (char ch : str.toCharArray()) {
            if (ch == c) {
                answer += 1;
            }
        }

        return answer;
    }

}
