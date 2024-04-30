package test.coding.study.programmers.level3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Exam1 {

    static int[] ch;

    // 가장 먼 노드
    public static void main(String[] args) throws IOException{
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        solution(n, vertex);
    }

    public static int solution(int n, int[][] edge) {
        int[] ch = new int[n + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        ch[1] = 1;
        queue.offer(1);

        Map<Integer, Integer> answer = new HashMap<>();

        int level = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                for (int nc : graph.get(current)) {
                    if (ch[nc] == 0) {
                        queue.offer(nc);
                        ch[nc] = 1;
                        answer.put(level + 1, answer.getOrDefault(level + 1, 0) + 1);
                    }
                }
            }
            level++;
        }

        int max = 0;
        for (Integer key : answer.keySet()) {
            max = Math.max(max, key);            
        }

        return answer.get(max);
    }
}
