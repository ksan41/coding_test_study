package test.coding.study.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Example4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer bf = new StringBuffer();
        while(true) {
            int[] arr = new int[3];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                System.out.println(bf.toString());
                return;
            }

            if (arr[0] == arr[1] && arr[0] == arr[2]) {
                bf.append("wrong\n");
                continue;
            }
            
            int max = 1;
            Arrays.sort(arr);
            if (Math.pow(arr[2], 2) == Math.pow(arr[0], 2) + Math.pow(arr[1],2)) {
                bf.append("right\n");
            } else {
                bf.append("wrong\n");
            }
        }
    }
}
