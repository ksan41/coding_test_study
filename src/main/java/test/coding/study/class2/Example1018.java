package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example1018 {

    static int n, m = 0;
    static int answer = Integer.MAX_VALUE;
    static char[][] map;
    static char[][] chess1 = new char[8][8];
    static char[][] chess2 = new char[8][8];
    static char b = 'B';
    static char w = 'W';

    public static void main(String[] args) throws Exception {
        // 체스판 다시 칠하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        makeDefaultChess(chess1, 'B');
        makeDefaultChess(chess2, 'W');

        for (int i = 0; i < n; i++) {
            if (i + 8 <= n) {
                for (int j = 0; j < m; j++) {
                    if (j + 8 <= m) {
                        char[][] croped = crop(i, j);
                        int a = compare(croped, chess1);
                        answer = Math.min(answer, a);
                        int b = compare(croped, chess2);
                        answer = Math.min(answer, b);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static char[][] crop(int y, int x) {
        char[][] croped = new char[8][8];
        int yidx = 0;
        int xidx = 0;
        for (int i = y; i < y+8; i++) {
            xidx = 0;
            for (int j = x; j < x + 8; j++) {
                croped[yidx][xidx++] = map[i][j];
            }
            yidx++;
        }
        return croped;
    }

    static void makeDefaultChess(char[][] chess, char c) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (c == 'W') {
                    chess[i][j] = 'B';
                    c = 'B';
                } else {
                    chess[i][j] = 'W';
                    c = 'W';
                }
            }
            if (chess[i][0] == 'B') {
                c = 'B';
            } else {
                c = 'W';
            }
        }
    }

   static int compare(char[][] croped, char[][] dchess) {
    int result = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (croped[i][j] != dchess[i][j]) result++;
            }
        }
        return result;
   }
   

}
