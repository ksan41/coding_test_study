package test.coding.study.class1;

import java.util.Scanner;

public class Example10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alpha.length(); i++) {
            int num = str.indexOf(String.valueOf(alpha.charAt(i)));
            if (num < 0) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(num + " ");
            }
        }
    }
}
