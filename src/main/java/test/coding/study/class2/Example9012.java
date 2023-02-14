package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example9012 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            String str = bf.readLine();
            if (str.length() % 2 == 0) {
                boolean flg = false;
                while(!str.equals("")) {
                    flg = false;
                    if (str.indexOf("()") == -1) {
                        System.out.println("NO");
                        break;
                    }
                    str = str.replace("()","");
                    flg = true;
                }
                if (flg) {
                    System.out.println("YES");
                }
                
            } else {
                System.out.println("NO");
            }
        }
    }
}
