package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam13565 {

    static int m, n = 0;
    static int[][] arr;
    static String answer = "NO";
    static int[] dirX = { 0, 0, -1, 1 };
    static int[] dirY = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m + 2][n + 2];

        for (int i = 0; i < m + 2; i++) {
            Arrays.fill(arr[i], 2);
        }

        for (int i = 1; i <= m; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Character.getNumericValue(input[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[1][i] == 0) {
                dfs(1, i);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int y, int x) {
        if (y == m && arr[y][x] == 0) {
            answer = "YES";
            arr[y][x] = 1;
            return;
        }
        arr[y][x] = 1;
        for (int i = 0; i < dirX.length; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (arr[newY][newX] == 0) {
                dfs(newY, newX);
            }
        }
    }
}
