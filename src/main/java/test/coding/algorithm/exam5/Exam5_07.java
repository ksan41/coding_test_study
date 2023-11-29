package test.coding.algorithm.exam5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam5_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String requiredCourses = in.next();
        String plan = in.next();
        System.out.println(solution1(requiredCourses, plan));
        // System.out.println(solution2(requiredCourses, plan));
        return;
    }

    public static String solution1(String requiredCourses, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char c : plan.toCharArray()) {
            queue.offer(c);
        }

        for (char c : requiredCourses.toCharArray()) {
            boolean flg = false;
            while (!queue.isEmpty()) {
                if (c == queue.poll()) {
                    flg = true;
                    break;
                }
            }
            if (!flg) {
                return "NO";
            }
        }
        return answer;
    }

    public static String solution2(String requiredCourses, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char c : requiredCourses.toCharArray()) {
            queue.offer(c);
        }
        for (char c : plan.toCharArray()) {
            if (queue.contains(c)) {
                if (queue.poll() != c) return "NO";
            }
        }

        return queue.isEmpty() ? answer : "NO";
    }
}
