package test.coding.study.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example1546 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            double cnt = Double.parseDouble(br.readLine());
            String str = br.readLine();
            String[] arr = str.split(" ");
            double max = -1.0;
            for (int i = 0; i < arr.length; i++) {
                if (max < Double.parseDouble(arr[i])) {
                    max = Double.parseDouble(arr[i]);
                }
            }
            double sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (Double.parseDouble(arr[i]) != 0) {
                    sum += Double.parseDouble(arr[i])/max*100.0;
                }
            }
            System.out.println(sum/cnt);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
