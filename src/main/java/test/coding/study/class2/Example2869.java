package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example2869 {

    // 달팽이는 올라가고 싶다
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int date = Integer.MAX_VALUE;

        if ((v - a) % (a-b) == 0) {
            date = (v - a) / (a-b) + 1;
        } else {
            date = (v - a) / (a - b) + 2;
        }


        System.out.println(date);
    }
}
