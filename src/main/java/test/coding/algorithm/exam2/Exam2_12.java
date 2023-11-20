package test.coding.algorithm.exam2;

import java.util.Scanner;

public class Exam2_12 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(arr, n, m));
        return ;
      }

      public static int solution(int[][] arr, int n, int m) {
        int answer = 0;
        // 4 3 (학생수, 시험 수)
        // 3 4 1 2 (순서대로 1, 2, 3, 4위)
        // 4 3 2 1
        // 3 1 4 2
        int[][] rankArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rankArr[i][arr[i][j] - 1] = j + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                boolean flg = true;
                for (int k = 0; k < m; k++) {
                    if (rankArr[k][i] > rankArr[k][j]) {
                        flg = false;
                        break;
                    }
                }
                if (flg) answer++;
            }
        }
        return answer;
      }
}
