package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Example10989 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++) {
            bw.write(String.valueOf(arr[i]+"\n"));
        }
        bw.flush();
        bw.close();
    }
}
