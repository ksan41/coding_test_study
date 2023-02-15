package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Example11866 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int index = k-1;
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        while(!queue.isEmpty()) {
            if (index >= queue.size()) {
                while(index >= queue.size()) {
                    index = index - queue.size();
                }
            }
            Iterator<Integer> it = queue.iterator();
            int cnt = 0;
            while(true) {
                if(cnt == index) {
                    int delVal = it.next();
                    sb.append(delVal);
                    queue.remove(delVal);
                    if (!queue.isEmpty()) {
                        sb.append(", ");
                    }
                    break;
                }
                it.next();
                cnt++;
            }

            index += k-1;
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
