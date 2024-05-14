package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam15723 {

    static int n, m = 0;
    static char answer;
    static Map<Character, Character> map;

    // n단 논법
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);
            map.put(a, b);
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);
            answer = 'F';
            solution(a, b);
            bw.append(answer + "");
            bw.newLine();
        }
        bw.flush();
    }

    static void solution(char v, char target) {
        while (true) {
            if (map.get(v) == null)
                return;
            char current = map.get(v);
            if (current == target) {
                answer = 'T';
                return;
            }
            v = current;
        }
    }
}
