package test.coding.study.class2;

import java.util.Scanner;

public class Example2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        

        int yak = 1;
        int bae = a*b;
        
        while(true) {
            yak = a % b;
            if (yak == 0) {
                yak = b;
                break;
            }
            a = b;
            b = yak;
        }
        
        bae = bae / yak;
        
        System.out.println(yak);
        System.out.println(bae);
    }
}
