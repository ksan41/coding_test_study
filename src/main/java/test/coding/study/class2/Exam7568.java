package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dunchi {
    int kg, cm;
    int grade;

    public Dunchi(int kg, int cm) {
        this.kg = kg;
        this.cm = cm;
        this.grade = 1;
    }
}

public class Exam7568 {
    
    // 덩치
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Dunchi[] arr = new Dunchi[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int kg = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());
            arr[i] = new Dunchi(kg, cm);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[j].kg > arr[i].kg && arr[j].cm > arr[i].cm) {
                    arr[i].grade += 1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].grade + " ");
        }
    }
}
