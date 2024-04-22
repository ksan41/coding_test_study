package test.coding.algorithm.exam6;

import java.util.Arrays;
import java.util.Scanner;

public class Exam6_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] xi = new int[n];
        for (int i = 0; i < xi.length; i++) {
            xi[i] = in.nextInt();
        }
        in.close();
        System.out.println(solution(c, xi));
        return;
    }

    public static int solution(int c, int[] xi) {
        int answer = Integer.MIN_VALUE;

        Arrays.sort(xi);
        int start = Integer.MAX_VALUE;
        for (int i = 1; i < xi.length; i++) {
            if (xi[i] - xi[i - 1] < start)
                start = xi[i] - xi[i - 1];
        }
        int end = xi[xi.length - 1];

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = countHorses(mid, xi);

            if (cnt >= c) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    public static int countHorses(int minDist, int[] xi) {
        int cnt = 1;

        int lastIdx = 0;
        for (int i = 1; i < xi.length; i++) {
            if (xi[i] - xi[lastIdx] >= minDist) {
                cnt++;
                lastIdx = i;
            }
        }
        return cnt;
    }
}
