package test.coding.algorithm.exam4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam4_03 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(n, k, arr);
        return ;
      }

      public static void solution(int n, int k, int[] arr) {
        int start = 0, current = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(current < n) {
            if (current - start < k) {
                map.put(arr[current], map.getOrDefault(arr[current], 0) + 1);
                current++;
            } else {
                System.out.print(map.size() + " ");

                if (map.get(arr[start]) > 1) {
                    map.put(arr[start], map.get(arr[start]) - 1);
                } else {
                    map.remove(arr[start]);
                }
                start++;
            }
        }
        System.out.print(map.size());
      }
}
