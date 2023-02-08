package test.coding.study.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example11654 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            int num = inputStr.charAt(0);
            System.out.println(num);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
