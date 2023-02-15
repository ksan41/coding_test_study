package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Example2164 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> queue= new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while(queue.size() != 1) {
            queue.remove();
            int first = queue.remove();
            queue.add(first);
        }
        System.out.println(queue.element());
    }
}
