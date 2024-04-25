package test.coding.algorithm.exam8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exam8_01 {
    
    static int n, total = 0;
    static int[] arr;
    static int[] ch;
    static Set<Integer> set;
    static String answer = "NO";
    static boolean flg = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n + 1];
        ch = new int[n + 1];
        set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            total += arr[i];
        }

        solution(1);
        System.out.println(answer);
    }

    public static void solution(int num) {
        if (flg) return;
        if (num == n + 1) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    sum += arr[i];
                }
            }
            if (total - sum == sum) {
                answer = "YES";
                flg = true;
            }
        } else {
            ch[num] = 1;
            solution(num + 1);
            ch[num] = 0;
            solution(num + 1);
        }
    }
}
