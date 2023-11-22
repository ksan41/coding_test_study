package test.coding.algorithm.exam4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam4_01 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        System.out.println(solution(n, str));
        return ;
      }

    public static char solution(int n, String str) {
        int max = Integer.MIN_VALUE;
        char answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = Math.max(max, map.get(c));
                answer = c;
            }
        }
        return answer;
    }
}
