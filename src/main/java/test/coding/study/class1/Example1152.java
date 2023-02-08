package test.coding.study.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example1152 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            System.out.println(solve(inputStr));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static int solve(String str) {
        if (str != null) {
            String[] arr = str.split(" ");
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].replaceAll(" ","").equals("")) {
                    cnt+=1;
                }
            }
            return cnt;
        }
        return 0;
    }
}
