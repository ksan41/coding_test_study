package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x,y;
    public Tomato (int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Exam7576 {
    
    static int m, n, cnt = 0;
    static int[][] box;
    static Queue<Tomato> queue;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 토마토
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        box = new int[m][n];
        queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                int current = Integer.parseInt(st.nextToken());
                box[i][idx] = current;
                if (current == 1) queue.offer(new Tomato(idx, i));
                if (current == 0) cnt++;
                idx++;
            }
        }

        if (cnt == 0) System.out.println(0);
        else {
            System.out.println(bfs());
        }
    }

    static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Tomato current = queue.poll();
                for (int j = 0; j < dirX.length; j++) {
                    int nx = current.x + dirX[j];
                    int ny = current.y + dirY[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        cnt--;
                        if (cnt == 0) return days + 1;
                        queue.offer(new Tomato(nx, ny));
                    }
                }
            }
            days++;
        }

        return -1;
    }
}
