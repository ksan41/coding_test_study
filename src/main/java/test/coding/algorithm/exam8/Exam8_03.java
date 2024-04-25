package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_03 {
    
    static int n, m, answer;
    static int[][] arr;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        arr = new int[2][n];

        for (int i = 0; i < n; i++) {
            arr[0][i] = in.nextInt();
            arr[1][i] = in.nextInt();
        }

        DFS(0, 0, 0);
        System.out.println(answer);
      }

      public static void DFS(int v, int time, int score) {
        if (time > m) return;
        if (v == n) {
            answer = Math.max(answer, score);
        } else {
            DFS(v + 1, time + arr[1][v], score + arr[0][v]);
            DFS(v + 1, time, score);
        }
      }
}
