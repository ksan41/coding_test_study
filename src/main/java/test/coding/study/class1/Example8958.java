package test.coding.study.class1;

import java.util.Scanner;

public class Example8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String[] arr = new String[cnt];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < arr.length; i++) {
            int score = 0;
            int cont = 1;
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O') {
                    if (j!=0) {
                        if (arr[i].charAt(j-1) == 'O') {
                            cont += 1;
                        }
                    }
                    score += cont;
                } else {
                    cont = 1;
                }
            }
            System.out.println(score);
        }
    }
}
