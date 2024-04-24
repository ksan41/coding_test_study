package test.coding.algorithm.exam7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam7_14exam {
    
    static int n, m, level = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n + 1];
        dis = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        BFS(1);
        for (int i = 1; i < dis.length; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                for (int nv : graph.get(current)) {
                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        queue.offer(nv);
                        dis[nv] = level + 1;
                    }
                }
            }

            level++;
        }
    }
}
