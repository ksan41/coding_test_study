package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam9375 {
    
    static int types=0;
    static Map<String, ArrayList<String>> map;

    // 패션왕 신해빈
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                types = Integer.parseInt(st.nextToken());
                if (types > 0) {
                    map = new HashMap<>();
                    String temp = "";
                    for (int j = 0; j < types; j++) {
                        st = new StringTokenizer(br.readLine());
                        String name = st.nextToken();
                        String kind = st.nextToken();
                        ArrayList<String> putNm = map.getOrDefault(kind, new ArrayList<>());
                        putNm.add(name);
                        map.put(kind, putNm);
                        temp = kind;
                    }
                    
                    int total = map.get(temp).size();
                    if (map.size() > 1) {
                        total = map.get(temp).size() + 1;
                        for (String key: map.keySet()) {
                            if (!key.equals(temp)) {
                                total *= map.get(key).size() + 1;
                            }
                        }
                        bw.append((total - 1) + "");
                    } else bw.append((total) + "");
                    
        
                } else bw.append(0 + "");
                bw.newLine();
        }
        bw.flush();
    }


}
