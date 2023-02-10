package test.coding.study.class2;

import java.util.Scanner;

public class Example1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr));

    }

    public static int solve(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
           
            if (arr[i] == 2 || arr[i] == 3 || arr[i] == 5 || arr[i] == 7) {
                res++;
                continue;
            }
            if (arr[i] % 2 == 0 || arr[i] == 1) {
                continue;
            }
            boolean flg = true;
            for (int j = 3; j < 1000; j+=2) {
                if (arr[i] % j == 0 && arr[i] != j) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                res += 1;
            }
        }
        return res;
    }
}
