package test.coding.algorithm.exam8;

import java.util.Scanner;

public class Exam8_06 {
    static int n, m = 0;
    static int[] arr, pick;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        ch = new int[n];
        pick = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0);
    }

    public static void DFS(int v) {
        if (v == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(pick[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pick[v] = arr[i];
                    DFS(v + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
