package test.coding.study.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> arr = new ArrayList<>();
        String origin = "";
        for (int i = 0; i < 8; i++) {
            String str = sc.next();
            arr.add(str);
            origin+=str;
        }
        String[] array  = arr.toArray(new String[arr.size()]);
        Arrays.sort(array);
        String ascending = String.join("", array);
        Arrays.sort(array, Collections.reverseOrder());
        String decending = String.join("",array);
        if (origin.equals(ascending)) {
            System.out.println("ascending");
        } else if (origin.equals(decending)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
