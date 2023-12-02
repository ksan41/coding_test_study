package test.coding.algorithm.exam5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam5_08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] waiting = new int[n];
        for (int i = 0; i < n; i++) {
            waiting[i] = in.nextInt();
        }
        System.out.println(solution(waiting, m));
        return;
    }

    public static int solution(int[] waiting, int m) {
        int answer = 0;
        Queue<Order> queue = new LinkedList<>();

        for (int i = 0; i < waiting.length; i++) {
            queue.offer(new Order(i, waiting[i]));
        }

        while (!queue.isEmpty()) {
            Order current = queue.poll();
            int size = queue.size();
            for (Order o : queue) {
                if (current.getValue() < o.getValue()) {
                    queue.offer(current);
                    break;
                }
            }
            if (size == queue.size()) {
                answer++;
                if (current.getIdx() == m) return answer;
            }

        }

        return 0;
    }

    public static class Order {
        private int idx;
        private int value;

        public Order(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int getIdx() {
            return this.idx;
        }

        public int getValue() {
            return this.value;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
