package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Dot {
    int widS, widE, heiS, heiE;

    public Dot(){}

    public Dot(int widS, int widE, int heiS, int heiE) {
        this.widS = widS;
        this.widE = widE;
        this.heiS = heiS;
        this.heiE = heiE;
    }
    
}
public class Exam2630 {
    
    static int[][] paper;
    static int blue, white;

    // 색종이 만들기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                paper[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }
        solution(new Dot(0, n - 1, 0, n - 1));
        System.out.println(white);
        System.out.println(blue);
        
    }

    static void solution(Dot squre) {
        // 1x1
        if (squre.widS == squre.widE) {
            if (paper[squre.heiS][squre.widS] == 0) white++;
            else blue++;
            return;
        }
        int w = 0;
        int b = 0;
        // 색상 같은지 검사
        for (int i = squre.heiS; i <= squre.heiE; i++) {
            for (int j = squre.widS; j <= squre.widE; j++) {
                if (paper[i][j] == 0) w++;
                else b++;
            }
        }
        if (w == 0 || b == 0) {
            if (w > 0) white++;
            else  blue++;
        } else {
            for (int i = squre.heiS; i <= squre.heiE; i += (squre.heiE - squre.heiS)/2 + 1) {
                for (int j = squre.widS; j <= squre.widE; j += (squre.widE - squre.widS)/2 + 1) {
                    solution(new Dot(j,j + (squre.widE - squre.widS)/2,i, i + (squre.heiE - squre.heiS)/2));
                }
            }
        }
    }
}
