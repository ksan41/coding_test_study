package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Example10816 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] cards = br.readLine().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String string : cards) {
            if (map.get(string) != null) {
                map.put(string ,map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            bf.append(map.get(arr[i]) == null? "0" : map.get(arr[i]));
            if (i != arr.length-1) {
                bf.append(" ");
            }
        }
        System.out.println(bf.toString());

    }
}
