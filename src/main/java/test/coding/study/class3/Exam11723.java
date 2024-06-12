package test.coding.study.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam11723 {

    static BufferedWriter bw;
    static Integer[] arr;
    static int size = 0;

    // 집합
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch(command) {
                case "add": add(num); break;
                case "remove": remove(num); break;
                case "check": check(num); break;
                case "toggle": toggle(num); break;
                case "all": all(); break;
                case "empty": empty();
            }
        }

        bw.flush();
    }

    static int find(int num) {
        int idx = -1;
        if (arr != null) {

            Arrays.sort(arr);
    
            int start = 0;
            int end = arr.length - 1;
    
            while (start <= end) {
                int mid = (start + end)/2;
    
                if (num > arr[mid]) {
                    start = mid + 1;
                } else if (num < arr[mid]) {
                    end = mid - 1;
                } else {
                    idx = mid;
                    break;
                }
            }
        }
        return idx;
    }

    static void add(int num) {
        if (size > 0) {
            if (find(num) == -1) {
                size++;
                Integer[] newArr = new Integer[size];
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                newArr[size-1] = num;
                arr = newArr;
            }
        } else {
            size++;
            arr = new Integer[size];
            arr[0] = num;
        }
    }

    static void remove(int num) {
        int idx = find(num);
        if (idx != -1) {
            size--;
            if (size == 0) {
                arr = null;
            } else {
                Integer[] newArr = Arrays.asList(arr).stream()
                    .filter(e -> e != num)
                    .toArray(Integer[]::new);
                arr = newArr;
            }
        }
    }

    static void check(int num) throws IOException{
        if (find(num) == -1) {
            bw.append(0 + "");
        } else {
            bw.append(1 + "");
        }
        bw.newLine();
    }

    static void toggle(int num) {
        if (find(num) != -1) {
            remove(num);
        } else {
            add(num);
        }
    }

    static void all() {
        Integer[] newArr = new Integer[20];
        for (int i = 1; i <= 20; i++) {
            newArr[i-1] = i;
        }
        arr = newArr;
        size = 20;
    }

    static void empty() {
        arr = null;
        size = 0;
    }
}

