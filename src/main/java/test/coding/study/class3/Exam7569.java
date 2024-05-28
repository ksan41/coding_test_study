package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y,h;
    public Point(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

public class Exam7569 {
    
    static int m, n, h, tomato = 0;
    static Queue<Point> queue;
    static int[][][] box;
    static int[] dirX = {0,0,-1,1,0,0};
    static int[] dirY = {-1,1,0,0,0,0}; // 상하좌우앞뒤
    static int[] dirH = {0,0,0,0,1,-1};

    // 토마토
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int idx = 0;
                while (st.hasMoreTokens()) {
                    int temp = Integer.parseInt(st.nextToken());
                    box[i][j][idx] = temp;
                    if (temp == 0) {
                        tomato++;
                    }
                    if (temp == 1) queue.offer(new Point(idx, j, i));
                    idx++;
                }
            }
        }

        if (tomato == 0) System.out.println(0);
        else {
            System.out.println(bfs());
        }


    }

    static int bfs() {
        int days = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Point current = queue.poll();
                for (int j = 0; j < dirX.length; j++) {
                    int nx = current.x + dirX[j];
                    int ny = current.y + dirY[j];
                    int nh = current.h + dirH[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        nh >= 0 && nh < h && 
                        box[nh][ny][nx] == 0
                    ) {
                        box[nh][ny][nx] = 1;
                        tomato--;
                        if (tomato == 0) return days + 1;
                        queue.offer(new Point(nx, ny, nh));
                    }
                }
            }
            days++;
        }
        return -1;
    }
}
