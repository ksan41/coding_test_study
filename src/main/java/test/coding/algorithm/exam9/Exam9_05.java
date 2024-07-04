package test.coding.algorithm.exam9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int idx, value;
    Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    // 오름차순
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

public class Exam9_05 {
    
    
    static int n, m = 0;
    static ArrayList<ArrayList<Node>> map;
    static int[] ch, answer;
    static PriorityQueue<Node> queue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        queue = new PriorityQueue<>();
        map = new ArrayList<>();
        answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int value = in.nextInt();
            map.get(a).add(new Node(b, value));
        }
       
        queue.offer(new Node(1, 0));
        answer[1] = 0;

        while (!queue.isEmpty()) {
            Node min = queue.poll();
            ch[min.idx] = 1;

            for (Node nv : map.get(min.idx)) {
                if (ch[nv.idx] == 0) {
                    answer[nv.idx] = Math.min(answer[nv.idx], answer[min.idx] + nv.value);
                    queue.offer(new Node(nv.idx, min.value + nv.value));
                }
            }
        }


        for (int i = 2; i < answer.length; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
                } else {
                System.out.println(i + " : " + answer[i]);
            }
        }
    }
}
