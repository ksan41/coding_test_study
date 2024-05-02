package test.coding.study.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Exam5 {

    static Map<String, String> convert = new HashMap<>(){{
        put("Enter", "들어왔습니다.");
        put("Leave", "나갔습니다.");
    }};

    // 오픈채팅방
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        List<String> list = new ArrayList<>();

        Map<String,String> names = new HashMap<>();
        Queue<Map<String, String>> queue = new LinkedList<>();

        for (int i = 0; i < record.length; i++) {
            String[] strs = record[i].split(" ");
            Map<String, String> map = new HashMap<>();
            map.put(strs[0], strs[1]);
            queue.offer(map);
            if (strs.length == 3) {
                names.put(strs[1], strs[2]);
            }
        }

        // StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Map<String,String> current = queue.poll();
            for (String key : current.keySet()) {
                if (!key.equals("Change")) {
                    list.add(names.get(current.get(key)) + "님이 " + convert.get(key));
                }
            }
        }

        return list.stream().toArray(String[]::new);
    }
}
