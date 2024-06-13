package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam1620 {

    static final String REGEX = "^[0-9]*$";
    static int n, m = 0;
    static Map<String, Integer> strMap;
    static Map<Integer, String> idxMap;

    // 나는야 포켓몬 마스터 이다솜
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        strMap = new HashMap<>();
        idxMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String keyword = br.readLine();
            strMap.put(keyword, i);
            idxMap.put(i, keyword);
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (question.matches(REGEX)) {
                bw.write(idxMap.get(Integer.parseInt(question)));
            } else {
                bw.write(strMap.get(question) + "");
            }
            bw.newLine();
        }
        bw.flush();
    }

}
