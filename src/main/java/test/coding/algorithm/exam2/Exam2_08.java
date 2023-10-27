package test.coding.algorithm.exam2;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2_08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        solution(arr);
        return;
    }

    public static void solution(int[] arr) {
        int[] rank = new int[arr.length];
        Arrays.fill(rank, 1);
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    rank[i] += 1;
                }
            }    
        }

        for (int i = 0; i < rank.length; i++) {
            System.out.printf("%d ", rank[i]);
        }
    }
}
