package test.coding.study.class1;

import java.util.Scanner;

public class Example2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        str1 = reverseStr(str1);
        str2 = reverseStr(str2);
        if (Integer.parseInt(str1) > Integer.parseInt(str2)) {
            System.out.println(str1);
        } else {
            System.out.println(str2);
        }
    }

    public static String reverseStr(String str) {
        String[] arr = str.split("");
        String result =  "";
        for (int i = arr.length-1; i >= 0; i--) {
            result += arr[i];
        }
        return result;
    }
}
