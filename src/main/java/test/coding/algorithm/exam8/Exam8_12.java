package test.coding.algorithm.exam8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}

public class Exam8_12 {
    
    static int m, n, tomato = 0;
    static int[][] map;
    static Queue<Point> queue;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) queue.offer(new Point(idx, i));
                if (num == 0) tomato++;
                map[i][idx++] = num;
            }
        }

        int result = bfs();
        if (tomato > 0 && result > 0) System.out.println(-1);
        else System.out.println(result);
    }

    static int bfs() {

        int level = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point current = queue.poll();
                for (int j = 0; j < dirX.length; j++) {
                    int nx = current.getX() + dirX[j];
                    int ny = current.getY() + dirY[j];
                    if (nx >= 0 && nx < m && ny >= 0  && ny < n && map[ny][nx] == 0) {
                        map[ny][nx] = 1;
                        tomato--;
                        if (tomato == 0) return level + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            level++;
        }
        return level;
    }
}
