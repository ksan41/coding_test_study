package test.coding.algorithm.exam1;

import java.util.Scanner;

public class Exam1_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        System.out.println(solution(s, t));
        return;
    }

    public static String solution(String s, String t) {
        StringBuilder sb = new StringBuilder();

        int currentT = s.indexOf(t);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                sb.append("0 ");
                currentT = i;
            } else {
                if (i < currentT) {
                    sb.append(currentT - i + " ");
                } else {
                    int currentTminus = i - currentT < 0 ? -1 * (i - currentT) : i - currentT;
                    int minus = 0;
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j) == t.charAt(0)) {
                            minus = j - i;
                            break;
                        }
                    }
                    if (minus != 0 && minus < currentTminus) {
                        sb.append(minus + " ");
                    } else {
                        sb.append(currentTminus + " ");
                    }
                }
            }
        }
        return sb.toString();
    }
}
