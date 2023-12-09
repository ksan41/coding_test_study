package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Exam1966 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            StringBuffer sb = new StringBuffer();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int docCnt = Integer.parseInt(input[0]);
                int idx = Integer.parseInt(input[1]);
                Queue<Task> queue = new LinkedList<>();

                input = br.readLine().split(" ");
                for (int j = 0; j < docCnt; j++) {
                    queue.offer(new Task(j, Integer.parseInt(input[j])));
                }
                sb.append((solution(idx, queue) + "\n"));
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static int solution(int idx, Queue<Task> queue) {
        int answer = 0;
        while (!queue.isEmpty()) {
            Task current = queue.poll();
            int size = queue.size();
            for (Task t : queue) {
                if (current.value < t.value) {
                    queue.offer(current);
                    break;
                }
            }
            if (size == queue.size()) {
                answer++;
                if (current.idx == idx) return answer;
            }
        }
        return answer;
    }

    static class Task {
        public int idx, value;
        public Task(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}

