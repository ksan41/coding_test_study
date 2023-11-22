package test.coding.algorithm.exam4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam4_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(solution(str1, str2));
        return;
    }

    // public static String solution(String str1, String str2) {
    // Map<Character, Integer> map1 = new HashMap<>();
    // Map<Character, Integer> map2 = new HashMap<>();
    // mapping(str1, map1);
    // mapping(str2, map2);

    // for (char key : map1.keySet()) {
    // if (map1.get(key) != map2.getOrDefault(key, 0)) return "NO";
    // }
    // return "YES";
    // }

    public static String solution(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            }
            map.put(c, map.get(c) - 1);
        }
        return "YES";
    }

    // public static void mapping(String str, Map<Character, Integer> map) {
    // for (char c : str.toCharArray()) {
    // map.put(c, map.getOrDefault(c, 0) + 1);
    // }
    // }
}
