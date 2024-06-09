package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sqare {
    int startX, startY, endX, endY;
    int size;

    public Sqare(){}

    public Sqare(int startX, int startY, int endX, int endY, int size) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.size = size;
    }
    
}

public class Exam1074 {
    
    static int n, r, c, N = 0;
    static long cnt, answer = 0;
    static boolean flg = false;
    static int[] dirX = {1,-1,1};
    static int[] dirY = {0,1,0};

    // Z
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int)Math.round(Math.pow(2, n));

        solution(new Sqare(0,0,N-1, N-1, N * N));
        System.out.println(answer);
    }

    static void solution(Sqare squre) {
        if (flg) return;
        if (squre.size == 4) {
            int nx = squre.startX;
            int ny = squre.startY;
            if (nx == c && ny == r) {
                answer = cnt;
                flg = true;
                return;
            }
            cnt++;
            for (int i = 0; i < dirX.length; i++) {
                nx += dirX[i];
                ny += dirY[i];
                cnt += 1;
                if (nx == c && ny == r) {
                    answer = cnt - 1;
                    flg = true;
                    return;
                }
            }
        } else {
            // 쪼개기
            for (int i = squre.startY; i <= squre.endY; i+= (squre.endY - squre.startY)/2 + 1) {
                for (int j = squre.startX; j <= squre.endX; j += (squre.endX - squre.startX)/2 + 1) {
                    if (squre.startX == c && squre.startY == r) {
                        answer = cnt;
                        flg = true;
                        return;
                    }
                    if (j + (squre.endX - squre.startX)/2 < c || i + (squre.endY - squre.startY)/2 < r) {
                        cnt += squre.size / 4;
                    } else {
                        solution(new Sqare(j, i, j + (squre.endX - squre.startX)/2, i + (squre.endY - squre.startY)/2, squre.size / 4));
                    }
                }
            }
        }

    }

}
