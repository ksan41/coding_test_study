package test.coding.study.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int num = sc.nextInt();
            String str = sc.next();
            List<String> arr = Arrays.asList(str.split(""));
            String res = "";
            for (int j = 0; j < arr.size(); j++) {
                for (int j2 = 0; j2 < num; j2++) {
                    res+=arr.get(j);
                }
            }
            resList.add(res);
        }
        for (int i = 0; i < resList.size(); i++) {
            System.out.println(resList.get(i));
        }
    }
}
