package test.coding.algorithm.exam6;

import java.util.Scanner;
import java.util.Stack;

public class Exam6_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        // solution1(s, n, arr);
        solution2(s, n, arr);
        return;
    }

    /**
     * Stack
     */
    public static void solution1(int s, int n, int[] arr) {
        Stack<Integer> cache = new Stack<>();
        cache.push(arr[0]);

        for (int i = 1; i < n; i++) {
            if (cache.contains(arr[i])) {
                cache.remove(cache.indexOf(arr[i]));
                cache.push(arr[i]);
            } else {
                if (cache.size() == s) {
                    cache.remove(cache.firstElement());
                }
                cache.push(arr[i]);
            }
        }

        while (!cache.isEmpty()) {
            System.out.print(cache.pop() + " ");
        }
    }

    /**
     * Array
     */
    public static void solution2(int s, int n, int[] arr) {
        int[] cache = new int[s];

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            boolean isCacheMiss = true;
            for (int j = 0; j < s; j++) {
                if (temp == cache[j]) {
                    for (int k = j - 1; k >= 0; k--) {
                        cache[k + 1] = cache[k];
                    }
                    isCacheMiss = false;
                    break;
                }
            }
            if (isCacheMiss) {
                for (int k = s - 2; k >= 0; k--) {
                    cache[k + 1] = cache[k];
                }
            }
            cache[0] = temp;
        }

        for (int i : cache) {
            System.out.print(i + " ");
        }
    }
}
