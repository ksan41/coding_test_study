package test.coding.study.class2;

import java.util.Scanner;

public class Example1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        solve(m, n);
    }

    public static void solve(int m, int n) {
        int[] arr = {1,3,7,9};
        StringBuffer bf = new StringBuffer();
        for (int i = m; i <= n; i++) {
            if (i == 2 || i == 3 || i == 5 || i == 7) {
                bf.append(i + "\n");
                continue;
            }
            if (i == 1 || i % 2 == 0) {
                continue;
            }
            boolean flg = true;
            for (int j = 3; j <= (int)Math.sqrt(i); j+=2) {
                if (i % j == 0) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                bf.append(i + "\n");
            }
        }
        System.out.println(bf.toString());
    }


}
