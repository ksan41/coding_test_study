package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example1259 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = bf.readLine();
            if(str.equals("0")) {
                break;
            }
            char[] arr = str.toCharArray();
            if (arr.length == 1) {
                System.out.println("yes");
            } else {
                int flg = 0;
                for (int i = 0; i < arr.length / 2; i++) {
                    if (arr[i] == arr[arr.length-1-i]) {
                        flg += 1;
                    } else {
                        flg = 0;
                        break;
                    }
                }
                if (flg > 0) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
