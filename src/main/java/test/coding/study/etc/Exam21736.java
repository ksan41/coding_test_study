package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam21736 {

    static int n, m, x, y, answer = 0;
    static char[][] arr;
    static int[][] ch;
    static int[] xarr = { 0, 0, -1, 1 };
    static int[] yarr = { -1, 1, 0, 0 };

    // 21736 헌내기는 친구가 필요해
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n + 2][m + 2];
        ch = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input[j - 1];
                if (input[j - 1] == 'I') {
                    x = j;
                    y = i;
                }
            }
        }

        ch[y][x] = 1;
        dfs(y, x);

        if (answer == 0)
            System.out.println("TT");
        else
            System.out.println(answer);
    }

    public static void dfs(int ver, int hor) {
        if (arr[ver][hor] == 'X') return;
        else {
            if (arr[ver][hor] == 'P') answer += 1;
            for (int i = 0; i < xarr.length; i++) {
                int newY = ver + yarr[i];
                int newX = hor + xarr[i];
                if (arr[newY][newX] != 0 && ch[newY][newX] == 0) {
                    ch[newY][newX] = 1;
                    dfs(newY, newX);
                }
            }
        }
    }
}
