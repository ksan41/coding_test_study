package test.coding.algorithm.exam4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Exam4_05 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, k));
        in.close();
        return ;
      }

      public static int solution(Integer[] arr, int k) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int m = j + 1; m < arr.length; m++) {
                    int sum = arr[i] + arr[j] + arr[m];
                    set.add(sum);
                }
            }
        }

        int cnt = 0;
        for (int i : set) {
            cnt++;
            if (cnt == k) return i;
        }
        return answer;
      }
}
