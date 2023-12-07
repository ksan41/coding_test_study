package test.coding.algorithm.exam6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exam6_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println(solution2(arr));
        return;
    }

    public static char solution1(int[] arr) {
        char answer = 'U';
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i)) return 'D';
            set.add(i);
        }

        return answer;
    }

    public static char solution2(int[] arr) {
        char answer = 'U';
        
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0 ; j--) {
                if (temp == arr[j]) return 'D';
            }
        }
        return answer;
    }

    public static char solution3(int[] arr) {
        char answer = 'U';
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return 'D';
        }
        return answer;
    }
}
