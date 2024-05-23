package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam2775 {

    static int[][] arr;

    // 부녀회장이 될테야
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr = new int[k + 1][n + 1];

            for (int j = 1; j <= n; j++) {
                arr[0][j] = j;
            }

            for (int j = 1; j <= k; j++) {
                for (int j2 = 1; j2 <= n; j2++) {
                    for (int m = 1; m <= j2; m++) {
                        arr[j][j2] += arr[j - 1][m];
                    }             
                }
            }
            bw.append(arr[k][n] + "");
            bw.newLine();
        }
        bw.flush();
    }
}
