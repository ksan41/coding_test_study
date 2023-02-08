package test.coding.study.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example10818 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int cnt = Integer.parseInt(br.readLine());
            int min = 1000000;
            int max = -1000000;
            String inputStr = br.readLine();
            String[] arr = inputStr.split(" ");
            for (int i = 0; i < arr.length; i++) {

                if (min > Integer.parseInt(arr[i])) {
                    min = Integer.parseInt(arr[i]);
                }
                if (max < Integer.parseInt(arr[i])) {
                    max = Integer.parseInt(arr[i]);
                }
            }
            System.out.printf("%d %d", min, max);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
