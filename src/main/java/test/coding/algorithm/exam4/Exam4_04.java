package test.coding.algorithm.exam4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam4_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        System.out.println(solution(s, t));
        in.close();
        return;
    }

    public static int solution(String s, String t) {
        int answer = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            mapS.put(arr[i], mapS.getOrDefault(arr[i], 0) + 1);
            if (i - start + 1 == t.length()) {
                if (mapS.equals(mapT)) answer++;
                if (mapS.get(arr[start]) > 1) {
                    mapS.put(arr[start], mapS.get(arr[start]) - 1);
                } else {
                    mapS.remove(arr[start]);
                }
                start++;
            }
        }
        return answer;
    }

}
