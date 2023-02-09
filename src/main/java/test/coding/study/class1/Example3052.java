package test.coding.study.class1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Example3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i]%42, 0);
        }
        System.out.println(map.size());
    }
}
