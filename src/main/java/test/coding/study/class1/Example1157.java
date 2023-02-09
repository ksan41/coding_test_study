package test.coding.study.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Example1157 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            str = str.toUpperCase(Locale.ROOT);
            List<String> strList = Arrays.asList(str.split(""));
            Map<String, Integer> strMap = new HashMap<>();
            for (int i = 0; i < strList.size(); i++) {
                if (strMap.containsKey(strList.get(i))) {
                    int cnt = strMap.get(strList.get(i)).intValue();
                    strMap.put(strList.get(i), ++cnt);
                } else {
                    strMap.put(strList.get(i), 1);
                }
            }
            int max = 0;
            String result = "?";
            for (String key : strMap.keySet()) {
                if (max == strMap.get(key)) {
                    result = "?";
                }
                if (max < strMap.get(key)) {
                    max = strMap.get(key);
                    result = key;
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
