package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2231 {

    // 분해합
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        int current = n - 1;
        while (true) {
            int temp = current;
            int sum = current;
            while (temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            if (sum == n) {
                answer = Math.min(answer, current);
            }
            current -= 1;
            if (current < n / 2) break;
        }
        if (answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
