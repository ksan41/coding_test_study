package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_04 {
    
    static int n, m = 0;    
    static int[] pm;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        pm = new int[m];

        DFS(0);
    }

    public static void DFS(int v) {
        if (v == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[v] = i;
                DFS(v + 1);
            }
        }
    }
}
