package test.coding.study.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exam6 {
    
    // 영어 끝말잇기
    public static void main(String[] args) {
        int n = 2;
        String[] words = {"abc", "dc"};

        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> pastWd = new HashSet<>();

        int rotate = 1;
        int start = 1;
        int end = n - 1;
        if (words[0].length() < 2 || words[0].length() > 50) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        pastWd.add(words[0]);
        String before = words[0];
        while(end <= words.length - 1) {
            for (int i = start; i <= end; i++) {
                if (i > words.length - 1) break;
                if (pastWd.contains(words[i]) ||
                    words[i].length() < 2 ||
                    words[i].length() > 50 || 
                before.charAt(before.length() - 1) != words[i].charAt(0)){
                    answer[0] = i % n + 1;
                    answer[1] = rotate;
                    return answer;
                }
                if (!pastWd.contains(words[i])) {
                    pastWd.add(words[i]);
                } 
                before = words[i];
            }

            start = end + 1;
            end += n;
            rotate++;
        }

        return answer;
    }
}
