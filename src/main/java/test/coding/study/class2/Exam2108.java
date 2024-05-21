package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exam2108 {

    static int sum = 0;

    // 통계학
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            li.add(Integer.parseInt(st.nextToken()));
        }

        li.forEach(e -> sum += e);

        double d = Double.valueOf(sum) / Double.valueOf(n);
        System.out.println(Math.round(d));
        Collections.sort(li);
        System.out.println(li.get(li.size()/2));
        Map<Integer, Integer> map = li.stream().collect(
        Collectors.toMap(Function.identity(), value -> 1, Integer::sum)
        );
        int max = Collections.max(map.values());
        List<Integer> maxKeys = new ArrayList<>();
        for (int key : map.keySet()) {
            if (max == map.get(key)) {
                maxKeys.add(key);
            }
        }
        if (maxKeys.size() > 1) {
            Collections.sort(maxKeys);
            System.out.println(maxKeys.get(1));
        } else {
            System.out.println(maxKeys.get(0));
        }
        System.out.println(li.get(li.size()-1) - li.get(0));
    }
}
