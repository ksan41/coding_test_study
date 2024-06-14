package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exam1764 {
    
    // 듣보잡   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> deut = new HashMap<>();
        Map<String, Integer> bo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            deut.put(br.readLine(), 0);
        }

        for (int i = 0; i < m; i++) {
            bo.put(br.readLine(), 0);
        }

        PriorityQueue<String> queue = new PriorityQueue<>();
        for (String key : deut.keySet()) {
            if (bo.get(key) != null) {
                queue.offer(key);
            }
        }
        
        System.out.println(queue.size());
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
