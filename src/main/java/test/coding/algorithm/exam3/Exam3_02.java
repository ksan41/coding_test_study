package test.coding.algorithm.exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exam3_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = in.nextInt();
        }
        solution(arrN, arrM);
        return;
    }

    public static void solution(int[] arrN, int[] arrM) {
        List<Integer> li = new ArrayList<>();
        Arrays.sort(arrN);
        Arrays.sort(arrM);
        int pivotN = 0, pivotM = 0;

        while (pivotN < arrN.length && pivotM < arrM.length) {
            if (arrN[pivotN] == arrM[pivotM]) {
                li.add(arrN[pivotN++]);
                pivotM++;
            } else if (arrM[pivotM] > arrN[pivotN]) {
                pivotN++;
            } else {
                pivotM++;
            }
        }
        li.stream()
                .forEach(i -> System.out.print(i + " "));
    }
}
