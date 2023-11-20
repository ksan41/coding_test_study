package test.coding.algorithm.exam3;

import java.util.Scanner;

public class Exam3_01 {
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
        int[] newArr = new int[arrN.length + arrM.length];
        int idx = 0;
        int pivotN = 0;
        int pivotM = 0;
        while (idx < newArr.length) {
            if (pivotN == arrN.length) {
                consumeRemain(pivotM, idx, arrM, newArr);
                break;
            }
            if (pivotM == arrM.length) {
                consumeRemain(pivotN, idx, arrN, newArr);
                break;
            }
            if (arrN[pivotN] < arrM[pivotM]) {
                newArr[idx] = arrN[pivotN++];
            } else {
                newArr[idx] = arrM[pivotM++];
            }
            idx++;
        }

        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }

    public static void consumeRemain(int pivot, int idx, int[] arr, int[] newArr) {
        for (int i = pivot; i < arr.length; i++) {
            newArr[idx++] = arr[i];
        }
    }

}
