package test.coding.algorithm.exam8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node {
    int value;
    int x, y;

    public Node(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getValue() {
        return this.value;
    }
}

public class Exam8_11 {
    
    static int[][] graph;
    static int[] dirX = {0,0, -1,1};
    static int[] dirY = {-1,1,0,0};

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        graph = new int[9][9];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 2);
        }


        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        graph[1][1] = 1;
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>(); 
        queue.offer(new Node(0,1,1));

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node current = queue.poll();

                for (int j = 0; j < dirX.length; j++) {
                    int nextX = current.getX() + dirX[j];
                    int nextY = current.getY() + dirY[j];
                    if (graph[nextX][nextY] == 0) {
                        if (nextX == 7 && nextY == 7) {
                            level = level + 1;
                            return level;
                        }
                        graph[nextX][nextY] = 1;
                        queue.offer(new Node(0, nextX, nextY));
                    }
                }

            }
            level++;
        }

        return -1;
    }
}
