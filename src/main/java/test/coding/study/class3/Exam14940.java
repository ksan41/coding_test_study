package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point1 {
    int x,y;

    Point1(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Exam14940 {

    static int n, m = 0;
    static int[][] map, answer;
    static Queue<Point1> queue;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {-1,1,0,0};

    // 쉬운 최단거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        answer = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(answer[i], -1);
        }

        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                map[i][idx] = num;
                if (num == 2) {
                    queue.offer(new Point1(idx, i));
                    answer[i][idx] = 0;
                }
                if (num == 0) {
                    answer[i][idx] = 0;
                }
                idx++;
            }
        }

        bfs();
        for (int i = 0; i < n; i++) {
            for (int num : answer[i]) {
                bw.write(num + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    static void bfs() {
        int level = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Point1 current = queue.poll();
                for (int j = 0; j < dirX.length; j++) {
                    int nx = current.x + dirX[j];
                    int ny = current.y + dirY[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && map[ny][nx] != 2 && map[ny][nx] != 0
                    ) {
                        answer[ny][nx] = level + 1;
                        queue.offer(new Point1(nx, ny));
                        map[ny][nx] = 2;
                    }
                }
            }
            level++;
        }
    }
}
