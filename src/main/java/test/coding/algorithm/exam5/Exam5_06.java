package test.coding.algorithm.exam5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam5_06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 1~n
        int k = in.nextInt();
        System.out.println(solution(n, k));
        in.close();
        return;
    }

    public static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        
        int cnt = 0;
        while (1 < queue.size()) {
            cnt++;
            int first = queue.poll();
            if (cnt == k) {
                cnt = 0;
            } else {
                queue.offer(first);
            }
        }

        return queue.poll();
    }
}
